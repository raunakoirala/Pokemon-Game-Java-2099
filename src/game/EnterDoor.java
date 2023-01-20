package game;


import edu.monash.fit2099.engine.actions.Action;

import edu.monash.fit2099.engine.actors.Actor;

import edu.monash.fit2099.engine.positions.GameMap;


/**
 * An Action to enter the door by a player
 * Created by:Raunak Koirala
 */
public class EnterDoor extends Action{

    /**
     * x and y xoordinates on map
     */
    private int x;
    private int y;

    /**
     * Map that the player wishes to go to
     */
    private GameMap targetMap;
    public EnterDoor(int x, int y ,GameMap targetMap) {
        this.x = x;
        this.y = y;
        this.targetMap = targetMap;
    }


    @Override
    public String execute(Actor actor, GameMap map) {

        if (targetMap.at(x,y).containsAnActor()){//if player nearby door, allow them to use it and remove them from the existing map
            targetMap.removeActor(targetMap.at(x,y).getActor());
        }
        map.removeActor(actor);

        targetMap.addActor(actor, targetMap.at(x,y));//place player in the other map
        return actor + " " + menuDescription(actor);

    }

    @Override
    public String menuDescription(Actor actor) {
        if (targetMap.at(9,2).containsAnActor()){//checks for NurseJoy, if its at center, player is in town, otherwise they are in the center
            return "Ash enters Pokemon Center";
        }
        return "Ash enters Pallet Town";
    }

}
