/**
 * This is the NobilityList class. It contains a list of all the nobility.
 *
 * @author Sujeeth Jinesh
 * @version 3/9/2016
 */
public class NobilityList {

    private Nobility[] list;
    private int numNobility = 0;

    /**
     * This method creates the list of nobility.
     * @param i Number of nobility in the class.
     */

    public NobilityList(int i) {
        list = new Nobility[i];
    }

    /**
     * This method lists all the nobility in order.
     */

    public void listNobilities() {
        int i = 0;
        while (list[i] != null) {
            System.out.println((i + 1) + ". " + list[i].toString());
            i++;
        }

    }

    /**
     * This method adds nobility to the nobility list.
     * @param nob This is the input nobility to be added.
     */
    public void add(Nobility nob) {
        this.list[numNobility++] = nob;
    }
}
