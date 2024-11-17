package core;

import core.dataBase.DataBaseAccess;
import core.messages.ServerOutMessages;

public class ValidatorManager {
    private ValidatorManager(){}

    private static boolean isValidateEmailRegex(String email){
        return ServerRegex.isValidEmailRegex(email);
    }
    private static boolean isInDataBase(String email){
         return DataBaseAccess.dataBaseServices.findUser(email);
    }
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
}
