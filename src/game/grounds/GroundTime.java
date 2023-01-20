package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.time.TimePerception;

/**
 * A class that represents the ground and it changing with day and night effects
 *
 *
 */
public abstract class GroundTime extends Ground implements TimePerception {

    public GroundTime(char displayChar) {
        super(displayChar);
        this.registerInstance();
    }


}
