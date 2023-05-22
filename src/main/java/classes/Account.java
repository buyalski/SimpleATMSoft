package classes;

import static classes.DataBase.DataBase.query;
import static classes.DataBase.DataBase.setBalance;

public class Account {
    private String accountName;
    private double accountBalance;
    private Currency currency;
    private String pinCode;

    public Account() {
        accountName = "test";
        accountBalance = 0;
        currency = Currency.USD;
        pinCode = "1111";
    }

    public Account(String accountName, double accountBalance, Currency currency, String pinCode) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.currency = currency;
        this.pinCode = pinCode;
    }

    public void withdraw(double amount) {
        if (accountBalance >= amount) {
            double newBalance = accountBalance -= amount;
            setBalance(accountName, newBalance);
        } else {
            System.out.println("You will withdraw " + amount + " " + currency + ", but you have " + accountBalance + " " + currency + ", please retry");
        }
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void addAccountBalance(double add) {
        accountBalance += add;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
