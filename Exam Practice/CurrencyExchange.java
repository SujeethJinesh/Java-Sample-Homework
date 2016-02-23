import java.util.Scanner;

public class CurrencyExchange {

    private static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        System.out.print("Please enter currency exchange rate ($ to RMB): ");
        double exchangeRate = scanner.nextDouble();

        System.out.print("$ to RMB (0) or RMB to $ (1)? ");
        int conversion = scanner.nextInt();

        System.out.print("How much would you like to convert? ");
        double amount = scanner.nextDouble();

        double convertedAmount = 0.0;
        String currency = "";

        switch (conversion) {
            case 0:
                convertedAmount = (double) amount*exchangeRate;
                currency = "yuan";
                break;
            case 1:
                convertedAmount = (double) amount/exchangeRate;
                currency = "dollars";
                break;
        }

        System.out.print(Double.toString(convertedAmount) + " " + currency);
    }

}