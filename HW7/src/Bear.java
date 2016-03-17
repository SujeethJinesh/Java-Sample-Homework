import java.util.Random;

/**
 * This is the Bear class which contains methods inherited from Animal.
 * This class implements the Viewable interface.
 * Worked on this class by myself referencing StackOverflow.com and Java API.
 *
 * @author Sujeeth Jinesh
 * @version 3/11/2016
 */
public class Bear extends Animal implements Viewable {

    private Random rand = new Random();

    /**
     * This is the constructor for the Bear object.
     *
     * @param noise This is the sound that the Bear makes.
     * @param move This is the sound the Bear makes as it moves.
     * @param name This is the name of the Bear object.
     */
    public Bear(String noise, String move, String name) {
        super(noise, move, name);
    }

    /**
     * This method prints out action of the Viewable Bear.
     */
    @Override
    public void view() {
        if (rand.nextInt(PERCENT_OF_TIME_ASLEEP) <= 25) {
            System.out.println("The " + this.getName()
                    + " is asleep.");
            System.out.println("zzz");
        } else {
            System.out.println("The " + this.getName()
                    + " is swimming in the pool.");
            System.out.println(super.makeNoise());
        }
    }
}
