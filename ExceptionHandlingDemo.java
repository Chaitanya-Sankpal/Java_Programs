import java.io.*;

public class ExceptionHandlingDemo {

    // Method that throws a compile-time exception
    static void readFile() throws IOException {
        FileReader file = new FileReader("non_existing_file.txt");
        BufferedReader fileInput = new BufferedReader(file);
        System.out.println(fileInput.readLine());
        fileInput.close();
    }

    public static void main(String[] args) {
        try {
            // 1. ArithmeticException (runtime)
            int result = 10 / 0;

            // 2. ArrayIndexOutOfBoundsException (runtime)
            int[] arr = new int[3];
            System.out.println(arr[5]);

            // 3. NullPointerException (runtime)
            String str = null;
            System.out.println(str.length());

            // 4. NumberFormatException (runtime)
            String number = "abc";
            int num = Integer.parseInt(number);

            // 5. IOException (compile-time) - called method throws it
            readFile();

        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }

        System.out.println("Program continues after exception handling.");
    }
}
