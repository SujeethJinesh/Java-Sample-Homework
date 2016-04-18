import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by lab on 4/10/2016.
 */
public class Motorola2 {

    public static void main(String[] args) throws IOException {

        String line;
        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
        String temp = "";
        line=inp.readLine();
        while((temp = inp.readLine()) != null) {
            line += "\n" + temp;
        }

        //Use the following code to print output
        String[] words = line.split("\n");
        Arrays.sort(words);
        String[] arranged = arrange(words);
        for (String word: arranged) {
            System.out.println(word);
        }
    }

    public static String[] arrange(String[] words) {
        String[] temp = new String[words.length];
        int counter = 0;
        for (int i = words.length - 1; i >= 0; i--) {
            temp[counter] = words[i];
            counter++;
        }
        return temp;
    }
}
