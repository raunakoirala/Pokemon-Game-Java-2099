package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Class representing walls in map
 *
 */
public class Wall extends Ground {

	/**
	 * Constructor.
	 *
	 */
	public Wall() {
		super('#');
	}


	/**
	 * Override this to implement impassable terrain, or terrain that is only passable if conditions are met.
	 *
	 * @param actor the Actor to check
	 * @return true
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}


	/**
	 * Override this to implement terrain that blocks thrown objects but not movement, or vice versa
	 * @return true
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
