package core.dataBase;

import features.authFeat.models.LoginRequestLogin;
import features.authFeat.models.ResetPasswordRequest;
import features.authFeat.models.UserModel;

import java.util.ArrayList;

public class DataBaseServicesImpl implements DataBaseServices {

    private final ArrayList<UserModel> users = new ArrayList<>();

    @Override
    public  void addUser(UserModel userModel) {
        users.add(userModel);
    }

    @Override
    public  void deleteUser() {

    }

    @Override
    public boolean findUserByEmail(String email) {
        for(int i=0; i < users.size(); ++i){
            if(users.get(i).getEmail().equals(email)) return true;
        }
        return false;
    }

    @Override
    public boolean findUserByUserName(String userName) {
        for(int i = 0; i < users.size(); ++i){
            if(users.get(i).getUserName().equals(userName)) return true;
        }
        return false;
    }

    @Override
    public boolean isEmailWithPassword(LoginRequestLogin loginRequestLogin) {
        for(int i = 0;i < users.size(); ++i){
            if(users.get(i).getEmail().equals(loginRequestLogin.getEmail()) && users.get(i).getPassword().equals(loginRequestLogin.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean resetPassword(ResetPasswordRequest resetPasswordRequest) {
        for(int i = 0;i < users.size(); ++i){
            if(users.get(i).getEmail().equals(resetPasswordRequest.getEmail())){
                users.get(i).setPassword(resetPasswordRequest.getPassword());
                return true;
            }
        }
        return false;
    }

    @Override
    public UserModel getUserByEmail(String email) {
        for(int i = 0; i < users.size(); ++i){
            if(users.get(i).getEmail().equals(email)){
                return users.get(i);
            }
        }
        return null;
    }
}
