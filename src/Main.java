import core.ServerDialogs;
import core.messages.ServerOutMessages;
import features.authFeat.AuthServicesImpl;
import features.authFeat.models.LoginRequestLogin;
import features.authFeat.models.ResetPasswordRequest;
import features.authFeat.models.UserModel;

import java.util.Scanner;

public class Main {

    static void loginSuccess(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true){
            ServerDialogs.loginSuccessDialog();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // have an account
                    break;
                case 2:
                    // creat new account
                case 3:
                    ServerOutMessages.outExitServerMessage();
                    return;
                default:
                    ServerOutMessages.outOfMenuChoiceError();
            }
        }
    }
     static void login(){
         Scanner scanner = new Scanner(System.in);

         ServerOutMessages.outEnterEmail();
         String email = scanner.next();

         ServerOutMessages.outEnterPassword();
         String password = scanner.next();
         LoginRequestLogin loginRequestLogin = new LoginRequestLogin(email,password);
         if(new AuthServicesImpl().login(loginRequestLogin)){
             loginSuccess();
         }
         return;
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
     static void forgetPassword(){
         Scanner scanner = new Scanner(System.in);
         ServerOutMessages.outEnterEmail();
         String email = scanner.next();
         if(new AuthServicesImpl().forgetPassword(email)) {
             System.out.println("Enter new Password");
             String password = scanner.next();
             ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest(email,password);
             new AuthServicesImpl().resetPassword(resetPasswordRequest);
         }
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
                    forgetPassword();
                    break;
                case 4:
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