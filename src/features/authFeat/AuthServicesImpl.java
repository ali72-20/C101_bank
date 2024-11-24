package features.authFeat;

import core.ValidatorManager;
import core.dataBase.DataBaseAccess;
import core.messages.ServerOutMessages;
import features.authFeat.models.LoginRequestLogin;
import features.authFeat.models.ResetPasswordRequest;
import features.authFeat.models.UserModel;

public class AuthServicesImpl implements authServices {
    @Override
    public boolean login(LoginRequestLogin loginRequestLogin) {
        if (!ValidatorManager.isEmailWithPassword(loginRequestLogin)) {
            return false;
        }
        return true;
    }

    @Override
    public void register(UserModel userModel, String passwordConfirm) {
        if (!ValidatorManager.isValidUserName(userModel.getUserName())) {

            return;
        }
        if (!ValidatorManager.isValidEmail(userModel.getEmail())) {
            return;
        }
        if (!ValidatorManager.isValidPassword(userModel.getPassword(), passwordConfirm)) {
            return;
        }
        DataBaseAccess.dataBaseServices.addUser(userModel);
        ServerOutMessages.outRegisteredSuccess();
    }

    @Override
    public boolean forgetPassword(String email) {
        if (!ValidatorManager.isExistedInDataBase(email)) {
            System.out.println("Incorrect email");
            return false;
        }
        return true;
    }

    @Override
    public boolean resetPassword(ResetPasswordRequest resetPasswordRequest) {
        if (ValidatorManager.isValidPassword(resetPasswordRequest.getPassword(), resetPasswordRequest.getPassword())) {
            return DataBaseAccess.dataBaseServices.resetPassword(resetPasswordRequest);
        }
        return false;
    }

    @Override
    public void logout(String email, String password) {


    }
}
