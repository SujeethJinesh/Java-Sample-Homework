/**
 * This is the Nobility class. It creates Nobility objects.
 *
 * @author Sujeeth Jinesh
 * @version 3/9/2016
 */
public class Nobility {

    private String name = "";

    /**
     * This is the Nobility constructor.
     * @param name This is the name of the Nobility object.
     */
    public Nobility(String name) {
        this.setName(name);
    }

    /**
     * This sets the name for the Nobility object.
     * @param newName This is the name for the Nobility to be set.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * This gets the name for the Nobility object.
     * @return this returns the name of the Nobility object.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This returns a string version of the Nobility class.
     * @return This returns a string version of the Nobility class.
     */
    @Override
    public String toString() {
        return this.getName() + ".";
    }
}