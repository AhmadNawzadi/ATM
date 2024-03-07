import java.text.DecimalFormat;
import java.util.*;

public class OptionMenu {

    Scanner scanner = new Scanner(System.in);
    DecimalFormat format = new DecimalFormat("###,###.00");
    Map<Long, Account> accounts = new HashMap<>();
    private boolean flag;

    public void displayMainMenu() {
        boolean flag = false;
        Account myAccount = new Account("Ahmad", "Nawzadi", 123);
        accounts.put(myAccount.getAccountNumber(), myAccount);

        while(!flag){
            try {
                System.out.println("\nType 1 - Login");
                System.out.println("Type 2 - Create Account");
                System.out.print("\nChoice : " );

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        login();
                        flag = true;
                    }
                    case 2 -> {
                        createAccount();
                        flag = true;
                    }
                    default -> {
                    }
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid input.");
            }
        }
    }

    public void login() {
        boolean flag = false;

        while(!flag) {
            try {
                System.out.println("\n---------LOGIN PAGE-----------" );
                System.out.print("Enter your name : " );
                String name = scanner.next().toLowerCase();
                String nameCap = name.substring(0,1).toUpperCase() + name.substring(1);
                System.out.print("Enter your pin code : " );
                int pinCode = scanner.nextInt();

                Iterator it = accounts.entrySet().iterator();
                if(it.hasNext()){
                    Map.Entry pair = (Map.Entry) it.next();
                    Account account = (Account) pair.getValue();
                    if(((Account) pair.getValue()).getName().equals(nameCap) && (account.getAccountPin() == pinCode)){
                        selectAccount(account);
                        flag = true;
                        break;
                    }
                    else{
                        System.out.println("\nAccount number or pin invalid.");
                        displayMainMenu();
                    }
                }
            }
            catch (InputMismatchException e){
                System.out.println("\nAccount number or pin invalid.");
                scanner.next();
            }
        }
    }

    public void createAccount() {
        System.out.println("\n--------- CREATE ACCOUNT PAGE-----------" );
        System.out.print("Enter your name : ");
        String name = scanner.next().toLowerCase();;
        String nameCap = name.substring(0,1).toUpperCase() + name.substring(1);
        System.out.print("Enter your surname : ");
        String surname = scanner.next().toLowerCase();
        String surnameCap = surname.substring(0,1).toUpperCase() + surname.substring(1);
        System.out.print("Enter your pin code : ");
        int pin = scanner.nextInt();

        Account account = new Account(nameCap, surnameCap, pin);
        accounts.put(account.getAccountNumber(), account);
        System.out.println("\nYour accounts has been created successfully.");
        System.out.println("Redirecting to login page........");
        login();
    }

    public void selectAccount(Account account){
        boolean flag = false;

        while(!flag) {
            try {
                System.out.println("\nSelect the account you want to access : ");
                System.out.println("Type 1 : Current Account");
                System.out.println("Type 2 : Saving Account");
                System.out.println("Type 3 : Exit");

                System.out.print("\nChoice : ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        getCurrentAccountOps(account);
                    }
                    case 2 -> {
                        getSavingAccountOps(account);
                    }
                    case 3 -> {
                        System.out.println("Thank you for using this ATM.");
                        flag = true;
                    }
                    default -> {
                    }
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid choice.");
                scanner.next();
            }
        }
    }

    public void getCurrentAccountOps(Account account){
        boolean flag = false;

        while (!flag){
            try {
                System.out.println("\nCurrent Account : ");
                System.out.println(" Type 1 : View Balance");
                System.out.println(" Type 2 : Withdraw Fund");
                System.out.println(" Type 3 : Deposit Fund");
                System.out.println(" Type 4 : Transfer Fund");
                System.out.println(" Type 5 : Exit");

                System.out.print("\nChoice : ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> account.getCurrentAccountBalance();
                    case 2 -> account.withdrawFromCurrentAccount();
                    case 3 -> account.depositToCurrentAccount();
                    case 4 -> account.transferFund("current");
                    case 5 -> flag = true;
                }
            }
            catch (InputMismatchException e){
                System.out.println("\nInvalid choice.");
                scanner.next();
            }
        }
    }

    public void getSavingAccountOps(Account account){
        boolean flag = false;

        while (!flag) {
            try {
                System.out.println("\nSavings Account : ");
                System.out.println(" Type 1 : View Balance");
                System.out.println(" Type 2 : Withdraw Fund");
                System.out.println(" Type 3 : Deposit Fund");
                System.out.println(" Type 4 : Transfer Fund");
                System.out.println(" Type 5 : Exit");

                System.out.print("\nChoice : ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> account.getSavingAccountBalance();
                    case 2 -> account.withdrawFromSavingAccount();
                    case 3 -> account.depositToSavingAccount();
                    case 4 -> account.transferFund("saving");
                    case 5 -> flag = true;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid choice.");
                scanner.next();
            }
        }
    }

    public void displayAllAccounts(){
        System.out.println("DISPLAY ACCOUNTS ");
        for(Map.Entry<Long, Account> entry : accounts.entrySet()){
            System.out.println("Account number = "+ entry.getKey() +" "+ entry.getValue());
        }
    }

    public void removeAllAccount(String name){
        Iterator it = accounts.entrySet().iterator();
        while(it.hasNext()){
            it.remove();
        }
    }

    @Override
    public String toString() {
        return "OptionMenu{" +
                "scanner=" + scanner +
                ", format=" + format +
                ", accounts=" + accounts +
                '}';
    }
}
