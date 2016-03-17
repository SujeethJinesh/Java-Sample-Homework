import java.util.Scanner;
import java.util.Random;

/**
 * This is the ZooSimulation class which
 * contains methods that is the driver for the project.
 * Worked on this class by myself referencing StackOverflow.com and Java API.
 *
 * @author Sujeeth Jinesh
 * @version 3/11/2016
 */
public class ZooSimulation {

    // INSTANCE VARIABLES
    // YOUR CODE HERE
    // You can add any instance variables that you think will help you
    // write the homework.
    private Animal[] zooAnimals;
    private Animal[] pettables;
    private Animal[] feedables;
    private Animal[] viewables;
    private Random rand = new Random();

    /**
     * This is the constructor for
     * the class, which contains an Animal array of all the
     * Animals.
     */
    public ZooSimulation() {
        // YOUR CODE HERE
        // You'll need to add the animals to this array, including your
        // custom animal. In the end there should be at least 6 elements

        Animal bear = new Bear("Growl", "charges", "Bear");
        Animal bunny = new Bunny("What's up Doc?", "hops", "Bunny");
        Animal koiFish = new KoiFish("Blub", "swims", "Koi Fish");
        Animal pony = new Pony("Whinny", "trots", "Pony");
        Animal sheep = new Sheep("Baa", "wobble", "Sheep");
        Animal tiger = new Tiger("Rawr", "stalks", "Tiger");

        zooAnimals = new Animal[]{bear, bunny, koiFish, pony, sheep, tiger};
    }

    /**
     * This is the driver for the project.
     * @param args Any input arguments will be fed through here
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ZooSimulation zoo = new ZooSimulation();

        System.out.println("Welcome to The Atlanta Zoo!");

        int input = 0;
        while (input != 6) {
            System.out.println("\n\nWould you like to:");
            System.out.println("1. List all of the animals");
            System.out.println("2. See an output of all animals"
                                + " and their actions");
            System.out.println("3. Pet an animal");
            System.out.println("4. Feed an animal");
            System.out.println("5. Watch an animal");
            System.out.println("6. Quit");
            System.out.println("Please enter one of the options above:");

            input = scan.nextInt();
            while (input < 1 || input > 6) {
                System.out.println("Please enter a number 1-6");
                input = scan.nextInt();
            }

            if (input == 1) {
                zoo.printAnimals();
            } else if (input == 2) {
                zoo.makeAnimalSounds();
            } else if (input == 3) {
                zoo.petAnimals();
            } else if (input == 4) {
                zoo.feedAnimals();
            } else if (input == 5) {
                zoo.viewAnimals();
            }
        }
    }

    /**
     * This prints out all the animals in the ZooSimulation Object.
     */
    private void printAnimals() {
        // YOUR CODE HERE
        // Print the number of Animals instantiated

        System.out.println("\nThe animals found in this zoo are:");

        // DONT CHANGE THE REST OF THIS METHOD
        for (Animal a : zooAnimals) {
            System.out.println(a);
        }
    }

    /**
     * This prints out all the Animals and the noises they make.
     */
    private void makeAnimalSounds() {
        System.out.println(); // This line is for cleaner formatting
        // YOUR CODE HERE
        // Invoke makeNoise and move for the animals in the zoo.

        for (Animal a : zooAnimals) {
            System.out.print(a + ": ");
            System.out.println(a.makeNoise());
        }
    }

    /**
     * This prints out what occurs as the user pets an Animal
     */
    private void petAnimals() {
        System.out.println();  // This line is for cleaner formatting
        // YOUR CODE HERE
        // You need to randomly select a Pettable animal and then pet it.
        pettables = new Animal[2];
        int counter = 0;

        for (int i = 0; i < zooAnimals.length; i++) {
            if (zooAnimals[i] instanceof Pettable) {
                pettables[counter] = zooAnimals[i];
                counter++;
            }
        }
        int animalToPet = rand.nextInt(pettables.length);
        ((Pettable) pettables[animalToPet]).pet();
    }
    /**
     * This prints out what occurs as the user feeds an Animal
     */
    private void feedAnimals() {
        System.out.println();  // This line is for cleaner formatting
        // YOUR CODE HERE
        // You need to randomly select a Feedable animal and then feed it.
        feedables = new Animal[2];
        int counter = 0;

        for (int i = 0; i < zooAnimals.length; i++) {
            if (zooAnimals[i] instanceof Feedable) {
                feedables[counter] = zooAnimals[i];
                counter++;
            }
        }
        int animalToPet = rand.nextInt(feedables.length);
        ((Feedable) feedables[animalToPet]).feed();
    }

    /**
     * This prints out what occurs as the user views an Animal
     */
    private void viewAnimals() {
        System.out.println();  // This line is for cleaner formatting
        // YOUR CODE HERE
        // You need to randomly select a Viewable animal
        // and then attempt to view it.

        viewables = new Animal[3];
        int counter = 0;

        for (int i = 0; i < zooAnimals.length; i++) {
            if (zooAnimals[i] instanceof Viewable) {
                viewables[counter] = zooAnimals[i];
                counter++;
            }
        }
        int animalToPet = rand.nextInt(viewables.length);
        ((Viewable) viewables[animalToPet]).view();
    }

}