package classes.exceptions;

public class AmountExeption extends Exception {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public AmountExeption() {
    }

    public AmountExeption(String message, double amount) {
        super(message);
        this.amount = amount;
    }
}
