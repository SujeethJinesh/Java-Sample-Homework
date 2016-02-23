import java.util.Scanner;
import java.lang.Math;

public class AdditionQuiz {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);

        System.out.print("What is " + number1 + " + " + number2 + "? ");
        int response = scanner.nextInt();

        int sum = number1 + number2;

        if (response == sum)
            System.out.println("Correct");
        else {
            System.out.println("Wrong. Answer: " + sum);
        }
    }
}