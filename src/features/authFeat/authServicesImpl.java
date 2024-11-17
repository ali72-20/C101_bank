package features.authFeat;

import com.sun.tools.javac.Main;
import core.ValidatorManager;
import core.dataBase.DataBaseAccess;
import core.dataBase.DataBaseServicesImpl;
import features.authFeat.models.UserModel;

public class authServicesImpl implements authServices{
    @Override
    public void login() {

    }

    @Override
    public void register(UserModel userModel) {
        ValidatorManager.isValidEmail(userModel.getEmail());
        ValidatorManager.isValidUserName(userModel.getUserName());
        ValidatorManager.isValidPassword(userModel.getPassword());
        DataBaseAccess.dataBaseServices.addUser(userModel);
    }

    @Override
    public void logout() {

    }
}
