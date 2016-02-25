/**
 * This is the Pixel class which creates Pixel Objects
 * @author Sujeeth Jinesh
 * @version 1
 */
public class Pixel {
    private int red;
    private int green;
    private int blue;
    private int alpha;

    /**
    * Creates a Pixel Object initialized with the RGBA values.
    * @param red for red
    * @param green for green
    * @param blue for blue
    * @param alpha for transparency
    */
    public Pixel(int red, int green, int blue, int alpha) {
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
        this.setAlpha(alpha);
    }

    /**
    * Sets the color red to the pixel.
    * @param red color to set
    */
    public void setRed(int red) {
        this.red = red;
    }

    /**
    * Gets the degree of red of the pixel.
    * @return degree of red of the pixel.
    */
    public int getRed() {
        return red;
    }

    /**
    * Sets the color green to the pixel.
    * @param green color to set
    */
    public void setGreen(int green) {
        this.green = green;
    }

    /**
    * Gets the degree of green of the pixel.
    * @return degree of green of the pixel.
    */
    public int getGreen() {
        return green;
    }

    /**
    * Sets the color blue to the pixel.
    * @param blue color to set
    */
    public void setBlue(int blue) {
        this.blue = blue;
    }

    /**
    * Gets the degree of blue of the pixel.
    * @return degree of blue of the pixel.
    */
    public int getBlue() {
        return blue;
    }

    /**
    * Sets the color transparency to the pixel.
    * @param alpha to set
    */
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    /**
    * Gets the degree of transparency of the pixel.
    * @return degree of transparency of the pixel.
    */
    public int getAlpha() {
        return alpha;
    }

}