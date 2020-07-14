package com.kevin.imrez;

import java.awt.image.BufferedImage;
import java.util.UUID;

public class ImageData {
    private final String name;
    private final BufferedImage image;
    private final String GUID;

    public ImageData(String name,BufferedImage image) {
        this.name = name;
        this.GUID = UUID.randomUUID().toString();
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getGUID() { return GUID; }

    public String getType() { return name.split("\\.")[1]; }

    public BufferedImage getImage() { return image; }

    public boolean needScaling() {
        return image.getHeight() > 1000 || image.getWidth() > 1000;
    }

    public double getScale() {
        if (!needScaling()) {
            return 1.0;
        } else {
            return (double)1000/Math.max(image.getWidth(), image.getHeight());
        }
    }



}
