package Math;

import Math.Convert.*;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Statistical Operations
        System.out.println("Enter integers for statistical operations (comma-separated):");
        String[] input = scanner.nextLine().split(",");
        int[] data = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            data[i] = Integer.parseInt(input[i].trim());
        }

        System.out.println("Mean: " + StatisticalOperations.mean(data));
        System.out.println("Median: " + StatisticalOperations.median(data));
        System.out.println("Standard Deviation: " + StatisticalOperations.standardDeviation(data));

        // Conversion Operations
        System.out.println("\nEnter a decimal number for conversion:");
        int decimal = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Decimal to Binary: " + DecimalToBinary.convert(decimal));
        System.out.println("Decimal to Hex: " + DecimalToHex.convert(decimal));
        System.out.println("Decimal to Octal: " + DecimalToOctal.convert(decimal));

        // Test Binary to Decimal
        System.out.println("\nEnter a binary number for conversion:");
        String binary = scanner.nextLine();
        System.out.println("Binary to Decimal: " + BinaryToDecimal.convert(binary));

        // Test Hex to Decimal
        System.out.println("\nEnter a hexadecimal number for conversion:");
        String hex = scanner.nextLine();
        System.out.println("Hex to Decimal: " + HexToDecimal.convert(hex));

        // Test Octal to Decimal
        System.out.println("\nEnter an octal number for conversion:");
        String octal = scanner.nextLine();
        System.out.println("Octal to Decimal: " + OctalToDecimal.convert(octal));

    }
}
