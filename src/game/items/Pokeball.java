package game.items;


import edu.monash.fit2099.engine.items.*;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import edu.monash.fit2099.engine.actors.Actor;
import game.Status;
import game.actors.Player;


public class Pokeball extends Item{
    /**
     * Constructor for Pokefruit
     *
     * @param actor        Pokemon stored in the PokeBall
     */
    public Pokeball(Actor actor) {
        super("Pokeball" + " (" + actor + ")", '0', true);

    }


}
