import java.util.*;


class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     balance += amount;
 }

 public boolean withdraw(double amount) {
     if (amount <= balance) {
         balance -= amount;
         return true;
     } else {
         return false;
     }
 }
}


class ATM {
 private BankAccount bankAccount;

 public ATM(BankAccount bankAccount) {
     this.bankAccount = bankAccount;
 }

 public void displayMenu() {
     System.out.println("Welcome to the ATM!");
     System.out.println("1. Check Balance");
     System.out.println("2. Deposit");
     System.out.println("3. Withdraw");
     System.out.println("4. Exit");
 }

 public void Transaction(int option) {
     Scanner sc = new Scanner(System.in);
     switch (option) {
         case 1:
             System.out.println("Current Balance: " + bankAccount.getBalance());
             break;
         case 2:
             System.out.print("Enter deposit amount: ");
             double depositAmount = sc.nextDouble();
             bankAccount.deposit(depositAmount);
             System.out.println("Deposit successful. Current Balance: " + bankAccount.getBalance());
             break;
         case 3:
             System.out.print("Enter withdrawal amount: ");
             double withdrawalAmount = sc.nextDouble();
             if (bankAccount.withdraw(withdrawalAmount)) {
                 System.out.println("Withdrawal successful. Current Balance: " + bankAccount.getBalance());
             } else {
                 System.out.println("Insufficient funds. Unable to withdraw.");
             }
             break;
         case 4:
             System.out.println("Thank you for using the ATM. Goodbye!");
             System.exit(0);
         default:
             System.out.println("Invalid option. Please try again.");
     }
 }
}

public class AtmMachine{
 public static void main(String[] args) {
     BankAccount account = new BankAccount(1000);
     ATM atm = new ATM(account);
     try (Scanner scanner = new Scanner(System.in)) {
         while (true) {
             atm.displayMenu();
             System.out.print("Enter your choice: ");
             int choice = scanner.nextInt();
             atm.Transaction(choice);
         }
     }
 }
}
