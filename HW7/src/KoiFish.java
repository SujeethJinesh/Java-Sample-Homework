import java.util.Random;

/**
 * This is the KoiFish class which contains methods
 * that all inherit from Animal.
 * This class implements the Feedable interface.
 * Worked on this class by myself referencing StackOverflow.com and Java API.
 *
 * @author Sujeeth Jinesh
 * @version 3/11/2016
 */
public class KoiFish extends Animal implements Feedable {

    private Random rand = new Random();

    /**
     * This is the KoiFish constructor.
     * @param noise This is the noise that the Koi Fish will make.
     * @param move This is the noise the Koi Fish will make as it moves.
     * @param name This is the name of the Koi Fish.
     */
    public KoiFish(String noise, String move, String name) {
        super(noise, move, name);
    }

    @Override
    /**
     * This is the feed method, which prints out the animal as it is being fed.
     */
    public void feed() {
        System.out.println(rand.nextInt() <= 0.25 ? "You fed the "
                + this.getName() : "Another "
                + this.getName() + " ate the food.");
        System.out.println(super.makeNoise());
        System.out.println("The " + this.getName()
                + " " + this.getName() + " away.");
    }

}
