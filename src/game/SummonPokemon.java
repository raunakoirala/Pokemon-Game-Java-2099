package game;

import java.util.List;
import java.util.Random;

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
 * An Action to attack another Actor.
 * Created by:Raunak Koirala
 */
public class SummonPokemon extends Action {

    /**
     * The Pokemon that is to be caught
     */
    protected Actor target;

    /**
     * The item(pokeball) used to store the pokemon
     */

    public SummonPokemon(Actor target) {
        this.target = target;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        for (Exit exit : map.locationOf(actor).getExits()) {
            if (exit.getDestination().containsAnActor() == false) {


                String invent = "" + actor.getInventory();

                if(invent.contains("Pokeball (Bulbasaur(")){


                for(int i = 0; i < actor.getInventory().size(); i++){
                    if(actor.getInventory().get(i).toString().contains("Pokeball (Bulbasaur")){
                        actor.removeItemFromInventory(actor.getInventory().get(i));
                        break;
                    }
                }

                }

                else if(invent.contains("Pokeball (Charmander(")){


                    for(int i = 0; i < actor.getInventory().size(); i++){
                        if(actor.getInventory().get(i).toString().contains("Pokeball (Charmander(")){
                            actor.removeItemFromInventory(actor.getInventory().get(i));
                            break;
                        }
                    }

                }

                else if(invent.contains("Pokeball (Squirtle(")){


                    for(int i = 0; i < actor.getInventory().size(); i++){
                        if(actor.getInventory().get(i).toString().contains("Pokeball (Squirtle(")){
                            actor.removeItemFromInventory(actor.getInventory().get(i));
                            break;
                        }
                    }

                }

                else if(invent.contains("Pokeball (Pikachu(")){


                    for(int i = 0; i < actor.getInventory().size(); i++){
                        if(actor.getInventory().get(i).toString().contains("Pokeball (Pikachu(")){
                            actor.removeItemFromInventory(actor.getInventory().get(i));
                            break;
                        }
                    }

                }

                map.addActor(target, exit.getDestination());
                map.locationOf(actor).addItem(new Candy());//candy dropped where player is standing
                break;
            }
        }

        result += System.lineSeparator() + "I choose you... " + target ;

        return result;
    }


    @Override
    public String menuDescription(Actor actor) {
        return actor + " summons " + target;
    }
}
