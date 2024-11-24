package features.authFeat;

import features.authFeat.models.LoginRequestLogin;
import features.authFeat.models.ResetPasswordRequest;
import features.authFeat.models.UserModel;

public interface authServices {
    boolean login(LoginRequestLogin loginRequestLogin);
    void register(UserModel userModel,String passwordConfirm);
    boolean forgetPassword(String email);
    boolean resetPassword(ResetPasswordRequest resetPasswordRequest);
    void logout(String email, String password);
}
