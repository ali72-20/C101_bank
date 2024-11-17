package features.authFeat;

import features.authFeat.models.UserModel;

public interface authServices {
    void login();
    void register(UserModel userModel);
    void logout();
}
