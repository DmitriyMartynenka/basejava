package com.basejava.webapp;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        String filePath = "C:\\Basejava\\basejava\\src\\com\\basejava\\webapp";
        File dir = new File(filePath);
        printDirectoryTree(dir);
    }

    private static void printDirectoryTree(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory " + file.getName());
                printDirectoryTree(file);
            } else {
                System.out.println("File " + file.getName());
            }
        }
    }
}