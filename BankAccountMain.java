import java.util.*;


class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

class PasswordMismatchException extends Exception {
    public PasswordMismatchException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountHolder;
    private double balance;
    private String password;

    public BankAccount(String accountHolder, double balance, String password) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.password = password;
    }

    public void balanceEnquiry() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: Rs." + balance);
    }

    public void deposit(double amount) throws NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Amount cannot be negative!");
        }
        balance += amount;
        System.out.println("Successfully deposited Rs." + amount);
    }

    public void withdraw(double amount) throws LowBalanceException, NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Amount cannot be negative!");
        }
        if (balance - amount < 500) { // Assuming minimum balance should be Rs.500
            throw new LowBalanceException("Insufficient balance! Minimum Rs.500 must be maintained.");
        }
        balance -= amount;
        System.out.println("Successfully withdrawn Rs." + amount);
    }

    public void transfer(BankAccount recipient, double amount, String enteredPassword) throws PasswordMismatchException, LowBalanceException, NegativeNumberException {
        if (!this.password.equals(enteredPassword)) {
            throw new PasswordMismatchException("Incorrect password! Transfer failed.");
        }
        this.withdraw(amount); 
        recipient.deposit(amount); 
        System.out.println("Successfully transferred Rs." + amount + " to " + recipient.accountHolder);
    }
}


 class BankAccountNew {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[2];
        accounts[0] = new BankAccount("A", 5000, "a123");
        accounts[1] = new BankAccount("B", 3000, "b123");

        try { 
            accounts[0].balanceEnquiry();
            accounts[0].deposit(2000);
            accounts[0].withdraw(1000);
            accounts[0].transfer(accounts[1], 1500, "a123");
            accounts[1].balanceEnquiry();
        } 
		catch (Exception e) {
            System.out.println("Error: ");
        }
    }
}
