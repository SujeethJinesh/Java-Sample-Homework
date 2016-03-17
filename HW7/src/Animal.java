/**
 * This is the Animal class which contains methods that
 * all Animals inherit from.
 * Worked on this class by myself referencing StackOverflow.com and Java API.
 *
 * @author Sujeeth Jinesh
 * @version 3/11/2016
 */
public abstract class Animal {
    public static final int MAX_TIME_PETTABLE = 5;
    private static int animalCounter = 0;
    private String noise;
    private String move;
    private String name;

    /**
     * This is constructor for the Animal.
     *
     * @param noise This is the noise the animal will make.
     * @param move This is the noise the animal makes as it moves
     * @param name This is the name of the animal.
     */
    public Animal(String noise, String move, String name) {
        this.noise = noise;
        this.move = move;
        this.name = name;
        animalCounter++;
    }

    /**
     * This method represents the noise the Animal makes
     *
     * @return The sound the animal makes.
     */
    public String makeNoise() {
        return noise;
    }

    /**
     * This method represents the noise the Animal makes as it moves.
     *
     * @return The sound the animal makes as it moves.
     */
    public String move() {
        return move;
    }

    /**
     * This method represents the name of the Animal.
     *
     * @return The name of the animal.
     */
    public String toString() {
        return this.name;
    }

    /**
     * This returns the name of the object.
     * @return This returns the move of the object.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This returns the move of the object.
     * @return This returns the move of the object.
     */
    public String getMove() {
        return this.move;
    }
}
