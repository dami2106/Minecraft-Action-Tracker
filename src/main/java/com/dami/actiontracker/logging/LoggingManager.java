package com.dami.actiontracker.logging;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class LoggingManager {
    public static boolean LOGGING = false;
    public static String FILENAME = "action_log";


    public static void createFile() {
        try {
            // Create a FileWriter object with the given file path
            FileWriter fileWriter = new FileWriter(FILENAME + ".txt");

            // Create a BufferedWriter to write efficiently
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Close the BufferedWriter to flush and write changes to the file
            bufferedWriter.close();

            System.out.println("File created successfully: " + FILENAME);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeLine(String line) {
        try {
            // Create a FileWriter object with the given file path (true for append mode)
            FileWriter fileWriter = new FileWriter(FILENAME, true);

            // Create a BufferedWriter to write efficiently
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the given line to the file
            bufferedWriter.write(line);
            bufferedWriter.newLine(); // Add a new line after each write

            // Close the BufferedWriter to flush and write changes to the file
            bufferedWriter.close();

            System.out.println("Line written to file: " + line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
