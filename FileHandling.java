/* Take file name as input to your program through command line, If file is existing the open and 
display contents of the file. After displaying contents of file ask user – 1.do you want to add the data at the end of file or 
2.replace specified text in file by other text. Based on user’s response, then accept data from user and append it to file. If 
file in not existing then create a fresh new file and store user data into it. Also. User should type exit on new line to stop 
the program. Do this program using Character stream classes. */

import java.io.*;
import java.util.Scanner;

public class FileHandling {
    public static void displayFileContent(String filename){
        try {
            System.err.println("File content are :");
            FileReader fr = new FileReader(filename);
            readFileContent(fr);
            fr.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());            
        }
    }
    public static void readFileContent(FileReader fr){
        try {
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); 
            }
            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static void appendToFile(String filename){
        try {
            FileWriter fw = new FileWriter(filename, true); // true for append mode
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter text to append (type 'exit' to stop): ");
            String input;
            while (!(input = scanner.nextLine()).equalsIgnoreCase("exit")) {
                fw.write(input + "\n");
            }
            fw.close();
            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }

    public static void replaceTextInFile(String filename){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the text to replace: ");
            String oldText = scanner.nextLine();
            System.out.print("Enter the new text: ");
            String newText = scanner.nextLine();

            File file = new File(filename);
            StringBuilder fileContent = new StringBuilder();
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                fileContent.append(line.replace(oldText, newText)).append("\n");
            }
            fileScanner.close();

            FileWriter fw = new FileWriter(filename);
            fw.write(fileContent.toString());
            fw.close();
        
            System.out.println("Text replaced successfully.");
        } catch (IOException e) {
            System.err.println("Error replacing text in file: " + e.getMessage());
        }
    }



    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = scanner.nextLine();
        
        File file = new File(filename);
        if (file.exists()) {
            displayFileContent(filename);
            System.out.println("\nChoose an option:  \n1. Append data to the file   \n2. Replace specified text\n");
            System.out.print("Enter your choice (1/2): ");
            String choice = scanner.nextLine();
            
            if (choice.equals("1")) {
                appendToFile(filename);
            } else if (choice.equals("2")) {
                replaceTextInFile(filename);
            } else {
                System.out.println("Invalid choice. Exiting.");
            } 
        }
        else {
            System.out.println("File does not exist. Creating a new file.");
            try {
                file.createNewFile();
                System.out.println("New file created: " + filename);
                appendToFile(filename);
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
            }
        }
    } 

}