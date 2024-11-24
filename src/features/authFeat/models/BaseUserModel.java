package features.authFeat.models;
class BaseUserModel {
    private String email;
    private String password;

    public BaseUserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
