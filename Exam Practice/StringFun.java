import java.util.Scanner;

public class StringFun {

    private static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        System.out.println("Enter your word: ");
        String userInput = scanner.nextLine();

        System.out.println(userInput.charAt(0) + " " + userInput.charAt((userInput.length() - 1))); 
    }

}