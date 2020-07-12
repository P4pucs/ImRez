package com.kevin.imrez;

import java.awt.image.BufferedImage;

public class Image {
    private String name;
    private BufferedImage image;

    public Image(String name, BufferedImage image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public BufferedImage getImage() {
        return image;
    }
}
