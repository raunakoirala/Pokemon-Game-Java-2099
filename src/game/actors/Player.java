package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.items.Item;
import game.CatchAction;
import game.FeedFruit;
import game.Status;
import game.SummonPokemon;
import game.grounds.Crater;
import game.grounds.Tree;
import game.items.Pokeball;
import game.pokemon.Bulbasaur;
import game.pokemon.Charmander;
import game.pokemon.Pikachu;
import game.pokemon.Squirtle;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.*;

import java.util.Random;

/**
 * Class representing the Player.
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * Raunak Koirala
 *
 */
public class Player extends Actor {

	/**
	 * Creates new menu instance
	 */
	private final Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.IMMUNE);

		//registerInstance();
	}



	/**
	 * Select and return an action to perform on the current turn.
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();


		//for loop to check all directions and see if there is pokemon present, then calls new CatchAction to give user choice of catching the pokemon
		for (Exit exit : map.locationOf(this).getExits()){
			if (exit.getDestination().getDisplayChar() == 'b'){//if pokemon has certain character initiate catach action (catachble is checked in the catch action class)
				Item bulbPokeball = new Pokeball(exit.getDestination().getActor());
				actions.add(new CatchAction(exit.getDestination().getActor(), bulbPokeball));
				actions.add(new FeedFruit(new Bulbasaur()));
			}
			if (exit.getDestination().getDisplayChar() == 'c'){//if pokemon has certain character initiate catach action (catachble is checked in the catch action class)
				Item charPokeball = new Pokeball(exit.getDestination().getActor());
				actions.add(new CatchAction(exit.getDestination().getActor(), charPokeball));
				actions.add(new FeedFruit(exit.getDestination().getActor()));
			}
			if (exit.getDestination().getDisplayChar() == 's'){//if pokemon has certain character initiate catach action (catachble is checked in the catch action class)
				Item squiPokeball = new Pokeball(exit.getDestination().getActor());
				actions.add(new CatchAction(exit.getDestination().getActor(), squiPokeball));
				actions.add(new FeedFruit(exit.getDestination().getActor()));
			}
			if (exit.getDestination().getDisplayChar() == 'p'){//if pokemon has certain character initiate catach action (catachble is checked in the catch action class)
				actions.add(new FeedFruit(exit.getDestination().getActor()));
			}

		}

		String invent = "" + getInventory();//lets inventory become string to make easier checks for items


		if(invent.contains("Pokeball (Bulbasaur(")){
			actions.add(new SummonPokemon(new Bulbasaur()));
		}

		if(invent.contains("Pokeball (Charmander(")){
			actions.add(new SummonPokemon(new Charmander()));
		}
		if(invent.contains("Pokeball (Squirtle(")){
			actions.add(new SummonPokemon(new Squirtle()));
		}
		if(invent.contains("Pokeball (Pikachu(")){
			actions.add(new SummonPokemon(new Pikachu()));
		}




		System.out.println("inventory: " + getInventory());

		// compute day/night cycle on every scanner input
		TimePerceptionManager.getInstance().run();

		// return/print the console menu
		return menu.showMenu(this, actions, display);

	}

	@Override
	public char getDisplayChar() {
		return super.getDisplayChar();
	}//returns player display character
}
