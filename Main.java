import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAccount = null;
        CreditCard creditCard = null;

        try {
            System.out.print("Ingrese el saldo inicial de la cuenta de banco: ");
            double initialBalance = scanner.nextDouble();
            bankAccount = new BankAccount(initialBalance);

            System.out.print("Ingrese el saldo inicial de la tarjeta de crédito: ");
            double creditInitialBalance = scanner.nextDouble();
            System.out.print("Ingrese el límite de crédito: ");
            double creditLimit = scanner.nextDouble();
            creditCard = new CreditCard(creditInitialBalance, creditLimit);

            boolean exit = false;

            while (!exit) {
                System.out.println("\nMenú:");
                System.out.println("1. Depositar en cuenta bancaria");
                System.out.println("2. Retirar de cuenta bancaria");
                System.out.println("3. Retirar de tarjeta de credito");
                System.out.println("4. Consultar saldo de cuenta bancaria");
                System.out.println("5. Consultar saldo de tarjeta de credito");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opcion: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Ingrese el monto a depositar: ");
                        double depositAmount = scanner.nextDouble();
                        try {
                            bankAccount.deposit(depositAmount);
                            System.out.println("Deposito exitoso.");
                        } catch (NoNegativeOperationException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.print("Ingrese el monto a retirar: ");
                        double withdrawAmount = scanner.nextDouble();
                        try {
                            bankAccount.withdraw(withdrawAmount);
                            System.out.println("Retiro exitoso.");
                        } catch (NoNegativeOperationException | InsufficientFoundsException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el monto a retirar de la tarjeta de credito: ");
                        double creditWithdrawAmount = scanner.nextDouble();
                        try {
                            creditCard.withdraw(creditWithdrawAmount);
                            System.out.println("Retiro de tarjeta de credito exitoso.");
                        } catch (NoNegativeOperationException | InsufficientFoundsException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.println("Saldo actual de la cuenta bancaria: " + bankAccount.checkCurrentBalance());
                        break;

                    case 5:
                        System.out.println("Saldo actual de la tarjeta de credito: " + creditCard.checkCurrentBalance());
                        break;

                    case 6:
                        exit = true;
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opcion no valida. Intente nuevamente.");
                        break;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}