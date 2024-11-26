package features.accountManagement.models;

public class SavedBankAccount extends BaseAccount{

    public SavedBankAccount( double balance, String accountType, String accountHolderName) {
        super(balance, accountType, accountHolderName);
    }


    @Override
    public void withdraw(double amount) {
        if (checkNegativeAmount(amount)) {
            throw new IllegalArgumentException("Amount can't be negative");
        }
        if (amount > getBalance()) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        if(amount < 1000){
            throw new IllegalArgumentException("Minimum withdrawal amount should be 1000");
        }
        System.out.println("Successfully withdrawn: " + amount);
        setBalance(getBalance() - amount);
    }
}
