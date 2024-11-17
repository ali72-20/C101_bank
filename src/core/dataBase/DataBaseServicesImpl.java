package core.dataBase;

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
    public boolean findUser(String email) {
        for(int i=0; i < users.size(); ++i){
            if(users.get(i).getEmail().equals(email)) return true;
        }
        return false;
    }
}
