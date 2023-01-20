package game;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.items.Pokeball;
import game.pokemon.Bulbasaur;
import game.pokemon.Charmander;
import game.pokemon.Squirtle;

/**
 * An Action to catch a pokemon using a pokeball.
 * Created by:Raunak Koirala
 */
public class CatchAction extends Action {

    /**
     * The Pokemon that is to be caught
     */
    protected Actor target;

    /**
     * The item(pokeball) used to store the pokemon
     */
    protected Item item;

    /**
     * Constructor.
     *
     * @param target      Pokemon being caught
     * @param item        Pokeball used
     */
    public CatchAction(Actor target, Item item) {
        this.target = target;
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        AffectionManager affectionManager = AffectionManager.getInstance();
        for (Exit exit : map.locationOf(actor).getExits()) {//gets all exits around player

            if(exit.getDestination().containsAnActor()) {//first checks if pokemon is in the adjacent squares
                if (exit.getDestination().getDisplayChar() == 'b' && exit.getDestination().getActor().hasCapability(Status.CATCHABLE)) {//checks that pokemon is catchable
                    actor.addItemToInventory(item);//adds pokeball with pokemon to inventory
                    map.removeActor(exit.getDestination().getActor());//removes the caught pokemon from the map as it is now in the ball
                    break;
                }
                else{
                    return "Cannot catch this pokemon";
                }
            }

            if(exit.getDestination().containsAnActor()) {
                if (exit.getDestination().getDisplayChar() == 'c' && exit.getDestination().getActor().hasCapability(Status.CATCHABLE)) {
                    actor.addItemToInventory(item);
                    map.removeActor(exit.getDestination().getActor());
                    break;
                }
                else{
                    return "Cannot catch this pokemon";//this should print at the start as these are set to non-catchable at the start
                }
            }

            if(exit.getDestination().containsAnActor()) {
                if (exit.getDestination().getDisplayChar() == 's' && exit.getDestination().getActor().hasCapability(Status.CATCHABLE)) {
                    actor.addItemToInventory(item);
                    map.removeActor(exit.getDestination().getActor());
                    break;
                }
                else{
                    return "Cannot catch this pokemon";
                }
            }


        }

        result += System.lineSeparator() + target + " is caught.";

        return result;
    }


    @Override
    public String menuDescription(Actor actor) {
        return actor + " catches " + target;
    }
}
