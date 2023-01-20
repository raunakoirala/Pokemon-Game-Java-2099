package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;

/**
 * Class representing the ground Hay
 *
 */
public class Hay extends Ground {
    /**
     * Constructor.
     */
    public Hay() {
        super(',');
        this.addCapability(Element.GRASS);

    }
}
