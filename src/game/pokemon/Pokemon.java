package game.pokemon;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.AffectionManager;
import game.Element;

import game.Status;
import game.time.TimePerception;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon extends Actor implements TimePerception {


    public Status status;

    public List<Item> inventory = new ArrayList<>();

    public Element element;

    public Pokemon(String name, char displaychar, int hitPoints){

        super(name, displaychar, hitPoints);
        this.registerInstance();
    }
    public abstract void toggleWeapon(boolean isEquipping);
    public void setStatus(Status status) {
        this.status = status;
    }

    public abstract IntrinsicWeapon getIntrinsicWeapon();

}
