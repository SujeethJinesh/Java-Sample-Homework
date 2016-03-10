/**
 * This is the WesterlandHouse class. It creates the WesterlandHouse.
 *
 * @author Sujeeth Jinesh
 * @version 3/9/2016
 */
public class WesterlandHouse extends House {

    private int goldCount;

    /**
     * This is the WesterlandHouse constructor.
     * @param name This is the name of the WesterlandHouse object.
     * @param words This is the slogan for the WesterlandHouse object.
     * @param knightCount This is the number of knights in the WesterlandHouse
     * object.
     * @param goldCount This is the amount of gold for the WesterlandHouse
     * object.
     */
    public WesterlandHouse(String name, String words, int knightCount,
        int goldCount) {
        super(name, words, knightCount);
        this.goldCount = goldCount;
    }

    /**
     * This returns the string version of the WesterlandHouse object.
     * @return This returns the string version of the WesterlandHouse object.
     */
    @Override
    public String toString() {
        return "Westerland " + super.toString() + " Has " + goldCount
            + " gold coins.";
    }
}
