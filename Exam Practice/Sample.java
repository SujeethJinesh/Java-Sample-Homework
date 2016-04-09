public class Sample {

    static String[] myString = {"my string", null};
    static int x = 2;

    public static void checker(int x, String[] stuff) {
        if (x == 0) {
            System.out.println("All done");  // printing
            return;
        }
        stuff[1] = "stuff";
        x--;
        System.out.println("x = "+x);      // printing
    }

    public static void main(String[] args) {
        checker(x, myString);
        System.out.println("x is now "+x); // printing
        for (String s:myString) {
            System.out.println(s);
        }
    }
}