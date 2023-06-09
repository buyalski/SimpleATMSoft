package classes;

import java.util.Locale;
import java.util.Scanner;

import static classes.DataBase.DataBase.*;

public class AccountFunctions {
    public static void withdraw(Account account) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to withdraw in " + account.getCurrency());
        double amount = 0.0;
        try {
            System.out.print("Enter the amount: ");
            amount = sc.useLocale(Locale.US).nextDouble();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid value");
            sc.nextLine();
        }
        account.withdraw(amount);
        setBalance(account.getAccountName(), account.getAccountBalance());
    }

    public static void changePin(Account account) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter old PIN-code:");
        String oldPin = sc.next();
        while (!oldPin.equals(account.getPinCode())) {
            System.out.println("Enter old PIN-code:");
            oldPin = sc.next();
        }
        System.out.println("Enter new PIN-code:");
        String newPin = sc.next();
        account.setPinCode(newPin);
        changePinFromDb(account.getAccountName(), newPin);
        System.out.println("Your new PIN-code: " + account.getPinCode());
    }

    public static void topUp(Account account) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to top up in " + account.getCurrency());
        double amount = 0.0;
        while (amount <= 0) {
            try {
                System.out.print("Enter the amount: ");
                amount = sc.useLocale(Locale.US).nextDouble();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid value");
                sc.nextLine();
            }
        }
        account.addAccountBalance(amount);
        setBalance(account.getAccountName(), account.getAccountBalance());
    }

    public static void showBalance(Account account) {
        System.out.println("Your account balance: " + getBalance(account.getAccountName()) + " " + getCurrency(account.getAccountName()));
    }
}
