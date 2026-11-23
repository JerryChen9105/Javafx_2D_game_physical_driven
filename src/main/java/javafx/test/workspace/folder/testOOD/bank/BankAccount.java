package javafx.test.workspace.folder.testOOD.bank;

public class BankAccount {

    private int accountNumber;
    private double balance;
    private AccountStatus status;

    public BankAccount(int accountNumber, double balance, AccountStatus status) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.status = status;
    }

    public void withdraw(double amount) throws AccountFrozenException {
        if (status == AccountStatus.FROZEN) throw new AccountFrozenException("bank account is frozen");
    }

}

