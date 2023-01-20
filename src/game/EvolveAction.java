package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.pokemon.Charmeleon;

public class EvolveAction extends Action {
    private Actor target;

    public EvolveAction(Actor target) {
        this.target = target;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";

        Location location = map.locationOf(actor);
        map.removeActor(actor);
        map.addActor(target, location);


        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}

