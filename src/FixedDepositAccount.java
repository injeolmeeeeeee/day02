package src;

public class FixedDepositAccount extends BankAccount{
    private boolean interestCharged;
    private int months;
    private float interest;

    public FixedDepositAccount(String name, float initialBalance) {
        super(name, initialBalance);
        this.interest= 3.0f;
        this.months=6;
        this.interestCharged=false;
    }

    public FixedDepositAccount(String name, float initialBalance, float interest) {
        super(name, initialBalance);
        this.interest=interest;
        this.interestCharged=true;
    }
    public FixedDepositAccount(String name, float initialBalance, float interest, int months) {
        this(name, initialBalance, interest);
        this.months=months;
        this.interestCharged=true;
    }

    @Override
    public void deposit(float input) {}

    @Override
    public void withdraw(float input) {}

    @Override
    public float getBalance() {
        return super.getBalance() + (interestCharged ? interest : 0);}

}
