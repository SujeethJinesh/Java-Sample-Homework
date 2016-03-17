/**
 * This is the Feedable interface which contains methods and variables for
 * Animals that implement this interface.
 * Worked on this class by myself referencing StackOverflow.com and Java API.
 *
 * @author Sujeeth Jinesh
 * @version 3/11/2016
 */
public interface Feedable {

    int MAX_AMOUNT_OF_FOOD = 5;

    /**
     * This is the feed method all Feedable Animals will implement.
     */
    void feed();
}
