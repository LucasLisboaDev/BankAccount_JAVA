/*************************************************************************
 * Program: BankAccountDemo.java
 * Author: Lucas L. Alves
 *
 * Purpose: Program creates and manages Bank Accounts 

 * Date Created: Apr 14, 2024
 * Date Completed: Apr 17, 2024
 *************************************************************************/

import java.util.ArrayList;
import java.util.Random;

public class bankAccountDemo_LA {
    
    final static int BIRTH_YEAR = 1995;

    public static void main(String[] args) {
        ArrayList<BankAccount_LA> accounts = new ArrayList<>(); // I am creating the array list in here. 
        Random random = new Random();  
        int localOverdrawnCount = 0;

        // Create initial 1995 accounts - I am getting older and older Professor. 
        for (int i = 1; i <= BIRTH_YEAR; i++) { 
            BankAccount_LA newAccount = new BankAccount_LA(i);
            double NewBal;

            if (i % 2 == 0) {
                // Deposit for even account numbers
                newAccount.deposit(random.nextDouble() * 1000);
            } else {
                // Withdraw for odd account numbers
                newAccount.withdraw(random.nextDouble() * 2500);
            }
            NewBal = newAccount.getBalance();

            if (NewBal < 0) {
                localOverdrawnCount++;
                BankAccount_LA.overdrawnAccounts++;
            }

            // Check for duplicates and add to list
            dupeCheck(accounts, newAccount);
        }

        // Add additional accounts outside the loop
        BankAccount_LA acctVar1 = new BankAccount_LA(25001.99);
        dupeCheck(accounts, acctVar1);

        BankAccount_LA acctVar2 = new BankAccount_LA(1500, 12503.41);
        dupeCheck(accounts, acctVar2);

        BankAccount_LA acctVar3 = new BankAccount_LA(4500, 12.50);
        dupeCheck(accounts, acctVar3);

        // Print account details and summary
        System.out.println("AcctNo  Init Balance  New Balance");
        System.out.println("------  ------------  -----------");

        int overdrawnAccounts = 0 + localOverdrawnCount;

        for (BankAccount_LA account : accounts) {
            double initialBalance = account.getInitialBalance(); // Use the getter for initial balance
            double newBalance = account.getBalance();
            String overdrawnMarker = newBalance < 0 ? " <== OVERDRAWN" : "";
            if (newBalance < 0) {
                overdrawnAccounts++;
            }
            System.out.printf("%04d    $ %10.2f   $ %10.2f%s\n", account.getAcctNo(), initialBalance, newBalance, overdrawnMarker);
        }

        int accountsInGoodStanding = accounts.size() - overdrawnAccounts;

        System.out.println("\nNumber of accounts: " + accounts.size());
        System.out.println("Number of accounts in good standing: " + accountsInGoodStanding);
        System.out.println("Number of overdrawn accounts: " + overdrawnAccounts);
    }
    

    public static void dupeCheck(ArrayList<BankAccount_LA> accounts, BankAccount_LA acctRef) {
        for (BankAccount_LA account : new ArrayList<>(accounts)) {
            if (account.getAcctNo() == acctRef.getAcctNo()) {
                System.out.println("There is already an account with account number " + acctRef.getAcctNo() + ".");
                System.out.println("Bank account " + acctRef.getAcctNo() + " discarded.");
                BankAccount_LA.closeAccount(account);
                accounts.remove(account);
                return;
            }
        }
        accounts.add(acctRef); // Add the account if not a duplicate
    }
}

