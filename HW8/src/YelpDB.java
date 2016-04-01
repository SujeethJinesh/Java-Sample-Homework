import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Worked on this class on my own and using Java API.
 * Class that creates the restaurant for Yelp
 *
 * @author Sujeeth Jinesh
 * @version 1.0
 */
public class YelpDB {
    private Restaurant[] restaurants;

    /**
     * The constructor for the YelpDB object
     */
    public YelpDB() {
        restaurants = new Restaurant[20];
    }

    /**
     * This loads in the data from the text file.
     */
    public void load() {

        System.out.println("Input file directory: ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();

        File file = new File(filename);

        try {
            Scanner fileScanner = new Scanner(file);
            int numRestaurants = Integer.parseInt(fileScanner.nextLine());
            Restaurant[] tempRestaurants = new Restaurant[numRestaurants];

            for (int i = 0; i < numRestaurants; i++) {
                String name = fileScanner.nextLine();
                String cuisineType = fileScanner.nextLine();
                double avgRating = Double.parseDouble(fileScanner.nextLine());
                String priceRange = fileScanner.nextLine();
                Restaurant restaurant = new Restaurant(name,
                        cuisineType, priceRange);

                int numReviews = Integer.parseInt(fileScanner.nextLine());
                for (int j = 0; j < numReviews; j++) {
                    int reviewRating = Integer.parseInt(fileScanner.nextLine());
                    String date = fileScanner.nextLine();

                    restaurant.addReview(new Review(reviewRating, date, name));
                }
                tempRestaurants[i] = restaurant;
            }
            restaurants = tempRestaurants;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    /**
     * This is the class that saves the data into a text file
     * @throws FileNotFoundException file not
     * found exception thrown if file is not found or null
     */
    public void save() throws FileNotFoundException {

        File file = new File("YelpDB.txt");

        try {
            PrintWriter output = new PrintWriter(file);
            output.println(restaurants.length);

            for (int i = 0; i < restaurants.length; i++) {
                output.println(restaurants[i].getName());
                output.println(restaurants[i].getCuisineType());
                output.println(restaurants[i].getAverageRating());
                output.println(restaurants[i].getPrice());
                output.println(restaurants[i].getNumReviews());

                for (int j = 0; j < restaurants[i].getNumReviews(); j++) {
                    output.println(restaurants[j].getReview(j).getRating());
                    output.println(restaurants[j].getReview(j).getDate());
                }
            }

            output.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }


    /**
     * This adds a restaurant to the database.
     * @param restaurant this is the restaurant to be added
     * @throws DuplicateRestaurantException this is when
     * the restaurant is a duplicate of another
     */
    public void addToDatabase(Restaurant restaurant)
            throws DuplicateRestaurantException {
        try {
            int i = 0;
            Restaurant[] tempArr = new Restaurant[restaurants.length + 1];
            while (i < restaurants.length && restaurants[i] != null) {
                if (restaurants[i].equals(restaurant)) {
                    throw new DuplicateRestaurantException();
                }
                tempArr[i] = restaurants[i];
                i++;
            }
            tempArr[i] = restaurant;
            restaurants = tempArr;
            restaurants[i] = restaurant;

        } catch (DuplicateRestaurantException e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    /**
     * This is the search method when a name is given.
     * @param restaurantName this is the name of the restaurant
     */
    public void search(String restaurantName) {

        boolean bool = true;
        for (int i = 0; i < restaurants.length; i++) {
            if (this.getRestaurants(i).getName().equals(restaurantName)) {
                System.out.println(getRestaurants(i).toString());
                bool = false;
            }
        }
        if (bool) {
            System.out.println("Restaurant does not exist");
        }
    }

    /**
     * This is the search method when the cuisine type
     * and the price range is given.
     * @param cuisineType the specified cuisine type
     * @param priceRange tge price range
     */
    public void search(String cuisineType, String priceRange) {

        String response = "";

        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i].getCuisineType().equals(cuisineType)
                    && restaurants[i].getPrice().equals(priceRange)) {
                response += restaurants[i].toString() + "\n";
            }
        }
        if (response.equals("")) {
            System.out.println("Restaurants do not exist");
        } else {
            System.out.println(response);
        }
    }

    /**
     * This is the search method for when there
     * are no specified paramaters. returns highest rated restaurant.
     */
    public void search() {
        String response = "";
        double tempRating = -1;
        int counter = 0;

        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i].getAverageRating() > tempRating) {
                tempRating = restaurants[i].getAverageRating();
                counter = i;
            }
        }
        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i].getAverageRating() == tempRating) {
                response += restaurants[i].toString() + "\n";
            }
        }
        if (response.equals("")) {
            System.out.println("Restaurants do not exist");
        } else {
            System.out.println(response);
        }
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
     * This is gets the restaurants
     * @return returns restaurants in database.
     */
    public Restaurant[] getRestaurants() {
        return this.restaurants;
    }

    /**
     * this returns the restaurant at a specified location
     * @param i the specified location in the database.
     * @return the restaurant to be returned.
     */
    public Restaurant getRestaurants(int i) {
        return this.restaurants[i];
    }
}