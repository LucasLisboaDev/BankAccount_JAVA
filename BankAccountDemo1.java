import java.util.ArrayList;
import java.util.Random;

public class BankAccountDemo1 {
    
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

            // No need to print account details here, we will create a method to print it at the end. 
        }

        // Add additional accounts outside the loop
        BankAccount_LA acctVar1 = new BankAccount_LA(25001.99);
        dupeCheck(accounts, acctVar1);

        BankAccount_LA acctVar2 = new BankAccount_LA(1500, 12503.41);
        dupeCheck(accounts, acctVar2);

        // Print account details and summary
        printAccountDetailsAndSummary(accounts);
    }

    public static void dupeCheck(ArrayList<BankAccount_LA> accounts, BankAccount_LA acctRef) {
        for (BankAccount_LA account : new ArrayList<>(accounts)) {
            if (account.getAcctNo() == acctRef.getAcctNo()) {
                System.out.println("There is already an account with account number " + acctRef.getAcctNo() + ".");
                System.out.println("Bank account " + acctRef.getAcctNo() + " discarded.");
                closeAccount(accounts, account);
                return;
            }
        }
        accounts.add(acctRef); // Add the account if not a duplicate
    }

    public static void closeAccount(ArrayList<BankAccount_LA> accounts, BankAccount_LA acct) {
        if (acct.getBalance() < 0) {
            // overdrawnAccounts--;
        }
        accounts.remove(acct); // Remove the account from the list
        BankAccount_LA.numAccounts--; // Decrement the total number of accounts
    }

    public static void printAccountDetailsAndSummary(ArrayList<BankAccount_LA> accounts) {
        System.out.println("AcctNo  Init Balance  New Balance");
        System.out.println("------  ------------  -----------");

        int overdrawnAccounts = 0 ;

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
}

