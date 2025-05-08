import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Emp1 emp1 = null;
        Emp1 emp2 = null;

        for (int i = 0; i < 2; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Monthly Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            if (i == 0) {
                emp1 = new Emp1(firstName, lastName, salary);
            } else {
                emp2 = new Emp1(firstName, lastName, salary);
            }
        }

        System.out.println("\nYearly salary of Emp 1: " + emp1.getFirstName() + " " + emp1.getLastName() + " => " + (emp1.getMonthlySalary() * 12));
        System.out.println("Yearly salary of Emp 2: " + emp2.getFirstName() + " " + emp2.getLastName() + " => " + (emp2.getMonthlySalary() * 12));

        System.out.println("\nAfter a 10% raise:");
        System.out.println("Salary of " + emp1.getFirstName() + " " + emp1.getLastName() + " => " + (emp1.getMonthlySalary() * 12 * 1.1));
        System.out.println("Salary of " + emp2.getFirstName() + " " + emp2.getLastName() + " => " + (emp2.getMonthlySalary() * 12 * 1.1));
    }
}

// Employee class
class Emp1 {
    private String firstName;
    private String lastName;
    private double ms;

    // Constructor
    Emp1(String firstName, String lastName, double ms) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (ms < 0) {
            System.out.println("Monthly salary cannot be negative. Setting salary to 0.0.");
            this.ms = 0.0; 
        } else {
            this.ms = ms;
        }
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMonthlySalary() {
        return ms;
    }
    public void setMonthlySalary(double ms) {
        this.ms = ms > 0 ? ms : 0.0;
    }
}
