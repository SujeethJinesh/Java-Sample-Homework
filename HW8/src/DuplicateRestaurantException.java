/**
 * Worked on this class on my own and using Java API.
 * Class that creates the restaurant for Yelp
 *
 * @author Sujeeth Jinesh
 * @version 1.0
 */
public class DuplicateRestaurantException extends RuntimeException {

    private static String message = "Attempted to add a"
            + "restaurant duplicate to database.";

    /**
     * This fetches the super class's message
     */
    public DuplicateRestaurantException() {
        super(message);
    }

    /**
     * This is the message that would be retrieved.
     * @param message this is the message to be returned.
     */
    public DuplicateRestaurantException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * This is the message that will be returned
     * @return the message
     */
    @Override
    public String getMessage() {
        return this.message;
    }
}
