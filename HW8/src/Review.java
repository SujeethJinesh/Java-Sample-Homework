/**
 * Worked on this class on my own and using Java API.
 * Class that creates the restaurant for Yelp
 *
 * @author Sujeeth Jinesh
 * @version 1.0
 */
public class Review {
    private int rating;
    private String date;
    private String restaurant;

    /**
     * Constructor for the Review object
     * @param rating rating for the review
     * @param date date for the review
     * @param restaurant restaurant name for the review
     */
    public Review(int rating, String date, String restaurant) {
        this.rating = rating;
        this.date = date;
        this.restaurant = restaurant;
    }

    /**
     * Converts the review to a string format
     * @return the review in text format
     */
    public String toString() {
        return "Rating: " + rating + "\nDate: "
                + date + "\nRestaurant: " + restaurant;
    }

    /**
     * Checks if the two reviews are equal
     * @param review specified review being compared to
     * @return boolean of equality
     */
    @Override
    public boolean equals(Object review) {
        if (review instanceof Review
                && this.rating == ((Review) review).getRating()
                && this.date.equals(((Review) review).getDate())
                && this.restaurant.equals(((Review) review).getRestaurant())) {
            return true;
        }
        return false;
    }

    /**
     * This is the hashcode method
     * @return an arbitrary hashcode.
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     * Gets the rating of the review
     * @return the rating of the review
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Gets the date of the review.
     * @return the review date
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Gets the restaurant's name
     * @return restaurant name
     */
    public String getRestaurant() {
        return this.restaurant;
    }
}
