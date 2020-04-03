package com.company;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class files {

    public static void main(String[] args) throws IOException {
        // test to see if a directory exist
        // Create it if it doesn't
        // create a file
        // crate and write to the file
        // Break groceries into its own file
        // Append to the file
        // read the list
        // Print the list
        // CREATE_NEW crash
        // TRUNCATE_EXISTING works

        String dataPathName = "data";
        String dataFileName = "data.txt";
        String groceriesFileName = "groceries.txt";

        Path dataPath = Paths.get(dataPathName);
        if (!java.nio.file.Files.exists(dataPath)) {
            java.nio.file.Files.createDirectory(dataPath);
        }
        System.out.println(java.nio.file.Files.exists(dataPath));

        // Create a file
        Path dataFilePath = Paths.get(dataPathName, dataFileName);
//        Files.createFile(dataFilePath);
        String line = "Whose line is it, anyway?";
        java.nio.file.Files.write(dataFilePath, Arrays.asList(line));

        // Break groceries into its own file
        Path groceriesPath = Paths.get(dataPathName, groceriesFileName);
        List<String> groceries = Arrays.asList("eggs", "toilet paper", "sanitizer");
        java.nio.file.Files.write(groceriesPath, groceries);

        // Append to groceries
        line = "tissues";
        java.nio.file.Files.write(groceriesPath, Arrays.asList(line), StandardOpenOption.APPEND);

        // read the list
        List<String> readList = java.nio.file.Files.readAllLines(groceriesPath);
        System.out.println(readList);


    }
}
