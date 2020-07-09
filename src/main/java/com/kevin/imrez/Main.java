package com.kevin.imrez;

import java.util.Scanner;

public class Main {
    public static void main(String [] arg) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("folderLocation?");
        String folderLocation = scanner.nextLine(); // scanner.findInLine ("pattern"); TODO
        scanner.close();
        System.out.println(folderLocation);
    }
}
