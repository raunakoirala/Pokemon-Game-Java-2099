package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.EnterDoor;


/**
 * Class representing the ground Entrancedoor
 *
 */
public class EntranceDoor extends Ground {

    /**
     * x and y xoordinates on map
     */
    private int x;
    private int y;

    /**
     * Map that the player wishes to go to
     */
    private GameMap targetMap;


    public EntranceDoor(int x, int y ,GameMap targetMap) {
        super('=');
        this.x = x;
        this.y = y;
        this.targetMap = targetMap;
    }


    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actionList = new ActionList();

        actionList.add(new EnterDoor(x, y, targetMap));//adds action for player to interact with ground when nearby

        return actionList;
    }


    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }//ensures player cannot enter position


}
