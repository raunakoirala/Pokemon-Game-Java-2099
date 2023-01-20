package game.grounds;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.items.Pokefruit;
import game.pokemon.Bulbasaur;
import game.pokemon.Charmander;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.time.TimePeriod;

import java.sql.Time;
import java.util.Random;


/**
 * Class representing the ground Crater
 *
 */
public class Lava extends GroundTime {

    /**
     * Constructor.
     *
     */
    public Lava() {
        super('^');
        this.addCapability(Element.FIRE);
    }

    Random rand = new Random();


    @Override
    public void dayEffect() {
//
//        for (int i = 0; i < location.getExits().size(); i++) {
//            Location destination = location.getExits().get(i).getDestination();
//
//            destination.setGround(this);
//        }

    }

    @Override
    public void nightEffect() {

//        if (location.containsAnActor() == false) {
//            location.setGround(new Dirt());
//        }
//
//
    }
}
