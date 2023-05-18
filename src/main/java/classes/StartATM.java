package classes;

import java.util.Scanner;

import static classes.Menu.showMenu;

public class StartATM {
    public static void startATM() {
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        String tempPin = "";
        while (!account.getPinCode().equals(tempPin)) {
            System.out.println("Enter your PIN-code:");
            tempPin = sc.nextLine();
        }
        showMenu(account);
    }
}
