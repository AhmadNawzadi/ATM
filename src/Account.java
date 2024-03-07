import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {

    private String name;
    private String surName;
    public static long accountNumber = 1234567890;
    private int accountPin;
    private double currentAccount = 0.0;
    private double savingAccount = 0.0;

    Scanner scanner = new Scanner(System.in);

    public Account(){

    }
    public Account(String name, String lastName, int accountPin) {
        this.name = name;
        this.surName = surName;
        this.accountPin = accountPin;
        accountNumber++;
    }

    public Account(long accountNumber, int accountPin, double currentAccount, double savingAccount) {
        this.accountPin = accountPin;
        this.currentAccount = currentAccount;
        this.savingAccount = savingAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return surName;
    }

    public void setLastName(String lastName) {
        this.surName = lastName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }

    public void getCurrentAccountBalance() {
        System.out.println("Current account balance is : " + currentAccount);
    }

    public void getSavingAccountBalance() {
        System.out.println("Saving account balance is : " + savingAccount);;
    }

    public void depositToCurrentAccount(){
        System.out.print("Enter the amount to deposit : ");
        boolean flag = true;

        while (flag) {
            try {
                double amount = scanner.nextDouble();
                if(amount < 0){
                    System.out.println("Negative amount not allowed.");
                }
                else {
                    currentAccount += amount;
                    System.out.println("Your account balance is : " + currentAccount);
                    flag = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }
    }

    public void withdrawFromCurrentAccount() {
        System.out.print("Enter the amount to withdraw : ");
        boolean flag = true;

        while (flag) {
            try {
                double amount = scanner.nextDouble();
                if (amount > currentAccount) {
                    System.out.println("Not enough fund in your current account.");
                } else {
                    currentAccount -= amount;
                    System.out.println("Your account balance is : " + currentAccount);
                    flag = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }
    }

    public void depositToSavingAccount(){
        System.out.print("Enter the amount to deposit : ");
        boolean flag = true;

        while(flag){
            try {
                double amount = scanner.nextDouble();
                if(amount < 0){
                    System.out.println("Negative amount not allowed.");
                }
                else {
                    savingAccount += amount;
                    System.out.println("Your account balance is : " + savingAccount);
                    flag = false;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }
    }

    public void withdrawFromSavingAccount() {
        System.out.print("Enter the amount to withdraw : ");

        boolean flag = true;

        while (flag) {
            try {
                double amount = scanner.nextDouble();
                if (amount > savingAccount) {
                    System.out.println("Not enough fund in your saving account.");
                } else {
                    savingAccount -= amount;
                    System.out.println("Your account balance is : " + savingAccount);
                    flag = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }
    }

    public void transferFund(String accountType){
        System.out.println("\nSelect an account your wish to transfer fund to : ");
        boolean flag = true;

        while(flag) {
            try {
                if(accountType.equals("current")){
                    System.out.println("1 : Saving");
                    System.out.print("2 : Exit");

                    System.out.print("\nChoice : ");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> depositToSavingAccount();
                        case 2 -> flag = false;
                        default -> {}
                    }
                }
                else if(accountType.equals("saving")){
                    System.out.println("1 : Current");
                    System.out.println("2 : Exit");

                    System.out.print("\nChoice : ");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> depositToCurrentAccount();
                        case 2 -> flag = false;
                        default -> {}
                    }
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", lastName='" + surName + '\'' +
                ", accountPin=" + accountPin +
                ", currentAccount=" + currentAccount +
                ", savingAccount=" + savingAccount +
                '}';
    }
}
