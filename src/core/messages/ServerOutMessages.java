package core.messages;



public class ServerOutMessages{
    private ServerOutMessages(){}

    public static void outExitServerMessage(){
        System.out.println(ServerMessages.exitServer);
    }

    public static void outOfMenuChoiceError(){
        System.out.println(ServerErrorMessages.outOfMenuChoices);
    }
}