package features.authFeat.models;

public class ResetPasswordRequest extends BaseUserModel{
    public ResetPasswordRequest(String email, String password) {
        super(email, password);
    }
}
