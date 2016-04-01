/**
 * Worked on this class on my own and using Java API.
 * Class that creates the restaurant for Yelp
 *
 * @author Sujeeth Jinesh
 * @version 1.0
 */
public class Restaurant {
    private String name;
    private String cuisineType;
    private Review[] reviews = new Review[10];
    private String price;
    private int numReviews = 0;
    private double avgerageRating = 0;

    /**
     * The constructor for the restaurant Restaurant.
     * @param name name of restaurant
     * @param cuisineType cuisine of the restaurant
     * @param priceRange price range of the restaurant
     */
    public Restaurant(String name, String cuisineType,
                      String priceRange) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.price = priceRange;
        this.avgerageRating = 0;
    }

    /**
     * Gets the price range of the restaurant
     * @return price range returned
     */
    public String getPrice() {
        return this.price;
    }

    /**
     * This gets the cuisine type of cuisine the restaurant serves
     * @return the cuisine type of the restaurant
     */
    public String getCuisineType() {
        return this.cuisineType;
    }

    /**
     * This gets the number of reviews for the restaurant.
     * @return number of reviews
     */
    public int getNumReviews() {

        int numRevs = 0;

        for (int i = 0; i < reviews.length; i++) {
            if (reviews[i] != null) {
                numRevs++;
            }
        }

        return numRevs;
    }

    /**
     * gets the review at a specified location in the restaurant review array.
     * @param i index of the review
     * @return the review at the specified index.
     */
    public Review getReview(int i) {
        return this.reviews[i];
    }

    /**
     * Gets the average rating of the restaurant
     * @return calculated average rating based off of reviews
     */
    public double getAverageRating() {

        double avgRating = 0;

        for (int i = 0; i < this.getNumReviews(); i++) {
            if (reviews[i] != null) {
                avgRating += reviews[i].getRating();
            }
        }
        if (this.getNumReviews() == 0) {
            return 0;
        }
        return (avgRating / (double) this.getNumReviews());
    }

    /**
     * Adds a review to the restaurant's review list.
     * @param review adds specified review
     */
    public void addReview(Review review) {
        int counter = 0;

        double newRating = 0;

        while (counter <= reviews.length && reviews[counter] != null) {
            counter++;
        }

        if (counter >= reviews.length) {
            Review[] temp = new Review[reviews.length * 2];
            for (int i = 0; i < counter; i++) {
                temp[i] = reviews[i];
                newRating += temp[i].getRating();
            }
            temp[counter + 1] = review;
            newRating += temp[counter + 1].getRating();
            reviews = temp;
            this.avgerageRating = newRating / (counter + 1);
        } else {
            reviews[counter] = review;
            for (int i = 0; i < counter; i++) {
                newRating += reviews[i].getRating();
            }
            if (counter == 0) {
                avgerageRating = 0;
            } else {
                this.avgerageRating = newRating / ((double) counter);
            }
        }
    }

    /**
     * Deletes a specified review
     * @param review deletes specified review
     */
    public void deleteReview(Review review) {
        int index = 0;
        double newRating = 0;

        for (int i = 0; i < this.getNumReviews(); i++) {
            if (i < this.getNumReviews() && review.equals(reviews[i])) {
                reviews[i] = null;
                index = i;
            } else {
                newRating += reviews[i].getRating();
            }
        }

        for (int j = index; j < this.getNumReviews(); j++) {
            if (reviews[j + 1] != null) {
                reviews[j] = reviews[j + 1];
                index++;
            }
        }

        this.avgerageRating = newRating / ((double) index);
    }

    /**
     * Converts the Restaurant to a string
     * @return the string form of the restaurant
     */
    public String toString() {
        return this.getName() + ", " + this.getCuisineType()
                + ", " + this.getAverageRating() + ", " + this.getPrice() + " ";
    }

    /**
     * Checks if two restaurants are equal.
     * @param restaurant the restaurant being compared to
     * @return true or false specifying equality or not.
     */
    @Override
    public boolean equals(Object restaurant) {
        if (restaurant instanceof Restaurant
                && this.name.equals(((Restaurant) restaurant).getName())) {
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
     * gets the name of the restaurant.
     * @return returns the name of the restaurant.
     */
    public String getName() {
        return this.name;
    }
}
