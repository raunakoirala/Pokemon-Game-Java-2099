package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.*;
import game.AttackAction;
import game.pokemon.Charmander;
import game.pokemon.Pokemon;

import java.util.ArrayList;

/**
 * AttackBehaviour of pokemon
 *
 */
public class AttackBehaviour implements Behaviour {

    /**
     *  HINT: develop a logic to check surrounding, check elements, and return an action to attack that opponent.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        ArrayList<Action> actions = new ArrayList<>();

        for (Exit exit : map.locationOf(actor).getExits()) {//gets all exits around player
            if (exit.getDestination().containsAnActor()) {//checks if pokemon is in the adjacent squares
                Actor target = exit.getDestination().getActor();
                if (actor instanceof Pokemon) {
                    ArrayList<Element> element = new ArrayList<>();
                    element.add(((Pokemon) actor).element);
                    if (ElementsHelper.hasAnySimilarElements(exit.getDestination().getGround(), element)) {
                        ((Pokemon) actor).toggleWeapon(true);
                    }
                }
                actions.add(new AttackAction(target, "here"));
            }
        }
        if (!actions.isEmpty()) {
            return actions.get(0);
        } else {

            return null; // go to next behaviour
        }
    }




}