package core.dataBase;

import features.authFeat.models.LoginRequestLogin;
import features.authFeat.models.ResetPasswordRequest;
import features.authFeat.models.UserModel;

public interface DataBaseServices {
    void addUser(UserModel userModel);
    void deleteUser();
    boolean findUserByEmail(String email);
    boolean findUserByUserName(String userName);
    boolean isEmailWithPassword(LoginRequestLogin loginRequestLogin);
    boolean resetPassword(ResetPasswordRequest resetPasswordRequest);

}
