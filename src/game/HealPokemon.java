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
 * An Action to heal all pokemon through NurseJoy
 * Created by:Raunak Koirala
 */
public class HealPokemon extends Action{

    public HealPokemon() {
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        //all loop processes check for the respective pokemons and replace them with new pokemons (i.e full health pokemons)
        for (int i = 0; i < actor.getInventory().size(); i++) {
            if (actor.getInventory().get(i).toString().contains("Pokeball (Bulbasaur")) {
                actor.removeItemFromInventory(actor.getInventory().get(i));//removes bulbasaur from the inventory
                actor.addItemToInventory(new Pokeball(new Bulbasaur()));//adds fresh bulbasaur to inventory
                break;
            }
        }

        for (int i = 0; i < actor.getInventory().size(); i++) {
            if (actor.getInventory().get(i).toString().contains("Pokeball (Charmander")) {
                actor.removeItemFromInventory(actor.getInventory().get(i));//removes charmander from the inventory
                actor.addItemToInventory(new Pokeball(new Charmander()));//adds fresh charmander to inventory
                break;
            }
        }

        for (int i = 0; i < actor.getInventory().size(); i++) {
            if (actor.getInventory().get(i).toString().contains("Pokeball (Squirtle")) {
                actor.removeItemFromInventory(actor.getInventory().get(i));//removes squirtle from the inventory
                actor.addItemToInventory(new Pokeball(new Squirtle()));//adds fresh squirtle to inventory
                break;
            }
        }

        return "Healed all Pokemon!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " asks NurseJoy to heal all Pokemon!";
    }

}
