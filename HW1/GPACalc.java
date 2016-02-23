import java.util.Scanner; //imports scanner class

public class GPACalc //name of class
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in); //initializes the Scanner object

		System.out.print("A Credit Hours: "); //reads in the A Credit hours from the user
		int ACredits = scanner.nextInt();

		System.out.print("\nB Credit Hours: "); //reads in the B Credit hours from the user
		int BCredits = scanner.nextInt();

		System.out.print("\nC Credit Hours: "); //reads in the C Credit hours from the user
		int CCredits = scanner.nextInt();

		System.out.print("\nD Credit Hours: "); //reads in the D Credit hours from the user
		int DCredits = scanner.nextInt();

		System.out.print("\nF Credit Hours: "); //reads in the F Credit hours from the user
		int FCredits = scanner.nextInt();

		double sumCredits = ACredits + BCredits + CCredits + DCredits + FCredits; //calculates total number of credits

		double qualityPoints = ACredits*4.0 + BCredits*3.0 + CCredits*2.0 + DCredits*1.0 + FCredits*0.0; //calculates quality points

		double GPA = qualityPoints/sumCredits; //calculates GPA

		System.out.println("GPA: " + GPA); //prints out final result
	}
}