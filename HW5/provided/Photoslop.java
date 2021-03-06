import java.io.IOException;

/**
 * Collaboration Statement: I worked on this homework independently using only
 * course materials and the Java documentation.
 * @author Sujeeth Jinesh
 * @version 1
 */
public class Photoslop {

    private static Pic picture;

    /**
    * Main method.
    * @param args initial arguments
    */

    public static void main(String... args) throws IOException {
        if (args.length < 3) {
            printUsage();
            System.exit(0);
        }
        try {
            //your code here
            //hint the base pic for use with the image processor is in args[1]

            ImageProcessor image = new ImageProcessor(args[1]);

            if (args[0].equals("-g")) {
                picture = image.greyscale();
                picture.save(args[2]);

            } else if (args[0].equals("-i")) {

                picture = image.invert();
                picture.save(args[2]);

            } else if (args[0].equals("-c")) {
                //use this as your chroma key to match the greenscreen
                //in the lego guy image
                Pixel chromaKey = new Pixel(26, 185, 19, 1);

                picture = image.chroma(chromaKey, 40, 40, 40);

                picture.save(args[3]);

                Pic bg = new Pic(args[2]);

                picture = image.background(bg);

                picture.save(args[3]);
            } else {
                printUsage();
            }
        } catch (IOException ex) {
            System.out.println("One of the files you referenced does not exist,"
                + " or is corrupted. Double-check and try again.");
        }
    }

    private static void printUsage() {
        System.out.println("Greyscale mode: ");
        System.out.println("java Photoslop -g imageFile outputFileName");
        System.out.println("");
        System.out.println("Invert mode: ");
        System.out.println("java Photoslop -i imageFile outputFileName");
        System.out.println("");
        System.out.println("Greenscreen mode: ");
        System.out.println("java Photoslop -c imageFile backgroundFile"
                + " outputFileName");
    }
}
