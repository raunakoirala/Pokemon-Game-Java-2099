package game;

/**
 * An enum to store the elements
 */
public enum Element {
    WATER("Water"),
    FIRE("Fire"),
    GRASS("Grass"),
    ELECTRIC("Electric");


    /**
     * stores label of elements from enum as string
     */
    private final String label;

    /**
     * Constructor
     *
     * @param label
     */
    Element(String label){
        this.label = label;
    }

    /**Method to return element as string
     *
     * @return the label text
     */
    @Override
    public String toString() {
        return label;
    }
}
