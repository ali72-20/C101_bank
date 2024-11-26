package features.authFeat.models;

import features.accountManagement.models.BaseAccount;

public class UserModel {
    private String userName;
    private String email;
    private String phoneNumber;

    private BaseAccount account;

    // مصيييييبة
    private String password;

    public UserModel(String userName, String email,String phoneNumber, String password){
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BaseAccount getAccount() {
        return account;
    }

    public void setAccount(BaseAccount account) {
        this.account = account;
    }
}
