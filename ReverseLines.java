import java.io.*;
import java.util.*;

public class ReverseLines {
    public static void main(String[] args) {
        
        LinkedList<String> lines = new LinkedList<>();

        // Escape backslashes properly
        String filePath = "C:\\Users\\Hp\\Documents\\75_java\\75_Experiment_13\\demo.txt"; 
    

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            System.out.println("Lines in reverse order:");
            for (int i = lines.size() - 1; i >= 0; i--) {
                System.out.println(lines.get(i));
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file " + filePath + " was not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}
