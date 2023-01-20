package game.pokemon;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.AttackAction;
import game.BackupWeapons;
import game.Element;
import game.Status;
import game.actors.Player;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.time.TimePerceptionManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by: Rauank Koirala
 */
public class Squirtle extends Pokemon {
    //FIXME: Change it to a sorted map (is it TreeMap? HashMap? LinkedHashMap?)
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

    Player player;

    /**
     * Constructor.
     */
    public Squirtle() {
        super("Squirtle", 's', 100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.WATER);
        this.behaviours.put(10, new WanderBehaviour());
        this.behaviours.put(11, new AttackBehaviour());
        this.behaviours.put(12, new FollowBehaviour(player));
        this.addCapability(Status.CATCHABLE);
        this.status = Status.CATCHABLE;

    }

    /**
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(this, direction));
        //FIXME: allow other actor to attack this Charmander (incl. Player). Please check requirement! :)
        return actions;
    }

    /**
     * By using behaviour loops, it will decide what will be the next action automatically.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * @param isEquipping FIXME: develop a logic to toggle weapon (put a selected weapon to the inventory - used!);
     */
    public void toggleWeapon(boolean isEquipping) {

        if (isEquipping)
        {
        this.inventory.add(new BackupWeapons(this.element));
        }

    }

    /**
     * This method creates new instance of pokemons intrinsic weapon
     *
     *
     * @return Intrinsic Weapon
     */
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");

    }


    public void dayEffect() {
        this.hurt(10);
    }
    public void nightEffect() {
        this.heal(10);

    }


    /**
     * This method is for returning the Squirtle as string to display to user
     *
     *
     * @return Squirtle
     */

    public String toString(){
        return "Squirtle" +  this.printHp();
    }

}
