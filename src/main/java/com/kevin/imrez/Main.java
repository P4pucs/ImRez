package com.kevin.imrez;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] arg) {

        Properties p = new Properties();
        try {
            FileInputStream in = new FileInputStream("config.ini");
            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fromPath = p.get("fromPath").toString();
        String toPath = p.get("toPath").toString();

        Pattern imagePattern = Pattern.compile("(.*)(.jpg|.png)", Pattern.CASE_INSENSITIVE);
        Matcher imageMatcher;

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("folderLocation?");
//        fromPath = scanner.nextLine();
//        scanner.close();
//        System.out.println(toPath);

        File tmp = new File(fromPath);
        if(!(tmp.exists() || tmp.isDirectory())) {
            System.out.println("filepath not found");
            return;
        }

        File IEAIAIO = new File(toPath);
        if(!(IEAIAIO.exists() || IEAIAIO.isDirectory())) {
            System.out.println("Directory not found...SO I MADE IT");
            IEAIAIO.mkdirs();
        }

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
            try {
                ImageIO.write(image.scaledImage(), image.getType(), new File(toPath + image.getGUID() + "." + image.getType()));

                System.out.println("name: " + toPath + image.getGUID() + "." +  image.getType());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
