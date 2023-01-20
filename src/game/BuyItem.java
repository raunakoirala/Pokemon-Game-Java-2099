package game;

import java.util.*;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.items.Candy;
import game.items.Pokeball;
import game.pokemon.Bulbasaur;
import game.pokemon.Charmander;
import game.pokemon.Squirtle;

/**
 * An Action to buy from NurseJoy
 * Created by:Raunak Koirala
 */
public class BuyItem extends Action {

    /**
     * Item you are buying
     */
    protected Item item;

    /**
     * The cost of the item you are buying
     */
    protected int cost;

    /**
     * Constructor.
     *
     * @param item      Item you are buying
     * @param cost      The cost of the item you are buying
     */
    public BuyItem(Item item, int cost) {
        this.item = item;
        this.cost = cost;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        String result = "";//used to print final result


        String invent = "" + actor.getInventory();


        int count = 0; //established to count amount of candies a player has

        for(int i = 0; i < actor.getInventory().size(); i++){//for loop goes through inventory and counts amount of candies

            if (actor.getInventory().get(i).toString() == "Candy"){//increased count if candy is found
                count += 1;
            }
        }

        if (count >= 1 && cost == 1){//if a player has at least one candy and is trying to buy a pokefruit, then allow them

            if(invent.contains("Candy")) {

                for (int i = 0; i < actor.getInventory().size(); i++) {
                    if (actor.getInventory().get(i).toString().contains("Candy")) {
                        actor.removeItemFromInventory(actor.getInventory().get(i));//removes candy from the inventory
                        break;
                    }
                }
            }
            actor.addItemToInventory(item);//adds the pokefruit to the inventory
            result = actor + " bought " + item;

        }

        else if (count >= 5 && cost == 5){//if a player has at least five candy and is trying to buy a pokeball, then allow them

            for(int i = 0; i < 4; i++){//loops 5 times to remove 5 candies

                for (int j = 0; j < actor.getInventory().size(); j++) {
                    if (actor.getInventory().get(j).toString().contains("Candy")) {
                        actor.removeItemFromInventory(actor.getInventory().get(j));//removes candy from the inventory
                        break;
                    }
                }

            }

            actor.addItemToInventory(item);
            result = actor + " bought " + item;
        }

        else {
            result = actor + " doesn't have enough candy!";//prints this if player doesn't have required amount of candies

        }

        return result;
    }


    @Override
    public String menuDescription(Actor actor) {
        return actor + " trades for " + item + " with " + cost + " candy.";
    }
}
