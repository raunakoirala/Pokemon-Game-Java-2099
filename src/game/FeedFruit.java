package game;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actors.Player;
import game.items.Pokeball;
import game.items.Pokefruit;
import game.pokemon.Bulbasaur;
import game.pokemon.Charmander;
import game.pokemon.Pokemon;
import game.pokemon.Squirtle;

/**
 * An Action to feed a pokemon a pokeball
 * Created by:Raunak Koirala
 */
public class FeedFruit extends Action {

    /**
     * The Pokemon that is to be fed
     */
    protected Actor target;


    /**
     * Constructor.
     *
     * @param target      Pokemon being fed
     */
    public FeedFruit(Actor target) {
        this.target = target;

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        AffectionManager affectionManager = AffectionManager.getInstance();
        String invent = "" + actor.getInventory();

        if(invent.contains("Pokefruit")){ //checks for pokefruit


            for(int i = 0; i < actor.getInventory().size(); i++){

                if(actor.getInventory().get(i).toString().contains("Fire Pokefruit")){
                    if(target.hasCapability(Element.FIRE)) {
                        affectionManager.increaseAffection(target, 20);
                        actor.removeItemFromInventory(actor.getInventory().get(i));
                        return target.toString() + " was fed the Fire Pokefruit. Affection increased by 20 points";
                    }
                    else{
                        affectionManager.decreaseAffection(target, 10);
                        return target.toString() + " was fed the Fire Pokefruit. Affection decreased by 10 points";
                    }
                }
                if(actor.getInventory().get(i).toString().contains("Water Pokefruit")){
                    if(target.hasCapability(Element.WATER)) {
                        affectionManager.increaseAffection(target, 20);
                        actor.removeItemFromInventory(actor.getInventory().get(i));
                        return target.toString() + " was fed the Water Pokefruit. Affection increased by 20 points";
                    }
                    else{
                        affectionManager.decreaseAffection(target, 10);
                        return target.toString() +  " was fed the Water Pokefruit. Affection decreased by 10 points";
                    }
                }
                if(actor.getInventory().get(i).toString().contains("Grass Pokefruit")){
                    if(target.hasCapability(Element.GRASS)) {
                        affectionManager.increaseAffection(target, 20);
                        actor.removeItemFromInventory(actor.getInventory().get(i));
                        return target.toString() +  " was fed the Grass Pokefruit. Affection increased by 20 points";
                    }
                    else{
                        affectionManager.decreaseAffection(target, 10);
                        return target.toString() +  " was fed the Grass Pokefruit. Affection decreased by 10 points";
                    }
                }
            }

        }

        return "Player doesn't have Pokefruit";
    }


    @Override
    public String menuDescription(Actor actor) {
        return actor + " feeds " + target;
    }
}
