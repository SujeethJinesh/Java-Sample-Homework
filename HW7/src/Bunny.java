import java.util.Random;

/**
 * This is the Bunny class which contains methods
 * that all inherited from Animal.
 * This class implements the Viewable interface.
 * Worked on this class by myself referencing StackOverflow.com and Java API.
 *
 * @author Sujeeth Jinesh
 * @version 3/11/2016
 */
public class Bunny extends Animal implements Viewable {

    private Random rand = new Random();

    /**
     * Constructor for Bunny object.
     * @param noise This is the noise that the Bunny makes.
     * @param move This is the noise that the Bunny makes as it moves.
     * @param name This is the name of the Bunny object.
     */
    public Bunny(String noise, String move, String name) {
        super(noise, move, name);
    }


    /**
     * This method prints out action of the Viewable Bunny.
     */
    @Override
    public void view() {

        if (rand.nextInt(PERCENT_OF_TIME_ASLEEP) <= 50) {
            System.out.println("The " + this.getName()
                    + " is asleep.");
            System.out.println("zzz\n");
            System.out.println("(\\_/)\n"
                    + "(-x-)");
        } else {
            System.out.println("The " + this.getName()
                    + " is hopping across the field.");
            System.out.println(super.makeNoise() + "\n");
            System.out.println("(\\_/)\n"
                    + "('x')");
        }
    }
}
