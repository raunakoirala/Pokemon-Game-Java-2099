package game.items;


import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.Element;

public class Pokefruit extends Item{
    /**
     * Constructor for Pokefruit
     *
     * @param Element   Element of the Pokefruit
     */
    public Pokefruit(Enum Element) {
        super(Element + " Pokefruit", 'f', true);
    }


}
