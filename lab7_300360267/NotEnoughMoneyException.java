public class NotEnoughMoneyException extends IllegalStateException {
    private double amount;
    private double balance;
    private double missingAmount;

    public NotEnoughMoneyException(double amount, double balance, double missingAmount) {
        this.amount = amount;
        this.balance = balance;
        this.missingAmount = missingAmount;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public double getMissingAmount() {
        return missingAmount;
    }

    @Override
    public String getMessage() {
        return "you have not enought money to witdraw " + amount;
    }
}
