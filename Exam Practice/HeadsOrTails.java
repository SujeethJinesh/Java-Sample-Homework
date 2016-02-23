import java.util.Scanner;
import java.lang.Math;

public class HeadsOrTails {

    private static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        
        int response;
        int coin;

        do {
            coin = (int) Math.round(Math.random()*10)/10;
            
            System.out.println(coin);

            System.out.print("Guess Heads or Tails (0 or 1): ");
            response = scanner.nextInt();

            if (response != coin)
                System.out.println("Try again!");
            else
                System.out.println("Nice Job!");
        } while (response != coin);
    }
}