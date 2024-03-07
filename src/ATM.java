
public class ATM {

    public static void main(String[] args) {
        OptionMenu menu = new OptionMenu();
        sayWelcome();

        menu.displayMainMenu();
    }

    public static void sayWelcome(){
        System.out.println("Welcome to the ATM");
    }
}