import java.util.Random;

/**
 * This is the Sheep class which contains
 * methods that all inherit from Animal.
 * This class implements the Pettable interface.
 * Worked on this class by myself referencing StackOverflow.com and Java API.
 *
 * @author Sujeeth Jinesh
 * @version 3/11/2016
 */
public class Sheep extends Animal implements Pettable {

    private Random rand = new Random();

    /**
     * This is the Sheep object constructor.
     * @param noise This is the noise the Sheep makes.
     * @param move This is the noise the Sheep makes as it moves.
     * @param name This is the name of the Sheep.
     */
    public Sheep(String noise, String move, String name) {
        super(noise, move, name);
    }

    /**
     * This is the implementation of the pet method.
     * It displays what the Animal does as it is being pet.
     */
    @Override
    public void pet() {
        System.out.println("You pet the " + this.getName()
                + " for " + super.MAX_TIME_PETTABLE + " minutes.");
        System.out.println(super.makeNoise());
        System.out.println(rand.nextInt() <= 0.5 ? "The "
                + this.getName() + " shuffles closer to you." : "The "
                + this.getName() + " shuffles away from you.");
    }
}
