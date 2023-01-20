package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.items.Candy;
import game.items.Pokefruit;
import game.pokemon.Bulbasaur;
import game.pokemon.Squirtle;
import game.time.TimePerceptionManager;

import java.util.Random;

/**
 * Class representing the ground Tree
 *
 */
public class Tree extends GroundTime {


    Random rand = new Random();

    /**
     * Constructor.
     *
     */

    public Tree() {
        super('T');
        this.addCapability(Element.GRASS);
        TimePerceptionManager.getInstance().registerInstance();
    }

    /**
     * This method is for checking every turn if there is a possibility to spawn a Charmander or a Pokefruit at ground based on probability
     *
     * @param location gets the location of ground
     *
     * @return void
     */
    public void tick(Location location){

        if(rand.nextInt(101) <= 20){
            if(!location.containsAnActor()) location.addActor(new Bulbasaur());
        }

        for(int i = 0; i < location.getExits().size(); i++) {
            Location destination = location.getExits().get(i).getDestination();

            if (destination.getGround().hasCapability(Element.GRASS)) {
                if(rand.nextInt(101) <= 20) {
                    if (!location.containsAnActor()) {
                        location.addItem(new Pokefruit(Element.GRASS));
                        this.addCapability(Element.GRASS);
                    }
                }
            }
        }
    }

    @Override
    public void dayEffect() {
//
//       for (int i = 0; i < location.getExits().size(); i++) {
//            Location destination = location.getExits().get(i).getDestination();
//
//            destination.addItem(new Candy());
//        }

    }

    @Override
    public void nightEffect() {

//        for (int i = 0; i < location.getExits().size(); i++) {
//            Location destination = location.getExits().get(i).getDestination();
//
//            destination.setGround(this); //or hay
//        }


    }

}
