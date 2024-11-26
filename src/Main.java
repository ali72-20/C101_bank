import core.ServerDialogs;
import core.dataBase.DataBaseAccess;
import core.messages.ServerOutMessages;
import features.accountManagement.models.BaseAccount;
import features.accountManagement.models.CurrentLoggedUser;
import features.accountManagement.models.PrePaidAccount;
import features.accountManagement.models.SavedBankAccount;
import features.authFeat.AuthServicesImpl;
import features.authFeat.models.LoginRequestLogin;
import features.authFeat.models.ResetPasswordRequest;
import features.authFeat.models.UserModel;
import java.util.Scanner;

public class Main {

    static void haveAccount(){
        Scanner scanner = new Scanner(System.in);
        UserModel user = DataBaseAccess.dataBaseServices.getUserByEmail(CurrentLoggedUser.email);
        if(user.getAccount() == null){
            throw new NullPointerException("Account is null");
        }
        while(true) {
            ServerDialogs.backServicesDialog();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Your balance is: " + user.getAccount().getBalance());
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw");
                    double amount = scanner.nextDouble();
                    user.getAccount().withdraw(amount);
                    break;
                case 3:
                    System.out.println("Enter amount to deposit");
                    double depositAmount = scanner.nextDouble();
                    user.getAccount().deposit(depositAmount);
                    break;
                case 4:
                    user.getAccount().printInformation();
                    break;
                case 5:
                    ServerOutMessages.outExitServerMessage();
                    return;
                default:
                    ServerOutMessages.outOfMenuChoiceError();
            }
        }
    }

    static double enterBalance(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter balance");
        return scanner.nextDouble();
    }
    static void createAccount(){
        BaseAccount baseAccount = null;
        Scanner scanner = new Scanner(System.in);
        ServerDialogs.accountTypesDialogs();
        int choice = scanner.nextInt();
        boolean isDone = false;
        while(!isDone) {
            switch (choice) {
                case 1:
                    baseAccount = new BaseAccount(enterBalance(), "base",  CurrentLoggedUser.email);
                    isDone = true;
                    break;
                case 2:
                    baseAccount = new PrePaidAccount( enterBalance(), "PrePaid", CurrentLoggedUser.email);
                    isDone = true;
                    break;
                case 3:
                    baseAccount = new SavedBankAccount(enterBalance(), "Saved ", CurrentLoggedUser.email);
                    isDone = true;
                    break;
                default:
                    ServerOutMessages.outOfMenuChoiceError();
            }
        }
        UserModel userModel = DataBaseAccess.dataBaseServices.getUserByEmail(CurrentLoggedUser.email);
        userModel.setAccount(baseAccount);
    }
    static void loginSuccess(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true){
            ServerDialogs.loginSuccessDialog();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    haveAccount();
                    break;
                case 2:
                    createAccount();
                    break;
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
             CurrentLoggedUser.email = email;
             loginSuccess();
         }
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