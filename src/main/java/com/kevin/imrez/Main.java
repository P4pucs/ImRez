package com.kevin.imrez;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] arg) throws IOException {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("folderLocation?");
//        String folderLocation = scanner.nextLine();
//        scanner.close();
//        System.out.println(folderLocation);

        String fromPath = "C:\\Users\\Kevin\\Pictures\\";
        String toPath = "C:\\Users\\Kevin\\Desktop\\";


        Pattern imagePattern = Pattern.compile("(.*)(.jpg|.png)", Pattern.CASE_INSENSITIVE);
        Matcher imageMatcher;

        File [] files = new File(fromPath).listFiles();

        ArrayList<Image> images = new ArrayList<>();

        for (File file : files) {
            imageMatcher = imagePattern.matcher(file.getName());

            if (file.isFile() && imageMatcher.matches()) {
                images.add(new Image(file.getName(), ImageIO.read(file)));
            }
        }

        for (Image image: images) {
            System.out.println("name: " + image.getName() +
                    "  width: " + image.getImage().getWidth() +
                    "  height: " + image.getImage().getHeight());
        }


//        try {
//            Files.copy(file.toPath(), new File(toPath + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
