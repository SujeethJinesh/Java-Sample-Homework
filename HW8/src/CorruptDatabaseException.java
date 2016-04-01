/**
 * Worked on this class on my own and using Java API.
 * Class that creates the restaurant for Yelp
 *
 * @author Sujeeth Jinesh
 * @version 1.0
 */
public class CorruptDatabaseException extends Exception {

    private static String message = "Tried to load unreadable information.";

    /**
     * This is the message to be projected
     */
    public CorruptDatabaseException() {
        super(message);
    }

    /**
     * this is the message gotten from the super class
     * @param message message returned
     */
    public CorruptDatabaseException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * This returns the message
     * @return message
     */
    @Override
    public String getMessage() {
        return this.message;
    }
}
