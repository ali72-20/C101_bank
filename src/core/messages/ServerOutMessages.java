package core.messages;



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
}