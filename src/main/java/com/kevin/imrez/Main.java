package com.kevin.imrez;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

        ArrayList<Image> images = new ArrayList<>();

        for (File file : files) {
            imageMatcher = imagePattern.matcher(file.getName());

            if (file.isFile() && imageMatcher.matches()) {
                try {
                    images.add(new Image(file.getName(), ImageIO.read(file)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        for (Image image: images) {
            System.out.println("name: " + image.getName() +
                    "  width: " + image.getImage().getWidth() +
                    "  height: " + image.getImage().getHeight());
        }

        try {
            for (Image image : images) {
                ImageIO.write(image.getImage(), image.getName().split("\\.")[1], new File(toPath + image.getName()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
