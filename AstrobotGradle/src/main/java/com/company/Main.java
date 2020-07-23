package com.company;

import java.io.File;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Throwable {
        ChatFeatures cf = new ChatFeatures();
        File file = new File("astrofile.txt");
        Scanner scanner = new Scanner(System.in);
        Scanner scannerFromFile = new Scanner(file);
        System.out.println("Hi! Astrobot welcomes you!");
        String lastAnswer = "";
        while (!lastAnswer.equalsIgnoreCase("n")) {
            lastAnswer = cf.chat(scanner);
        }

        System.out.println("Ok, next time... Exiting chat...");
        scannerFromFile.close();
        scanner.close();
    }


}
