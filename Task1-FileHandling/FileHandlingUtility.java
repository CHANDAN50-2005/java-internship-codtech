import java.io.*;
import java.nio.file.*;

/**
 * A utility class to perform basic file operations:
 * writing, reading, and modifying text files using Java.
 *
 * Task 1 - CodTech Internship (File Handling Utility)
 * Author: Chandan
 * Date: June 2025
 */
public class FileHandlingUtility {

    /**
     * Writes content to a specified file.
     * If the file doesn't exist, it creates one.
     *
     * @param filePath The path to the file
     * @param content  The content to write into the file
     */
    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("✅ File written successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing file: " + e.getMessage());
        }
    }

    /**
     * Reads and prints the content of the specified file line by line.
     *
     * @param filePath The path to the file to read
     */
    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("\n📄 File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }

    /**
     * Modifies the file by replacing all occurrences of a given word
     * with a new word.
     *
     * @param filePath The path to the file
     * @param oldWord  The word to be replaced
     * @param newWord  The word to replace with
     */
    public static void modifyFile(String filePath, String oldWord, String newWord) {
        try {
            Path path = Paths.get(filePath);
            String content = Files.readString(path);

            content = content.replaceAll(oldWord, newWord); // Modify text

            Files.writeString(path, content); // Write updated text
            System.out.println("✏️ File modified successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error modifying file: " + e.getMessage());
        }
    }

    /**
     * The main method that tests writing, reading, and modifying a file.
     * Demonstrates the use of all file utility methods.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        String filePath = "sample.txt";
        String content = "This is a simple file handling utility in Java.\nThis file will be modified.";

        writeFile(filePath, content);                    // Step 1: Write
        readFile(filePath);                              // Step 2: Read
        modifyFile(filePath, "file", "text");            // Step 3: Modify
        readFile(filePath);                              // Step 4: Read again
    }
}