import java.text.DecimalFormat;
import java.util.Arrays;

public class Business {
    private Item[] inventory = new Item[10];
    private String name;
    private double numSales;
    private int numTransactions;
    private int itemsInStock;
    private int counter = 1;
    private static double temporary;
    private static int temp2;
    private static String temp3;
    private static int sizeOfData;

    public Business(String[][] data) {
        this.name = data[0][0];

        while (inventory[counter - 1] != null) {
            counter++;
        }

        if (data.length - 2 + counter > 10) {
            Item[] temp = new Item[2 * inventory.length];
            for (int i = 0; i < counter; i++) {
                temp[i] = inventory[i];
            }
            inventory = temp;
            for (int j = 1; j < (data.length + counter - 1); j++) {
                temporary = Double.parseDouble(data[j][1]);
                temp2 = Integer.parseInt(data[j][2]);
                temp3 = data[j][0];
                this.addItem(new Item(temp3, temp2, temporary), j - 1);
            }
        } else {
            for (int j = 1; j < (data.length + counter - 1); j++) {
                temporary = Double.parseDouble(data[j][1]);
                temp2 = Integer.parseInt(data[j][2]);
                temp3 = data[j][0];
                this.addItem(new Item(temp3, temp2, temporary), j - 1);
            }
        }

        for (int i = 1; i < data.length; i++) {
            itemsInStock += Integer.parseInt(data[i][2]);
        }

        sizeOfData = data.length + counter - 1;
    }

    public String getName() {
        return name;
    }

    public Item getBestSellingItem() {

        int[] bestItem = new int[inventory.length];

        for (int i = 0; i < sizeOfData - 1; i++) {

            bestItem[i] = inventory[i].numAttempts();
        }

        int maxIndex = 0;
        int max = 0;

        for (int j = 0; j < bestItem.length; j++) {
            if (bestItem[j] > max) {
                max = bestItem[j];
                maxIndex = j;
            }
        }

        return inventory[maxIndex];
    }

    public void sell(Person person, Item item, int quantity) {

        if (person.getBalance() >= (item.getPrice()) * quantity
                && item.getQuantity() >= quantity) {

            item.increaseNumSold(quantity);

            item.setQuantity(item.getQuantity() - quantity);

            for (int i = 0; i < quantity; i++) {
                person.purchase(item);
                numTransactions++;
            }
            numSales += item.getPrice() * quantity;
            itemsInStock -= quantity;
        }
        item.increaseAttemptsBy(quantity);

    }

    public boolean addItem(Item item, int index) {

        boolean bool = false;
        if (Arrays.asList(inventory).contains(item)) {
            return bool;
        } else if (inventory[index] == null) {
            inventory[index] = item;
            bool = true;
            return bool;
        }

        return bool;
    }

    public String getReport(int days, double execTime) {

        DecimalFormat df = new DecimalFormat("0.00");

        return ("Simulation Report: " + this.getName() + "\n"
                + "Execution time: " + execTime + "ms\n"
                + "=========================================\n"
                + "Days of simulation: " + days + "\n"
                + "Total Transactions: " + numTransactions + "\n"
                + "Total Revenue: $" + df.format(numSales) + "\n"
                + "Number of Items in stock: " + itemsInStock + "\n"
                + "Best selling Item: " + "\"" + this.getBestSellingItem()
                + "\"" + "\n" + "==========================================");
    }

    public Item getItem(int index) {
        return inventory[index];
    }
}
