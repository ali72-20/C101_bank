import core.ServerDialogs;
import core.dataBase.DataBaseServicesImpl;
import core.messages.ServerOutMessages;
import features.authFeat.models.UserModel;

import java.util.Scanner;

public class Main {
     static void login(){

     }
    static void register(){
        UserModel userModel;
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