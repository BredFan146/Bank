public class CreditCard extends BankAccount {

    private final double creditLimit;

    public CreditCard(double initialBalance, double creditLimit) {
        super(initialBalance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdraw(double amount) throws NoNegativeOperationException, InsufficientFoundsException {
        double availableBalance = checkCurrentBalance() + creditLimit;
        if (amount < 0) {
            throw new NoNegativeOperationException("El monto no puede ser negativo");
        }
        if (availableBalance >= amount) {
            getTransactions().add(new Transaction(-amount));
        } else {
            throw new InsufficientFoundsException("Limite de credito excedido");
        }
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}