// import java.util.ArrayList;
// import java.util.Random;

// public class BankAccountDemo {
    
//     final static int BIRTH_YEAR = 1995;
    

//     public static void main(String[] args) {
//         ArrayList<BankAccount> accounts = new ArrayList<>();
//         Random random = new Random();

//         // Create initial accounts
//         for (int i = 1; i <= BIRTH_YEAR; i++) {
//             BankAccount newAccount = new BankAccount(i);
//             double InitialBalance = newAccount.getBalance();

//             if (i % 2 == 0) {
//                 // Deposit for even account numbers
//                 newAccount.deposit(random.nextDouble() * 1000);
//             } else {
//                 // Withdraw for odd account numbers
//                 newAccount.withdraw(random.nextDouble() * 2500);
//             }

//             // Check for duplicates and add to list
//             dupeCheck(accounts, newAccount);

//             //print account
//             System.out.printf("%04d    $ %10.2f   $ %10.2f%s\n", newAccount.getAcctNo(), InitialBalance, newAccount.getBalance());

//         }

//         // Add additional accounts outside the loop
//         BankAccount acctVar1 = new BankAccount(25001.99);
//         dupeCheck(accounts, acctVar1);

//         BankAccount acctVar2 = new BankAccount(1500, 12503.41);
//         dupeCheck(accounts, acctVar2);

//         // Print account details and summary
//         printAccountDetailsAndSummary(accounts);
//     }

//     public static void dupeCheck(ArrayList<BankAccount> accounts, BankAccount acctRef) {
//         for (BankAccount account : new ArrayList<>(accounts)) {
//             if (account.getAcctNo() == acctRef.getAcctNo()) {
//                 System.out.println("There is already an account with account number " + acctRef.getAcctNo() + ".");
//                 System.out.println("Bank account " + acctRef.getAcctNo() + " discarded.");
//                 System.out.printf("%d $ %.2f $ %.2f\n", acctRef.getAcctNo(),0.00, acctRef.getBalance());
//                 closeAccount(accounts, account);
//                 return;
//             }
//         }
//         accounts.add(acctRef); // Add the account if not a duplicate
//     }

//     public static void closeAccount(ArrayList<BankAccount> accounts, BankAccount acct) {
//         accounts.remove(acct); // Remove the account from the list
//         BankAccount.numAccounts--; // Decrement the total number of accounts
//     }

//     public static void printAccountDetailsAndSummary(ArrayList<BankAccount> accounts) {
//         System.out.println("AcctNo  Init Balance  New Balance");
//         System.out.println("------  ------------  -----------");

//         int overdrawnAccounts = 0;

//         for (BankAccount account : accounts) {
//             double newBalance = account.getBalance();
//             String overdrawnMarker = newBalance < 0 ? " <== OVERDRAWN" : "";
//             if (newBalance < 0) {
//                 overdrawnAccounts++;
//             }
//             // Assume initial balance is zero if not specified
//             System.out.printf("%04d    $ %10.2f   $ %10.2f%s\n", account.getAcctNo(), InitialBalance, newBalance, overdrawnMarker);
//         }

//         int accountsInGoodStanding = accounts.size() - overdrawnAccounts;

//         System.out.println("\nNumber of accounts: " + accounts.size());
//         System.out.println("Number of accounts in good standing: " + accountsInGoodStanding);
//         System.out.println("Number of overdrawn accounts: " + overdrawnAccounts);
//     }
// }
