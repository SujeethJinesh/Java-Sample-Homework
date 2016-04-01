import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @author Sylvia Necula
 * @version 1.0
 */
public class Driver {
    private static Scanner scan = new Scanner(System.in);

    /**
     * The main method that runs the yelp simulated program.
     * @param args command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException,
            CorruptDatabaseException, DuplicateRestaurantException {
        Driver driver = new Driver();
        YelpDB database = new YelpDB();

        //TO DO: load the database file

        try {
            database.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean cont = true;
        while (cont) {
            System.out.println("Welcome to Yelp! What would you like to do?");
            System.out.println("1. View all Restaurants in database");
            System.out.println("2. Search for a Restaurant");
            System.out.println("3. Add a Restaurant to the Database");
            System.out.println("4. Exit");
            int select = scan.nextInt();

            if (select == 1) {
                driver.viewRestaurants(database);
            } else if (select == 2) {
                driver.search(database);
            } else if (select == 3) {
                driver.addRestaurant(database);
            } else if (select == 4) {
                System.out.println("Goodbye!");
                cont = false;
            } else {
                System.out.println("That's not really an option, try again.");
            }
        }

        //TO DO: Save the database.

        try {
            database.save();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * viewRestaurants allows a user to select a restaurant to add a review to
     *
     * @param db the database being used
     */
    public void viewRestaurants(YelpDB db) {
        System.out.println("============================================");
        System.out.println("Restaurants currently in Database");
        System.out.println("============================================");
        boolean go = true;
        while (go) {
            int i = 0;
            //TO DO: Uncomment the below lines once you have implemented
            // getRestaurants

            for (Restaurant r : db.getRestaurants()) {
                System.out.println(++i + ". " + r);
            }
            System.out.println(++i + ". Go back");
            System.out.println("If you would like to add a review, type the"
                + " number of the restaurant you would like to add a review to."
                + " Otherwise type " + i +  " to quit.\n");
            System.out.print("What would you like to do? ");
            int select = scan.nextInt();
            if (select == i) {
                go = false;
            } else {
                // TO DO: Uncomment the lines below once you have implemented
                // getRestaurants()

                Restaurant r = db.getRestaurants()[select - 1];
                System.out.println("You are editing: " + r);
                System.out.println("What would you like to do?");
                System.out.println("1. Add a review");
                System.out.println("2. Delete a review");
                int sel = scan.nextInt();
                //TO DO
                //Implement adding or deleting a review here

                if (sel == 1) {
                    System.out.println("What is the rating?");
                    int rating = scan.nextInt();
                    r.addReview(new Review(rating,
                            new SimpleDateFormat("MM/dd/yyyy").
                                    toString(), r.getName()));
                } else if (sel == 2) {
                    System.out.println("Which review"
                            + "would you like to delete?");
                    int reviewNum = scan.nextInt();
                    r.deleteReview(r.getReview(reviewNum - 1));
                }
            }
        }
    }

    /**
     * Allows a user to add a restaurant to the database
     *
     * @param db the database being used
     */
    public void addRestaurant(YelpDB db) {
        System.out.println("=============================================");
        System.out.println("Adding a Restaurant");
        System.out.println("=============================================");

        //TO DO: Implement the following code for getting input for the
        //restaurant to be added. Remember when adding to the database, if there
        //is a duplicate restaurant your code should not crash!
        scan.nextLine();
        System.out.println("What is the Restaurant's name?");
        String name = scan.nextLine();
        System.out.println("What is the type of cuisine served at " + name
            + "?");
        String cuisine = scan.nextLine();
        System.out.println("What is the price range?");
        String priceRange = scan.nextLine();
        //TO DO: Create a restaurant with the above information
        Restaurant tempRestaurant = new Restaurant(name, cuisine, priceRange);
        //TO DO: Add your restaurant to the database.
        try {
            db.addToDatabase(tempRestaurant);
            Restaurant[] restaurants = db.getRestaurants();
            Restaurant[] tempArr = db.getRestaurants();

            for (int j = 0; j < restaurants.length; j++) {
                for (int k = j + 1; k < restaurants.length; k++) {
                    if (k != j && restaurants[k] == restaurants[j]) {
                        throw new DuplicateRestaurantException();
                    }
                }
            }
        } catch (DuplicateRestaurantException e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    /**
     * Allows a user to search for a restaurant in the database
     *
     * @param db the database being used
     */
    public void search(YelpDB db) {
        System.out.println("==============================================");
        System.out.println("Searching");
        System.out.println("==============================================");
        //for searching the database. Feel free to uncomment the search calls
        //after you have implemented them.
        boolean go = true;
        while (go) {
            System.out.println("What search option would you like to use?");
            System.out.println("1. Search by name");
            System.out.println("2. Search by cuisine and price range");
            System.out.println("3. Give me your best option");
            System.out.println("4. Go back");

            int opt = scan.nextInt();

            if (opt == 1) {
                System.out.println("What restaurant would you like to search"
                    + " for?");
                scan.nextLine();
                db.search(scan.nextLine());
            } else if (opt == 2) {
                scan.nextLine();
                System.out.println("What cuisine would you like to search"
                    + " for?");
                String cuisine = scan.nextLine();
                System.out.println("What price range?");
                db.search(cuisine, scan.nextLine());
            } else if (opt == 3) {
                System.out.println("Our highest rated restaurant is ");
                db.search();
            } else if (opt == 4) {
                go = false;
            } else {
                System.out.println("That's not an option, try again.");
            }
        }
    }

}