package com.kevin.imrez;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] arg) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("folderLocation?");
//        String folderLocation = scanner.nextLine();
//        scanner.close();
//        System.out.println(folderLocation);

        String fromPath = "C:\\Users\\Kevin\\Pictures\\";
        String toPath = "C:\\Users\\Kevin\\Desktop\\Pictures\\";


        Pattern imagePattern = Pattern.compile("(.*)(.jpg|.png)", Pattern.CASE_INSENSITIVE);
        Matcher imageMatcher;

        File [] files = new File(fromPath).listFiles();

        ArrayList<ImageData> images = new ArrayList<>();

        for (File file : files) {
            imageMatcher = imagePattern.matcher(file.getName());

            if (file.isFile() && imageMatcher.matches()) {
                try {
                    images.add(new ImageData(file.getName() ,ImageIO.read(file)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        for(ImageData image : images) {
            Image imageTmp = image.getImage().getScaledInstance((int) (image.getImage().getWidth() * image.getScale()), (int) (image.getImage().getHeight() * image.getScale()), Image.SCALE_SMOOTH);
            BufferedImage sajt = new BufferedImage((int) (image.getImage().getWidth() * image.getScale()), (int) (image.getImage().getHeight() * image.getScale()), BufferedImage.TYPE_INT_RGB);
            Graphics2D alma = sajt.createGraphics();
            alma.drawImage(imageTmp, 0, 0, null);
            alma.dispose();

            try {

                ImageIO.write(sajt, image.getType(), new File(toPath + image.getGUID() + "." + image.getType()));

                System.out.println("name: " + toPath + image.getGUID() + "." +  image.getType());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

/*        try {
            for (Image image : images) {
                ImageIO.write(image.getImage(), image.getName().split("\\.")[1], new File(toPath + image.getName()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
