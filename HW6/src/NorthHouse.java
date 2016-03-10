/**
 * This is the NorthHouse class. It creats NorthHouse objects.
 *
 * @author Sujeeth Jinesh
 * @version 3/9/2016
 */
public class NorthHouse extends House {

    private ColdResistance coldResistance;
    private boolean wargAbility;

    /**
     * This is the class that defines a NorthHouse object.
     * @param name This is the name for the NorthHouse object.
     * @param words This is the slogan for the NorthHouse object.
     * @param knightCount This is the number of knights in the NorthHouse.
     * @param coldResistance This is whether the NorthHouse has cold Resistance.
     * @param wargAbility this is the wargability of the NorthHouse object.
     */
    public NorthHouse(String name, String words, int knightCount,
        ColdResistance coldResistance, boolean wargAbility) {
        super(name, words, knightCount);
        this.coldResistance = coldResistance;
        this.wargAbility = wargAbility;
    }

    /**
     * This converts the NorthHouse object to a string.
     * @return This converts the NorthHouse object to a string.
     */
    @Override
    public String toString() {

        String phrase = super.toString() + " Has " + coldResistance
            + " coldResistance. ";

        if (wargAbility) {
            return "North " + phrase + "Has warg abilities.";
        }

        return "North " + phrase + "Does not have warg abilities.";
    }
}
