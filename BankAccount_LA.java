/*************************************************************************
 * Program: BankAccount.java
 * Author: Lucas L. Alves
 *
 * Purpose: Program creates and manages Bank Accounts 

 * Date Created: Apr 14, 2024
 * Date Completed: Apr 17, 2024
 *************************************************************************/
import java.util.Random;

public class BankAccount_LA {
    
    public static int numAccounts = 0;
    public static int overdrawnAccounts = 0;
    private int acctNo;
    private double balance;
    private double initialBalance;
    private static final Random random = new Random();

    public BankAccount_LA() {
        this(0, 0.0); // Assign default values
        this.balance = initialBalance;
    };

    public BankAccount_LA(int acctNo) {
        this.acctNo = acctNo;
        this.initialBalance = random.nextDouble(2500) ; // Set initial balance to a random value
        this.balance = initialBalance; // Set balance to the initial balance
        numAccounts++;
        
    }

    public BankAccount_LA(double balance) {
        this.acctNo = 3000 + random.nextInt(1000); // Generate a random account number
        this.initialBalance = balance; // Set initial balance to the given value
        this.balance = initialBalance;
        numAccounts++;
        
    }

    public BankAccount_LA(int acctNo, double balance) {
        this.acctNo = acctNo;
        this.initialBalance = balance; // Set initial balance to the given value
        this.balance = initialBalance;
        numAccounts++;
        
    }

    
    public void setBalance(double balance) {
        this.balance = balance;
    
    }

    public void setAcctNo(int acctNo) {
        this.acctNo = acctNo;
    }
    public double getInitialBalance() {
        return initialBalance;
    }

    // Get the balance
    public double getBalance() {
        return this.balance;
    }

   
    public int getAcctNo() {
        return this.acctNo;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
           
        }
    }

   
    public void withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            
        }
    }

    
    public static void closeAccount(BankAccount_LA bankAcct) {
        if (bankAcct.balance < 0) {
            overdrawnAccounts--; // Decrement if the account was overdrawn
        }
        numAccounts--; // Always decrement the total count
    }
}

