package com.kevin.imrez;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] arg) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("folderLocation?");
//        String folderLocation = scanner.nextLine(); // scanner.findInLine ("pattern"); TODO
//        scanner.close();
//        System.out.println(folderLocation);

        String fromPath = "C:\\Users\\Kevin\\Pictures\\";
        String toPath = "C:\\Users\\Kevin\\Desktop\\";

        Pattern imagePattern = Pattern.compile("(.*)(.jpg|.png)");
        Matcher imageMatcher;

        File [] files = new File(fromPath).listFiles();

        ArrayList<File> images = new ArrayList<>();

        for (File file : files) {
            imageMatcher = imagePattern.matcher(file.toString());

            if (file.isFile() && imageMatcher.matches())
                images.add(file);
        }

        for (Object image: images) {
            System.out.println(image);
        }

//        try {
//            Files.copy(file.toPath(), new File(toPath + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
