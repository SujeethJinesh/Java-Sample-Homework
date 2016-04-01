/**
 * Created by lab on 3/24/2016.
 */
public class hackerrank {

    /*
 * Complete the function below.
 */

    static int getIntegerComplement(int n) {

        String num = Integer.toBinaryString(n);

        char temp;
        String answer = "";
        for (int i = 0; i < num.length(); i++) {
            temp = num.charAt(i);
            if (temp == '1') {
                answer += "0";
            } else {
                answer += "1";
            }
        }
        return (Integer.parseInt(answer, 2));
    }



}
