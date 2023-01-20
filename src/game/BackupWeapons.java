package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 * TODO: Use this class to store Pokemon's weapons (special attack) permanently.
 * If a Pokemon needs to use a weapon, put it into that Pokemon's inventory.
 * @see Actor#getWeapon() method.
 * @see AttackAction uses getWeapon() in the execute() method.
 */
public class BackupWeapons extends Item implements Weapon {

    /**
     * integer to represent damage by weapon attack
     */
    public int damage;

    /**
     * verb of attack action
     */
    public String verb;

    /**
     * integer representing the chance to land the attack
     */
    public int chanceToHit;

    /**
     * integer representing the element and thus pokemon with the weapon
     */
    Element element;

    public BackupWeapons(Element element){
        super("Special Attack", 'X', true);
        this.element = element;

        if (this.element == Element.FIRE) {
            this.damage = 20;
            this.chanceToHit = 90;
            this.verb = "sparks";
        }

        else if (this.element == Element.GRASS) {
            this.damage = 30;
            this.chanceToHit = 70;
            this.verb = "whips";
        }


        else if (this.element == Element.WATER){
            this.damage = 25;
            this.chanceToHit = 80;
            this.verb = "burbles";
        }

        else if (this.element == Element.ELECTRIC){
            this.damage = 80;
            this.chanceToHit = 20;
            this.verb = "lightning";
        }



    }

    @Override
    public int damage() {
        return damage;
    }

    @Override
    public String verb() {
        return verb;
    }

    @Override
    public int chanceToHit() {
        return chanceToHit;
    }
}

