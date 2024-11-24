package core.messages;


import javax.print.attribute.standard.Severity;

public class ServerOutMessages{
    private ServerOutMessages(){}

    public static void outExitServerMessage(){
        System.out.println(ServerMessages.exitServer);
    }

    public static void outOfMenuChoiceError(){
        System.out.println(ServerErrorMessages.outOfMenuChoices);
    }

    public static void outUserExistInDataBase() {
        System.out.println(ServerErrorMessages.existInDataBase);
    }

    public static void outInValidRegex(){
        System.out.println(ServerErrorMessages.notValidInRegex);
    }
    public static void outEmailIsValid(){
        System.out.println(ServerMessages.validEmail);
    }

    public static void outPasswordLengthNotValid(){
        System.out.println(ServerErrorMessages.passwordInValidLength);
    }
    public static void outPasswordNotMatchConfirmPassword(){
        System.out.println(ServerErrorMessages.passwordNotMatch);
    }
    public static void outPasswordViolateRegex(){
        System.out.println(ServerErrorMessages.passwordViolateRegex);
    }

    public static void outEnterUserName(){
        System.out.println(ServerMessages.enterUserName);
    }
    public static void outEnterEmail(){
        System.out.println(ServerMessages.enterEmail);
    }
    public static void outEnterPassword(){
        System.out.println(ServerMessages.enterPassword);
    }
    public static void outEnterConfirmPassword(){
        System.out.println(ServerMessages.enterConfirmPassword);
    }
    public static void outEnterPhoneNumber(){
        System.out.println(ServerMessages.enterPhoneNumber);
    }
    public static void outRegisteredSuccess(){
        System.out.println(ServerMessages.registeredSuccess);
    }
}