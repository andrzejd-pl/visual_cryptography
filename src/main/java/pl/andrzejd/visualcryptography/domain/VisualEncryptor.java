package pl.andrzejd.visualcryptography.domain;

import pl.andrzejd.visualcryptography.infrastructure.OutputImage;

import java.awt.image.BufferedImage;
import java.util.List;

public interface VisualEncryptor {
    List<OutputImage> encrypt(BufferedImage image);
    List<OutputImage> encrypt();
}
