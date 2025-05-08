import java.io.*;
import java.util.Scanner;

public class StudentData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Weight: ");
        float weight = sc.nextFloat();
        System.out.print("Enter Height: ");
        float height = sc.nextFloat();
        sc.nextLine(); // consume newline
        System.out.print("Enter City: ");
        String city = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        // Writing data to file
        try {
            FileOutputStream fos = new FileOutputStream("student.dat");
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeUTF(name);
            dos.writeInt(age);
            dos.writeFloat(weight);
            dos.writeFloat(height);
            dos.writeUTF(city);
            dos.writeUTF(phone);

            dos.close();
            fos.close();
            System.out.println("\nData saved successfully to student.dat\n");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // Reading data from file
        try {
            FileInputStream fis = new FileInputStream("student.dat");
            DataInputStream dis = new DataInputStream(fis);

            String rName = dis.readUTF();
            int rAge = dis.readInt();
            float rWeight = dis.readFloat();
            float rHeight = dis.readFloat();
            String rCity = dis.readUTF();
            String rPhone = dis.readUTF();

            dis.close();
            fis.close();

            // Displaying read data
            System.out.println("----- Student Details Retrieved -----");
            System.out.println("Name: " + rName);
            System.out.println("Age: " + rAge);
            System.out.println("Weight: " + rWeight);
            System.out.println("Height: " + rHeight);
            System.out.println("City: " + rCity);
            System.out.println("Phone: " + rPhone);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
