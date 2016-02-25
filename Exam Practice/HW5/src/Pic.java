//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pic {
    private Pixel[][] pixels;
    private BufferedImage buff;
    private String imageName;

    public Pic(String var1) {
        try {
            this.buff = ImageIO.read(new File(var1));
        } catch (Exception var10) {
            var10.printStackTrace();
            System.err.println("Silly goose! That\'s not a valid file name.");
            System.exit(0);
        }

        this.imageName = var1;
        this.pixels = new Pixel[this.buff.getHeight()][this.buff.getWidth()];
        ColorModel var2 = this.buff.getColorModel();

        for(int var3 = 0; var3 < this.pixels.length; ++var3) {
            for(int var4 = 0; var4 < this.pixels[var3].length; ++var4) {
                int var5 = this.buff.getRGB(var4, var3);
                int var6 = var5 >> 24 & 255;
                int var7 = var5 >> 16 & 255;
                int var8 = var5 >> 8 & 255;
                int var9 = var5 & 255;
                this.pixels[var3][var4] = new Pixel(var7, var8, var9, var6);
            }
        }

    }

    public int getWidth() {
        return this.pixels[0].length;
    }

    public int getHeight() {
        return this.pixels.length;
    }

    public Pixel[][] getPixels() {
        return this.pixels;
    }

    public Pixel getPixel(int var1, int var2) {
        return this.pixels[var2][var1];
    }

    public Pic deepCopy() {
        Pic var1 = new Pic(this.imageName);

        for(int var2 = 0; var2 < this.pixels.length; ++var2) {
            for(int var3 = 0; var3 < this.pixels[var2].length; ++var3) {
                Pixel var4 = var1.getPixels()[var2][var3];
                Pixel var5 = this.pixels[var2][var3];
                var4.setRed(var5.getRed());
                var4.setGreen(var5.getGreen());
                var4.setBlue(var5.getBlue());
                var4.setAlpha(var5.getAlpha());
            }
        }

        return var1;
    }

    public void save(String var1) throws IOException {
        for(int var2 = 0; var2 < this.pixels.length; ++var2) {
            for(int var3 = 0; var3 < this.pixels[var2].length; ++var3) {
                int var4 = this.convert(this.pixels[var2][var3]);
                this.buff.setRGB(var3, var2, var4);
            }
        }

        ImageIO.write(this.buff, "png", new File(var1 + ".png"));
    }

    private int convert(Pixel var1) {
        return var1.getAlpha() << 24 | var1.getRed() << 16 | var1.getGreen() << 8 | var1.getBlue();
    }
}
