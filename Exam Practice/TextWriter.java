import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TextWriter {
    public static void main(String[] args) throws IOException{

        Scanner scanner = new Scanner(System.in);
        System.out.println("put in the text file name");
        String name = scanner.nextLine();

        try {
            File file = new File(name);
            Scanner fileScanner = new Scanner(file);
            String sentence = fileScanner.nextLine();

            PrintWriter pw = new PrintWriter("newText.txt");
            String word;

            while (fileScanner.hasNextLine()) {
                StringTokenizer st = new StringTokenizer(sentence);
                while (st.hasMoreTokens()) {
                    word = st.nextToken();
                    if (word.contains("@")) {
                        pw.println(word);
                    }
                }
                sentence = fileScanner.nextLine();
            }
          pw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
