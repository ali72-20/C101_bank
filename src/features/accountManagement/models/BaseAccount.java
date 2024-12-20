package features.accountManagement.models;

public class BaseAccount {
    private static int genId = 0;
    private static int genAccountNumber = 100;
    private  String id;
    private double balance;
    private String accountType;
    private String accountNumber;
    private String accountHolderName;

    public BaseAccount( double balance, String accountType ,String accountHolderName) {

        this.balance = balance;
        this.accountType = accountType;
        this.accountHolderName = accountHolderName;
        this.id = (++genId) + "";
        this.accountNumber = (++genAccountNumber) + "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void printInformation(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    boolean checkNegativeAmount(double amount){
        return amount < 0;
   }
    public void deposit(double amount) {
        if(checkNegativeAmount(amount)){
            throw new IllegalArgumentException("Amount can't be negative");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if(checkNegativeAmount(amount)){
            throw new IllegalArgumentException("Amount can't be negative");
        }
        if(amount  > balance){
            throw new IllegalArgumentException("Amount can't be greater than balance");
        }
        balance -= amount;
    }
}
