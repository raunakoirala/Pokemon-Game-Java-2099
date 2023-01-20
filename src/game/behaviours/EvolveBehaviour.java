package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import game.EvolveAction;
import game.time.TimePerceptionManager;



public class EvolveBehaviour implements Behaviour {

    private Actor target;

    public EvolveBehaviour(Actor target) {
        this.target = target;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (TimePerceptionManager.getInstance().turn % 20 == 0) {
            int count = 0;

            for (Exit exit : map.locationOf(actor).getExits()) {//gets all exits around player
                if (!exit.getDestination().containsAnActor()) {
                    count++;
                }
            }

            if (count == 8) {
                return new EvolveAction(target);
            }
        }

        return null;
    }

}
