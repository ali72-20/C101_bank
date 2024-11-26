package features.accountManagement.models;

public class PrePaidAccount extends BaseAccount{

    public PrePaidAccount(String id, double balance, String accountType, String accountNumber, String accountHolderName) {
        super(id, balance, accountType, accountNumber, accountHolderName);
    }

    @Override
    public void withdraw(double amount) {
        if(checkNegativeAmount(amount)){
            throw new IllegalArgumentException("Amount can't be negative");
        }
        if(amount > getBalance()) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        if(getBalance() - amount < 1000){
            throw new IllegalArgumentException("Minimum balance should be 1000");
        }
        System.out.println("Successfully withdrawn: " + amount);
        setBalance(getBalance() - amount);
    }

}
