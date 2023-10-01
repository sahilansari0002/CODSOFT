/**
 * Program: The Word Counter.
 * Developer: Sahil Ali
 * Project: Codsoft Internship Task
 * Date Created: September 19, 2023
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Word Counter /Developed By Codsoft");

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Enter text");
            System.out.println("2. Provide a file");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    input.nextLine(); 
                    System.out.print("Enter your text: ");
                    String inputText = input.nextLine();
                    countWords(inputText);
                    break;
                case 2:
                    input.nextLine();
                    System.out.print("Enter the path to the file: ");
                    String filePath = input.nextLine();
                    try {
                        String fileContent = readFile(filePath);
                        countWords(fileContent);
                    } catch (IOException e) {
                        System.err.println("Error reading the file: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    public static void countWords(String text) 
	{
              String[] words = text.split("[\\s\\p{Punct}]+");
      
        int wordCount = words.length;

        Set<String> uniqueWords = new HashSet<>();
        Map<String, Integer> wordFrequencies = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase(); 
            uniqueWords.add(word);
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }
        System.out.println("Total words: " + wordCount);
        System.out.println("Unique words: " + uniqueWords.size());
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
