import java.util.Random;

/**
 * This is the Sheep class which contains methods that all inherit from Animal.
 * This class implements the Viewable interface.
 * Worked on this class by myself referencing StackOverflow.com and Java API.
 *
 * @author Sujeeth Jinesh
 * @version 3/11/2016
 */
public class Tiger extends Animal implements Viewable {

    private Random rand = new Random();

    /**
     * This is the Tiger object constructor.
     * @param noise This is the noise the Tiger makes.
     * @param move This is the noise the Tiger makes as it moves.
     * @param name This is the name of the Tiger.
     */
    public Tiger(String noise, String move, String name) {
        super(noise, move, name);
    }

    /**
     * This is the implementation of the View method.
     * This displays what the Tiger does as it is being viewed.
     */
    @Override
    public void view() {
        if (rand.nextInt(PERCENT_OF_TIME_ASLEEP) <= 50) {
            System.out.println("The " + this.getName()
                    + " is asleep.");
            System.out.println("zzz");
        } else {
            System.out.println("The " + this.getName()
                    + " is running across the field.");
            System.out.println(super.makeNoise());
        }
    }
}
