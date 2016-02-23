import java.util.Random;
/**
 * Worked on this independently with course materials, stack overflow and java
 * api.
 * @author Thomas Lilly
 * @version 1.0
 */

public class MarketSim {

    /* Please use this array to test your classes.
     * Feel free to add data to test resizing
     */
    private static String[][] businessData = {
            {"Amazon"},
            {"Fitbit ChargeHR", "129.89", "40"},
            {"Amazon Echo", "179.99" , "34"},
            {"Roses", "139.99", "100"},
            {"Lindt Chocolate", "30.40", "57"},
            {"Jaybird X2", "128.50", "20"},
            {"Football", "28.44", "176"},
            {"Shawl", "12.99", "230"},
            {"CLRS", "66.32", "281"},
            {"USB Micro-USB to USB Cable", "4.96", "132"},
            {"Stationery", "9.89", "75"}
    };
    private static int persons;
    private static int days;
    private static Random rand = new Random();
    private static int money;
    private static Person[] people;
    private static double probability;
    private static int numProducts;
    private static int whichProduct;
    private static Item[] items;
    private static double startTime;
    private static double endTime;
    private static double execTime;

    public static void main(String[] args) {

        startTime = System.nanoTime();

        if (args.length == 0) {
            days = 31;
            persons = 5;
            people  = new Person[days];
            items = new Item[businessData.length - 1];
        } else if (args.length == 2) {
            if (args[0].equals("-p") &&  isNumeric(args[1])) {

                persons = Integer.parseInt(args[1]);
                days = 31;

            }
            if (args[0].equals("-d") &&  isNumeric(args[1])) {

                days = Integer.parseInt(args[1]);
                persons = 5;

            }
            people  = new Person[persons];
            items = new Item[businessData.length - 1];
        } else if (args.length == 4) {
            if (args[0].equals("-p") &&  isNumeric(args[1])) {

                persons = Integer.parseInt(args[1]);

            }
            if (args[2].equals("-p") && isNumeric(args[3])) {

                persons = Integer.parseInt(args[3]);

            }
            if (args[0].equals("-d") &&  isNumeric(args[1])) {

                days = Integer.parseInt(args[1]);

            }
            if (args[2].equals("-d") && isNumeric(args[3])) {

                days = Integer.parseInt(args[3]);

            }
            people  = new Person[persons];
            items = new Item[businessData.length - 1];
        } else {

            System.out.print("incorrect");

            System.out.println("Usage: java MarketSim "
                    + "[-p <numberOfPeople>][-d <numberOfDays>]");

            System.exit(0);
        }

        System.out.println("Running simulation with " + persons
            + " people over " + days + " days...\n");

        Business business = new Business(businessData);

        for (int i = 0; i < persons; i++) {
            money = rand.nextInt(50000) + 50000;

            people[i] = new Person(money);
        }

        for (int j = 0; j < days; j++) {
            for (int k = 0; k < persons; k++) {
                probability = rand.nextDouble();
                if (probability <= 0.75) {
                    numProducts = rand.nextInt(5) + 1;
                    whichProduct = rand.nextInt(businessData.length - 1);
                    business.sell(people[k], business.getItem(whichProduct),
                            numProducts);
                }
            }
        }

        endTime = System.nanoTime();

        execTime = ((int) ((endTime - startTime) * Math.pow(10, -4))) / 100.0;

        System.out.println(business.getReport(days, execTime));

    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
