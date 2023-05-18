package classes;

import java.util.Scanner;

import static classes.AccountFunctions.*;

public class Menu {
    public static void showMenu(Account account){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println(
                    "1) Check account balance\n" +
                            "2) Top up your account\n" +
                            "3) Withdraw money\n" +
                            "4) Change PIN-code");
            choice = sc.nextInt();
            switch (choice){
                case 1:{
                    showBalance(account);
                    showMenu(account);
                    break;
                }
                case 2:{
                    topUp(account);
                    showMenu(account);
                    break;
                }
                case 3:{
                    withdraw(account);
                    showMenu(account);
                    break;
                }
                case 4:{
                    changePin(account);
                    showMenu(account);
                    break;
                }
                default:{
                    System.out.println("Invalid value");
                    showMenu(account);
                    break;
                }
            }
        }
    }
}
