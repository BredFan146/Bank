import java.util.ArrayList;

public class BankAccount {

    private final double initialBalance;
    private final ArrayList<Transaction> transactions;
    private final ArrayList<Transaction> oldTransactions;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.initialBalance = initialBalance;
        this.transactions = new ArrayList<>();
        this.oldTransactions = new ArrayList<>();
    }

    public void deposit(double amount) throws NoNegativeOperationException {
        if (amount < 0) {
            throw new NoNegativeOperationException("El monto no puede ser negativo");
        }
        transactions.add(new Transaction(amount));
    }

    public void withdraw(double amount) throws NoNegativeOperationException, InsufficientFoundsException {
        if (amount < 0) {
            throw new NoNegativeOperationException("El monto no puede ser negativo");
        }
        if (amount > checkCurrentBalance()) {
            throw new InsufficientFoundsException("Saldo insuficiente");
        }
        transactions.add(new Transaction(-amount));
    }

    public double checkCurrentBalance() {
        double currentBalance = initialBalance;
        for (Transaction transaction : transactions) {
            currentBalance += transaction.getAmount();
        }
        return currentBalance;
    }

    public void endPeriod() {
        oldTransactions.addAll(transactions);
        transactions.clear();
    }

    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public ArrayList<Transaction> getOldTransactions() {
        return new ArrayList<>(oldTransactions);
    }
}