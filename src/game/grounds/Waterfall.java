package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.items.Pokefruit;
import game.pokemon.Charmander;
import game.pokemon.Squirtle;

import java.util.Random;

/**
 * Class representing the ground waterfall
 *
 */
public class Waterfall extends Ground {


    Random rand = new Random();

    /**
     * Constructor.
     */
    public Waterfall() {
        super('W');
        this.addCapability(Element.WATER);

    }


    /**
     * This method is for checking every turn if there is a possibility to spawn a Charmander or a Pokefruit at ground based on probability
     *
     * @param location gets the location of ground
     *
     * @return void
     */
    public void tick(Location location){ //Add at least 2

        if(rand.nextInt(101) <= 20){
            if(!location.containsAnActor()) location.addActor(new Squirtle());
        }

        int count = 0;//implemented to count the amount of grounds in surrounding grounds with water

        for(int i = 0; i < location.getExits().size(); i++) {
            Location destination = location.getExits().get(i).getDestination();

            if (destination.getGround().hasCapability(Element.WATER)) {
                count += 1;
                if(rand.nextInt(101) <= 20 && count >= 2) { //count there to ensure 2 grounds have water element capability
                    if (!location.containsAnActor()) {
                        location.addItem(new Pokefruit(Element.WATER));
                        this.addCapability(Element.WATER);
                    }
                }
            }
        }
    }

}
