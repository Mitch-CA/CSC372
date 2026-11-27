public class BankAccountTest {
    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount(1.5);

        account.setFirstName("Mitchell");
        account.setLastName("Duran");
        account.setAccountID(1001);

        System.out.println("TEST 1: New account");
        account.displayAccount();

        System.out.println("\nTEST 2: Deposit $200");
        account.deposit(200.0);
        account.displayAccount();

        System.out.println("\nTEST 3: Withdraw $50");
        account.processWithdrawal(50.0);
        account.displayAccount();

        System.out.println("\nTEST 4: Withdraw remaining $150");
        account.processWithdrawal(150.0);
        account.displayAccount();

        System.out.println("\nTEST 5: Overdraft withdrawal of $20");
        account.processWithdrawal(20.0);
        account.displayAccount();
    }
}