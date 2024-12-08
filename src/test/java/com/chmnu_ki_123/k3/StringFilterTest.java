package com.chmnu_ki_123.k3;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringFilterTest {
    @Test
    public void testFilterStrings() throws IOException {

        String inputFilePath = "testInput.txt";
        String outputFilePath = "testOutput.txt";
        String filterWord = "filter";

        FileWriter writer = new FileWriter(inputFilePath);
        writer.write("This line contains filter word.\n");
        writer.write("This line does not.\n");
        writer.write("Another line with filter word.\n");
        writer.close();

        StringFilter.filterStringsWrapper(inputFilePath, outputFilePath, filterWord);

        BufferedReader reader = new BufferedReader(new FileReader(outputFilePath));
        StringBuilder outputContent = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            outputContent.append(line).append("\n");
        }
        reader.close();

        String expectedOutput = "This line contains filter word.\n" +
                "Another line with filter word.\n";
        assertEquals(expectedOutput, outputContent.toString());

        new File(inputFilePath).delete();
        new File(outputFilePath).delete();
    }
}

