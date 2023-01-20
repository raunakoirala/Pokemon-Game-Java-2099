package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;
import game.time.TimePerceptionManager;

/**
 * Class representing the ground Puddle
 *
 */
public class Puddle extends GroundTime {
    /**
     * Constructor.
     *
     */
    public Puddle() {

        super('~');
        this.addCapability(Element.WATER);
        TimePerceptionManager.getInstance().registerInstance();
    }

    @Override
    public void dayEffect() {

//        if (location.containsAnActor() == false) {
//            location.setGround(new Dirt());
//        }

    }

    @Override
    public void nightEffect() {

//        for (int i = 0; i < location.getExits().size(); i++) {
//            Location destination = location.getExits().get(i).getDestination();
//
//            destination.setGround(this);
//        }


    }
}
