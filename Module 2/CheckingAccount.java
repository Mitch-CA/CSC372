public class CheckingAccount extends BankAccount {
    private double interestRate;

    public CheckingAccount(double interestRate) {
        super();
        this.interestRate = interestRate;
    }

    public void processWithdrawal(double amount) {
        withdrawal(amount);

        if (getBalance() < 0) {
            withdrawal(30.0);
            System.out.println("A $30 overdraft fee has been assessed.");
        }

        System.out.printf("Balance after withdrawal: $%.2f%n",
                getBalance());
    }

    public void displayAccount() {
        accountSummary();
        System.out.printf("Interest rate: %.2f%%%n", interestRate);
    }
}