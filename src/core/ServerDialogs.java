package core;

public class ServerDialogs {
    private ServerDialogs(){};

    /**
     * This is server start dialog
     *
     */
    public static void startDialog(){
         System.out.println("1- Login");
         System.out.println("2- Register");
         System.out.println("3- Forget password");
         System.out.println("4- Exit");
    }
    public static void loginSuccessDialog(){
        System.out.println("1- Have an account");
        System.out.println("2- New user");
        System.out.println("3- Exit");
    }
}
