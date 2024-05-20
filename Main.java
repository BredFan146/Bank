import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {


            BankAccount bankAccount = new BankAccount( 1000);
            CreditCard creditCard=new CreditCard(0,1000);
            System.out.println("Saldo inicial de la cuenta de Banco: " + bankAccount.checkCurrentBalance());
            bankAccount.deposit(-10);
            bankAccount.withdraw(1100);


              double currentBalance = bankAccount.checkCurrentBalance();
//            double creditLimit = creditAccount.getCreditLimit();

            System.out.println("Saldo actual: " + currentBalance);
//            System.out.println("Limite de credito: " + creditLimit);
        }
        catch (IllegalArgumentException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}