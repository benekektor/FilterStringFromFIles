package com.chmnu_ki_123.k3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StringFilter {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java StringFilter <inputFilePath> <outputFilePath> <filterWord>");
            return;
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];
        String filterWord = args[2];

        try {
            filterStrings(inputFilePath, outputFilePath, filterWord);
            System.out.println("Filtered strings have been written to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }

    private static void filterStrings(String inputFilePath, String outputFilePath, String filterWord) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        FileWriter writer = new FileWriter(outputFilePath);
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.contains(filterWord)) {
                writer.write(line + "\n");
            }
        }

        reader.close();
        writer.close();
    }

    public static void filterStringsWrapper(String inputFilePath, String outputFilePath, String filterWord) throws IOException {
        filterStrings(inputFilePath, outputFilePath, filterWord);
    }
}