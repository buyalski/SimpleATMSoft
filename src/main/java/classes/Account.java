package classes;

public class Account {
    private String accountName;
    private double accountBalance;
    private String currency;
    private String pinCode;

    public Account() {
        accountName = "Test";
        accountBalance = 0;
        currency = "USD";
        pinCode = "1111";
    }

    public Account(String accountName, double accountBalance, String currency, String pinCode) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.currency = currency;
        this.pinCode = pinCode;
    }

    public void withdraw(double amount) {
        if (accountBalance >= amount) {
            accountBalance -= amount;
        } else {
            System.out.println("You will withdraw " + amount + " " + currency + ", but you have " + accountBalance + " " + currency);
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
