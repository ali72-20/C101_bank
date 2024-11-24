package features.authFeat;

import core.ValidatorManager;
import core.dataBase.DataBaseAccess;
import features.authFeat.models.UserModel;

public class AuthServicesImpl implements authServices{
    @Override
    public void login() {

    }

    @Override
    public void register(UserModel userModel,String passwordConfirm) {
       if(!ValidatorManager.isValidUserName(userModel.getUserName())){
           return;
       }
       if(!ValidatorManager.isValidEmail(userModel.getEmail())){
           return;
       }
       if(!ValidatorManager.isValidPassword(userModel.getPassword(), passwordConfirm)){
           return;
       }
       DataBaseAccess.dataBaseServices.addUser(userModel);
    }

    @Override
    public void logout() {

    }
}
