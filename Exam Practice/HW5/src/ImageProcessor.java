/* Put your ImageProcessor class here */

public class ImageProcessor {

    private Pic pic;
    private Pixel[][] pixels;
    private Pixel[][] pixelsBackground;
    private Pic background;
    private int height;
    private int width;
    private int red;
    private int green;
    private int blue;
    private int alpha;
    private int redBackground;
    private int greenBackground;
    private int blueBackground;
    private int alphaBackground;

    public ImageProcessor(String image) {
        pic = new Pic(image).deepCopy();
        pixels = pic.getPixels();
        height = pic.getHeight();
        width = pic.getWidth();
    }

    public Pic chroma(Pixel key, int dr, int dg, int db) {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                red = pixels[i][j].getRed();
                green = pixels[i][j].getGreen();
                blue = pixels[i][j].getBlue();
                alpha = pixels[i][j].getAlpha();

                if (red - key.getRed() < dr &&
                        green - key.getGreen() < dr &&
                        blue - key.getBlue() < dr) {
                    pixels[i][j].setAlpha(0);
                }
            }
        }

        return pic;
    }

    public Pic background(Pic bg) {

        pixelsBackground = bg.getPixels();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                redBackground = pixelsBackground[i][j].getRed();
                greenBackground = pixelsBackground[i][j].getGreen();
                blueBackground = pixelsBackground[i][j].getBlue();
                alphaBackground = pixelsBackground[i][j].getAlpha();

                if (pixels[i][j].getAlpha() == 0) {
                    pixels[i][j].setRed(pixelsBackground[i][j].getRed());
                    pixels[i][j].setGreen(pixelsBackground[i][j].getGreen());
                    pixels[i][j].setBlue(pixelsBackground[i][j].getBlue());
                }
            }
        }

        return pic;
    }


    public Pic greyscale() {

        int average = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                red = pixels[i][j].getRed();
                green = pixels[i][j].getGreen();
                blue = pixels[i][j].getBlue();

                average = (red + green + blue)/3;

                pixels[i][j].setRed(average);
                pixels[i][j].setGreen(average);
                pixels[i][j].setBlue(average);
            }
        }

        return pic;
    }

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