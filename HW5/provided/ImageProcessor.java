/**
 * This is the ImageProcessor class which creates ImageProcessor Objects
 * @author Sujeeth Jinesh
 * @version 1
 */

public class ImageProcessor {

    private static Pic pic;
    private static Pixel[][] pixels;
    private static Pixel[][] pixelsBackground;
    private static Pic background;
    private static int height;
    private static int width;
    private static int red;
    private static int green;
    private static int blue;
    private static int alpha;
    private static int redBackground;
    private static int greenBackground;
    private static int blueBackground;
    private static int alphaBackground;

    /**
    * Creates an ImageProcessor Object initialized with the image's name.
    * @param image input
    */
    public ImageProcessor(String image) {
        pic = new Pic(image).deepCopy();
        pixels = pic.getPixels();
        height = pic.getHeight();
        width = pic.getWidth();
    }

    /**
    * This method creates the chroma of the image
    * @param key for Chroma
    * @param dr for delta red
    * @param dg for delta green
    * @param db for delta blue
    * @return Pic of chroma
    */
    public Pic chroma(Pixel key, int dr, int dg, int db) {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                red = pixels[i][j].getRed();
                green = pixels[i][j].getGreen();
                blue = pixels[i][j].getBlue();
                alpha = pixels[i][j].getAlpha();

                if (Math.abs(red - key.getRed()) < dr
                    && Math.abs(green - key.getGreen()) < dr
                    && Math.abs(blue - key.getBlue()) < dr) {
                    pixels[i][j].setAlpha(0);
                }
            }
        }

        return pic;
    }

    /**
    * This method replaces the transpared picture parts with the selected
    * background.
    * @param bg background image name
    * @return Pic with background replaced
    */
    public Pic background(Pic bg) {

        pixelsBackground = bg.getPixels();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                redBackground = pixelsBackground[i][j].getRed();
                greenBackground = pixelsBackground[i][j].getGreen();
                blueBackground = pixelsBackground[i][j].getBlue();

                if (pixels[i][j].getAlpha() == 0) {
                    pixels[i][j].setRed(redBackground);
                    pixels[i][j].setGreen(greenBackground);
                    pixels[i][j].setBlue(blueBackground);
                }
            }
        }

        return pic;
    }

    /**
    * This method creates the greyscaled image
    * @return Pic of greyscaled image.
    */

    public Pic greyscale() {

        int average = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                red = pixels[i][j].getRed();
                green = pixels[i][j].getGreen();
                blue = pixels[i][j].getBlue();

                average = (red + green + blue) / 3;

                pixels[i][j].setRed(average);
                pixels[i][j].setGreen(average);
                pixels[i][j].setBlue(average);
            }
        }

        return pic;
    }

    /**
    * This method creates the inverse of the image
    * @return Pic of invered image
    */
    public Pic invert() {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                red = pixels[i][j].getRed();
                green = pixels[i][j].getGreen();
                blue = pixels[i][j].getBlue();

                pixels[i][j].setRed(255 - red);
                pixels[i][j].setGreen(255 - green);
                pixels[i][j].setBlue(255 - blue);
            }
        }

        return pic;
    }
}