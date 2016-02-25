/* Put your Pixel class here */

public class Pixel {
    private int red;
    private int green;
    private int blue;
    private int alpha;


    public Pixel(int red, int green, int blue, int alpha) {
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
        this.setAlpha(alpha);
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getRed() {
        return red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getGreen() {
        return green;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getBlue() {
        return blue;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int getAlpha() {
        return alpha;
    }

}