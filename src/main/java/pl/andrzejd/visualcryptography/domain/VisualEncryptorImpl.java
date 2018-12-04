package pl.andrzejd.visualcryptography.domain;

import pl.andrzejd.visualcryptography.infrastructure.InputImage;
import pl.andrzejd.visualcryptography.infrastructure.OutputImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VisualEncryptorImpl implements VisualEncryptor {
    private BufferedImage inputImage;

    public VisualEncryptorImpl(BufferedImage inputImage) {
        this.inputImage = inputImage;
    }

    public List<OutputImage> encrypt(BufferedImage image) {
        OutputImage outputImage1 = new OutputImage(
                image.getWidth() * 2,
                image.getHeight() * 2,
                image.getType()
        );
        OutputImage outputImage2 = new OutputImage(
                image.getWidth() * 2,
                image.getHeight() * 2,
                image.getType()
        );

        Random random = new Random();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                if (new Color(image.getRGB(i, j)).equals(Color.BLACK)) {
                    boolean choice = random.nextBoolean();
                    ArrayList<Color> pixels1 = new ArrayList<Color>(Arrays.asList(
                            Color.BLACK,
                            Color.WHITE,
                            Color.BLACK,
                            Color.WHITE
                    ));
                    ArrayList<Color> pixels2 = new ArrayList<Color>(Arrays.asList(
                            Color.WHITE,
                            Color.BLACK,
                            Color.WHITE,
                            Color.BLACK
                    ));

                    outputImage1.setPixels(i * 2, j * 2, (choice) ? pixels1 : pixels2);
                    outputImage2.setPixels(i * 2, j * 2, (!choice) ? pixels1 : pixels2);
                } else {
                    ArrayList<Color> pixels = new ArrayList<Color>(Arrays.asList(
                            (random.nextBoolean()) ? Color.WHITE : Color.BLACK,
                            (random.nextBoolean()) ? Color.WHITE : Color.BLACK,
                            (random.nextBoolean()) ? Color.WHITE : Color.BLACK,
                            (random.nextBoolean()) ? Color.WHITE : Color.BLACK
                    ));

                    outputImage1.setPixels(i * 2, j * 2, pixels);
                    outputImage2.setPixels(i * 2, j * 2, pixels);
                }
            }
        }

        return new ArrayList<OutputImage>(Arrays.asList(outputImage1, outputImage2));
    }

    public List<OutputImage> encrypt() {
        return encrypt(inputImage);
    }
}
