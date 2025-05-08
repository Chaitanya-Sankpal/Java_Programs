/*import java.util.*;

  class SavingsAccount 
{
    
    static  double annualInterestRate;
    private double savingsBalance;

    SavingsAccount(double balance) 
    {
        savingsBalance = balance;
    }
    
    public static void setAnnualInterestRate(double interestRate) 
    {
        annualInterestRate = interestRate/100;
    }
   
    public void calculateMonthlyInterest() 
    {
        double monthlyInterest = savingsBalance * (annualInterestRate / 12);
        savingsBalance = savingsBalance + monthlyInterest;
    }
 
    public static void modifyInterestRate(double newRate) 
    {
        annualInterestRate = newRate;
    }

    public double getSavingsBalance() 
    {
        return savingsBalance;
    }

    
}
public  class SavingsAccountTest {
    public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);

       System.out.print("Enter the Saving Balance of saver 1=>");
       double amount1=sc.nextDouble();
       System.out.print("Enter the Saving Balance of saver 2=>");
       double amount2=sc.nextDouble();
       System.out.print("Enter the interest rate =>");
       double rate=sc.nextDouble();

        SavingsAccount saver1 = new SavingsAccount(amount1);
        SavingsAccount saver2 = new SavingsAccount(amount2); 

      saver1.setAnnualInterestRate(rate); // 4%
      saver2.setAnnualInterestRate(rate);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("Saver 1 balance after "  + rate + "% interest:"+ saver1.getSavingsBalance());
        System.out.println("Saver 2 balance after " + rate + "% interest:"+saver2.getSavingsBalance());
        System.out.println("----------------------------------------------------------");
		
		
        System.out.print("Enter the  modified interest rate =>");
        double rate1=sc.nextDouble();
        saver1.modifyInterestRate(rate1); // 5%
        saver2.modifyInterestRate(rate1);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("Saver 1 new balance after "  + rate1 + "% interest :"+saver1.getSavingsBalance());
        System.out.println("Saver 2 new balance after " + rate1 + "% interest :"+saver2.getSavingsBalance());
    }
}
*/
  class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    // Constructor
    public SavingsAccount(double balance) {
        this.savingsBalance = balance;
    }

    // Calculate monthly interest and update balance
    public void calculateMonthlyInterest() {
        savingsBalance += savingsBalance * (annualInterestRate / 12);
    }

    // Modify the annual interest rate (static method)
    public static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate / 100;
    }

    // Get current balance
    public double getSavingsBalance() {

        return savingsBalance;
        
    }
}

public class SavingsAccountTest {
    public static void main(String[] args) {
        // Instantiate savings accounts
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        // Set and calculate initial interest at 4%
        SavingsAccount.modifyInterestRate(4.0);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        // Display balances
        System.out.println("Saver 1 balance after 4% interest: Rs " + saver1.getSavingsBalance());
        System.out.println("Saver 2 balance after 4% interest: Rs " + saver2.getSavingsBalance());

        System.out.println("----------------------------------------");

        // Modify interest rate to 5%
        SavingsAccount.modifyInterestRate(5.0);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        // Display new balances
        System.out.println("Saver 1 balance after 5% interest: Rs " + saver1.getSavingsBalance());
        System.out.println("Saver 2 balance after 5% interest: Rs " + saver2.getSavingsBalance());
    }
}
