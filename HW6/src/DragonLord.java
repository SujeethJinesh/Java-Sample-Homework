/**
 * This is the DragonLord class. It creates a DragonLord object.
 *
 * @author Sujeeth Jinesh
 * @version 3/9/2016
 */
public class DragonLord extends Nobility {

    private boolean isFireResistant;
    private int dragonCount;
    private String name;

    /**
     * This is the constructor for the DragonLord object.
     * @param name This is the name of the DragonLord object
     * @param isFireResistant This boolean is whether or not the DragonLord is
     * fire resistant
     * @param dragonCount This gets the number of dragons the DragonLord has
     */
    public DragonLord(String name, boolean isFireResistant, int dragonCount) {
        super(name);
        this.isFireResistant = isFireResistant;
        this.dragonCount = dragonCount;
    }

    /**
     * This method converts a DragonLord object into a string.
     * @return This returns the String version of DragonLord
     */
    @Override
    public String toString() {

        String phrase = "DragonLord " + super.toString() + " Has "
                + dragonCount + " dragons. ";

        if (isFireResistant) {
            return phrase + "Is fire resistant";

        }
        return phrase + "Isn't fire resistant";
    }
}
