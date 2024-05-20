import java.util.ArrayList;

public class CreditCard extends BankAccount{


    private final double creditLimit;

    public CreditCard(double initialBalance, double creditLimit) {
        super(initialBalance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdraw(double amount) {
        double availableBalance = checkCurrentBalance() + creditLimit;
        if (availableBalance >= amount) {
            getTransactions().add(new Transaction(amount));
        } else {
            System.out.println("Limite de credito excedido");
        }
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}