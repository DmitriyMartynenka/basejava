package com.basejava.webapp;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        String filePath = "./src/com/basejava/webapp";
        File dir = new File(filePath);
        printDirectoryTree(dir, "");
    }

    private static void printDirectoryTree(File dir, String offset) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(offset + "Directory " + file.getName());
                    printDirectoryTree(file, offset + "\t");
                } else {
                    System.out.println(offset + file.getName());
                }
            }
        }
    }
}