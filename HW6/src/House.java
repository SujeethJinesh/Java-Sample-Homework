/**
 * This is the House class. It constructs the House object.
 *
 * @author Sujeeth Jinesh
 * @version 3/9/2016
 */
public class House extends Nobility {

    private String words;
    private int knightCount;

    /**
     * This is the constructor for the House class.
     * @param baratheon This is the baratheon for the House object.
     * @param s This is the slogan the House has.
     * @param i This is the number of knights the house contains.
     */

    public House(String baratheon, String s, int i) {
        super(baratheon);
        this.words = s;
        this.knightCount = i;
    }

    /**
     * This returns a string version of the House object.
     * @return This returns a string version of the House object.
     */
    @Override
    public String toString() {
        return "House " + super.toString().substring(0,
            super.toString().length() - 1) + ": " + words + ". Has "
            + knightCount + " knights.";
    }
}
