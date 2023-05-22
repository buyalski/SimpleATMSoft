package classes;

import java.util.Scanner;

import static classes.DataBase.DataBase.*;
import static classes.Menu.showMenu;

public class StartATM {
    public static void startATM() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        Account account = new Account();
        while (flag) {
            System.out.println("1) Login\n2) Register");
            int choise = sc.nextInt();
            switch (choise) {
                case 1: {
                    System.out.println("Hi! Enter your name: ");
                    String name = sc.next();
                    if(checkUser(name)){
                        System.out.println(name + ", enter your PIN-Code:");
                        String tempPin = sc.next();
                        if (!checkPin(name, tempPin)) {
                            System.out.println("Invalid password");
                            startATM();
                        }
                        account.setAccountName(name);
                        account.setAccountBalance(getBalanceFromDb(name));
                        showMenu(account);
                    }
                    else{
                        System.out.println("Sorry, your name not found.");
                        startATM();
                    }
                    break;
                }
                case 2: {
                    System.out.print("Hi! Enter your name: ");
                    String name = sc.next();
                    System.out.println(name + ", enter your PIN-Code: ");
                    String pin = sc.next();
                    System.out.println(name + ", enter your currency\n1)USD\n2)BYN\n3)EUR\n4)AED");
                    Currency currency = null;
                    int cu = sc.nextInt();
                    switch (cu){
                        case 1:{
                            currency = Currency.USD;
                            break;
                        }
                        case 2:{
                            currency = Currency.BYN;
                            break;
                        }
                        case 3:{
                            currency = Currency.EUR;
                            break;
                        }
                        case 4:{
                            currency = Currency.AED;
                            break;
                        }
                        default:{
                            System.out.println("Invalid choise!");
                            startATM();
                        }
                    }
                    registration(name, 0, currency, pin);
                    showMenu(account);
                    break;
                }
            }
        }
    }
}
