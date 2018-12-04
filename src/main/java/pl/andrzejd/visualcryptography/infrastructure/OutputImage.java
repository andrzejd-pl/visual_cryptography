package pl.andrzejd.visualcryptography.infrastructure;

import java.awt.*;
import java.awt.image.*;
import java.util.Hashtable;
import java.util.List;

public class OutputImage extends BufferedImage implements RenderedImage {
    public OutputImage(int width, int height, int imageType) {
        super(width, height, imageType);
    }

    public OutputImage(int width, int height, int imageType, IndexColorModel cm) {
        super(width, height, imageType, cm);
    }

    public OutputImage(ColorModel cm, WritableRaster raster, boolean isRasterPremultiplied, Hashtable<?, ?> properties) {
        super(cm, raster, isRasterPremultiplied, properties);
    }

    public void setPixels(int beginX, int beginY, List<Color> pixels) {
        this.setRGB(beginX, beginY, pixels.get(0).getRGB());
        this.setRGB(beginX, beginY + 1, pixels.get(1).getRGB());
        this.setRGB(beginX + 1, beginY, pixels.get(2).getRGB());
        this.setRGB(beginX + 1, beginY + 1, pixels.get(3).getRGB());
    }
}
