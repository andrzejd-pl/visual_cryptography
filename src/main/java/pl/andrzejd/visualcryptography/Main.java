package pl.andrzejd.visualcryptography;

import pl.andrzejd.visualcryptography.domain.VisualEncryptor;
import pl.andrzejd.visualcryptography.domain.VisualEncryptorImpl;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String args[]) throws IOException {
        VisualEncryptor visualEncryptor =
                new VisualEncryptorImpl(ImageIO.read(new File("oldImage.jpg")));
        List files = visualEncryptor.encrypt();

        ImageIO.write((RenderedImage) files.get(0), "jpg", new File("newImage.jpg"));
        ImageIO.write((RenderedImage) files.get(1), "jpg", new File("newImage2.jpg"));
    }
}
