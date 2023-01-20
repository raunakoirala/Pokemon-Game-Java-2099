package game.actors;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.BuyItem;
import game.Element;
import game.HealPokemon;
import game.Status;
import game.items.Pokeball;
import game.items.Pokefruit;
import game.pokemon.Bulbasaur;
import game.pokemon.Charmander;
import game.pokemon.Pikachu;
import game.pokemon.Squirtle;

/**
 * Class representing the NurseJoy trader.
 *
 * Created by:Raunak Koirala
 *
 */
public class NurseJoy extends Actor{

    /**
     * Constructor for NurseJoy
     *
     * @param name        Name to call the trader in the UI
     * @param displayChar Character to represent the trader in the UI
     * @param hitPoints   NurseJoy's starting number of hitpoints
     */
    public NurseJoy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.IMMUNE); //NurseJoy cannot be harmed and so we add immune status capability
    }


    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new BuyItem(new Pokefruit(Element.FIRE), 1));
        actions.add(new BuyItem(new Pokefruit(Element.WATER), 1));
        actions.add(new BuyItem(new Pokefruit(Element.GRASS), 1));
        actions.add(new BuyItem(new Pokefruit(Element.ELECTRIC), 1));
        actions.add(new BuyItem(new Pokeball(new Pikachu()), 6));
        actions.add(new BuyItem(new Pokeball(new Charmander()), 5));
        actions.add(new BuyItem(new Pokeball(new Squirtle()), 5));
        actions.add(new BuyItem(new Pokeball(new Bulbasaur()), 5));
        actions.add(new HealPokemon());
        return actions;
    }


}