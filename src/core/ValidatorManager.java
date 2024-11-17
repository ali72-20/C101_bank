package core;

import core.dataBase.DataBaseAccess;
import core.messages.ServerOutMessages;

public class ValidatorManager {
    private ValidatorManager(){}

    private static boolean isValidateEmailRegex(String email){
        return ServerRegex.isValidEmailRegex(email);
    }
    private static boolean isInDataBase(String email){
         return DataBaseAccess.dataBaseServices.findUserByEmail(email);
    }


    /**
     * valid email according to
     * 1- Email regex
     * 2- Is in database or not
     * @param email
     * @return
     */
   public static boolean isValidEmail(String email){
        if(!isValidateEmailRegex(email)){
            ServerOutMessages.outInValidRegex();
            return false;
        }
        if(!isInDataBase(email)){
            ServerOutMessages.outUserExistInDataBase();
            return false;
        }
        ServerOutMessages.outEmailIsValid();
        return true;
    }

    /**
     * validate is user_name is already exist or not
     * @param userName
     * @return true or false
     */
    public static boolean isValidUserName(String userName){
        return DataBaseAccess.dataBaseServices.findUserByUserName(userName);
    }


    private static boolean isPasswordMatch(String password,String confirmationPassword){
        return password.equals(confirmationPassword);
    }
    private static boolean isValidPasswordLength(String password){
        return password.length() >= 6;
    }

    /**
     * validate on password:
     * 1- password match confirm password
     * 2- password length must be 6
     * 3- password fit in regex
     * @param password
     * @param confirmationPassword
     * @return password is valid or not
     */
    public static boolean isValidPassword(String password,String confirmationPassword){
        if(!isPasswordMatch(password,confirmationPassword)){
            ServerOutMessages.outPasswordNotMatchConfirmPassword();
            return false;
        }
        if(!isValidPasswordLength(password)){
            ServerOutMessages.outPasswordLengthNotValid();
            return false;
        }
        if(!ServerRegex.isValidPasswordRegex(password)){
            ServerOutMessages.outPasswordViolateRegex();
            return false;
        }
        return true;
    }
}
