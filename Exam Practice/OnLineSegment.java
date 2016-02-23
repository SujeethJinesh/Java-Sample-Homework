import java.util.Scanner;


public class OnLineSegment {

    private static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        System.out.println("Enter three points for p0, p1, and p2: ");
        String[] temp = scanner.nextLine().split(" ");

        double[] points = intEverything(temp);

        double p0p1Slope = (points[3] - points[1])/(points[2] - points[0]);
        double p1p2Slope = (points[5] - points[3])/(points[4] - points[2]);
        double p2p0Slope = (points[5] - points[1])/(points[4] - points[0]);

        if (p1p2Slope == p0p1Slope && p2p0Slope == p0p1Slope && points[5] >= points[1] && points[4] >= points[0] && points[5] <= points[3] && points[4] <= points[2])
            System.out.println("This point lies on the line segment.");
        else
            System.out.println("This point does NOT lie on the line segment.");
    }

    public static double[] intEverything(String[] array) {

        double[] points = new double[array.length];

        for (int i = 0; i < array.length; i++)
            points[i] = Double.parseDouble(array[i]);

        return points;
    }
}

//1 1 2.5 2.5 1.5 1.5
//1 1 2 2 3.5 3.5