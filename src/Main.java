import core.ServerDialogs;
import core.messages.ServerOutMessages;
import features.authFeat.AuthServicesImpl;
import features.authFeat.models.UserModel;

import java.util.Scanner;

public class Main {
     static void login(){

     }
    static void register(){
         Scanner scanner = new Scanner(System.in);

         ServerOutMessages.outEnterUserName();
         String userName = scanner.next();

         ServerOutMessages.outEnterEmail();
         String email = scanner.next();

         ServerOutMessages.outEnterPhoneNumber();
         String phoneNumber = scanner.next();

         ServerOutMessages.outEnterPassword();
         String password = scanner.next();

         ServerOutMessages.outEnterConfirmPassword();
         String confirmPassword = scanner.next();

         UserModel userModel = new UserModel(userName,email,phoneNumber,password);

         new AuthServicesImpl().register(userModel,confirmPassword);
     }

    static void startServer(){
        Scanner scanner = new Scanner(System.in);
        int dialogChoice;
        while(true){
            ServerDialogs.startDialog();
            dialogChoice = scanner.nextInt();
            switch (dialogChoice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    ServerOutMessages.outExitServerMessage();
                    break;
                default:
                    ServerOutMessages.outOfMenuChoiceError();
            }
        }
    }

    public static void main(String[] args) {
        startServer();
    }
}