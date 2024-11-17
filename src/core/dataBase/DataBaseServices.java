package core.dataBase;

import features.authFeat.models.UserModel;

public interface DataBaseServices {
    void addUser(UserModel userModel);
    void deleteUser();
    boolean findUser(String email);

}
