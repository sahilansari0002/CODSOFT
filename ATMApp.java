/**
 * Program: Atm Interface.
 * Developer: Sahil Ali
 * Project: Codsoft Internship Task
 * Date Created: September 29, 2023
 *
 */
import java.util.Scanner;

class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
	{
        this.balance = initialBalance;
	}

    public double getBalance() 
	{
        return balance;
   	}

    public void deposit(double amount) 	
	{
        if (amount > 0) 
		{
            balance += amount;
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t Dear Customer, Your AC XXXXX000001 Credited INR RS "+ amount +" \n\t\t\tJust now! Deposit of Cash at  CODSOFT ATM. Available Balance INR Rs " + balance+" -  CODSOFT");
        	} 
		else 
		{
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\tInvalid deposit amount.");
        	}
    	}

    public void withdraw(double amount) 
	{
        if (amount > 0 && amount <= balance) 
		{
            balance -= amount;
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t Dear Customer, Your AC XXXXX000001 has a Debit by transfer of Rs "+amount+"\n\t\t\t-. Available Balance INR Rs: " + balance+" -  CODSOFT");
        	}
		 else if (amount <= 0) 
		{
            System.out.println("\t\t\tInvalid withdrawal amount.");
        	} 
		else 
		{
            System.out.println("\t\t\tInsufficient balance.");
        	}
    }
}

class ATM 
{
    private BankAccount account;

    public ATM(BankAccount account)
	{
        this.account = account;
    	}

    public void checkBalance() 
	{
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\tDear Customer,\n\t\t\t Your AC XXXXX000001 Current balance: " + account.getBalance());
    	}

    public void deposit(double amount) 
	{
        account.deposit(amount);
    	}

    public void withdraw(double amount) 
	{
        account.withdraw(amount);
    	}
}

public class ATMApp 
{
    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        double initialBalance = 1000.0;
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        while (true) 
		{
            System.out.println("\n\t\t\tATM Menu:");
            System.out.println("\t\t\t1. Balance Inquiry");
            System.out.println("\t\t\t2. Deposit");
            System.out.println("\t\t\t3. Withdraw");
            System.out.println("\t\t\t4. Exit");
            System.out.print("\t\t\tWhich ATM service you need now!: ");

            int choice = scanner.nextInt();

            switch (choice) 
	 	  {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("\t\t\tEnter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("\t\t\tEnter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\tThank you for using the ATM. Visit Again to our Branch'CODSOFT'");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\tInvalid Service. Please enter a valid service No.");
                    break;
           }
        }
    }
}
