import java.util.Random;

/**
 * This is the Pony class which contains methods that all inherit from Animal.
 * This class implements the Pettable and Feedable interfaces.
 * Worked on this class by myself referencing StackOverflow.com and Java API.
 *
 * @author Sujeeth Jinesh
 * @version 3/11/2016
 */
public class Pony extends Animal implements Pettable, Feedable {

    private Random rand = new Random();

    /**
     * This is the constructor for the Pony object.
     * @param noise This is the noise that the Pony makes.
     * @param move This is the noise that the Pony makes as it moves.
     * @param name This is the name of the Pony.
     */
    public Pony(String noise, String move, String name) {
        super(noise, move, name);
    }

    /**
     * This is the implementation of the pet method
     * that displays what the Animal does
     * as it's being pet.
     */
    @Override
    public void pet() {
        System.out.println("You pet the " + this.getName()
                + " for " + super.MAX_TIME_PETTABLE + " minutes.");
        System.out.println(super.makeNoise());
        System.out.println("The " + this.getName()
                + " shuffles closer to you.");
    }

    /**
     * This is the implementation of
     * the feed method that displays what the Animal does
     * as it is being fed.
     */
    @Override
    public void feed() {
        System.out.println("You feed the pony "
                + (rand.nextInt(MAX_AMOUNT_OF_FOOD) + 1) + " pieces of hay.");
        System.out.println(super.makeNoise());
        System.out.println("The " + this.getName()
                + " " + this.getMove() + " away.");
    }
}
