package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;

import edu.monash.fit2099.engine.positions.Location;
import game.items.Pokefruit;
import game.pokemon.Charmander;

import java.util.Random;

/**
 * Class representing the ground Crater
 *
 */
public class Crater extends Ground {

    Random rand = new Random();

    /**
     * Constructor.
     */
    public Crater() {
        super('O');

    }

    /**
     * This method is for checking every turn if there is a possibility to spawn a Charmander or a Pokefruit at ground based on probability
     *
     * @param location gets the location of ground
     *
     * @return void
     */
    public void tick(Location location){

        //10% chance to spawn charmander
        if(rand.nextInt(101) <= 10){
            if(!location.containsAnActor()) location.addActor(new Charmander());
        }


        //20% chance to spawn Fire Pokefruit
        if(rand.nextInt(101) <= 20){
            if(!location.containsAnActor()){
                location.addItem(new Pokefruit(Element.FIRE));
                this.addCapability(Element.FIRE);
            }
        }


    }




}

