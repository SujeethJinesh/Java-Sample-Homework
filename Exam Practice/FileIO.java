import java.io.*;
import java.util.Scanner;

    public class FileIO {

        public static void main(String[] args) {
            File inFile, outFile;
            Scanner scan, fileScanner;
            PrintWriter outWriter=null;
            String inName, outName, firstLine=null;
            boolean problems;

            do {
                problems = false;
                System.out.println("What file would you like to read from?");
                scan = new Scanner(System.in);
                inName = scan.nextLine();
                try {
                    inFile = new File(inName);
                    fileScanner = new Scanner(inFile);
                    firstLine = fileScanner.nextLine();
                }
                catch (IOException e) {
                    System.err.println("Problem with file "+inName);
                    System.err.println("Try again");
                    problems = true;
                }
                finally {
                }
            } while (problems);

            do {
                problems = false;
                System.out.println("What file would you like to write to?");
                System.out.println("Be careful, if the file already exists,");
                System.out.println("   this will overwrite its contents");
                outName = scan.nextLine();
                try {
                    outFile = new File(outName);
                    outWriter = new PrintWriter(outFile);
                    outWriter.println(firstLine.toUpperCase());
                }
                catch (IOException e) {
                    System.err.println("Problem with file "+outName);
                    System.err.println("Try again");
                    problems = true;
                }
                finally {
                    outWriter.close();   // very important
                }
            } while (problems);
        }
    }


       