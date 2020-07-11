package com.kevin.imrez;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String [] arg) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("folderLocation?");
//        String folderLocation = scanner.nextLine(); // scanner.findInLine ("pattern"); TODO
//        scanner.close();
//        System.out.println(folderLocation);

        String fromPath = "C:\\Users\\Kevin\\Pictures\\april.jpg";
        String toPath = "C:\\Users\\Kevin\\Desktop\\";

        File file = new File(fromPath);

        try {
            Files.copy(file.toPath(), new File(toPath + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
