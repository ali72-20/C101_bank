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

    public static void backServicesDialog(){
        System.out.println("1- check balance");
        System.out.println("2- withdraw");
        System.out.println("3- deposit");
        System.out.println("4- print account details");
        System.out.println("5- Exit");
    }
    public static void accountTypesDialogs(){
        System.out.println("1- base account");
        System.out.println("2- pre paid account");
        System.out.println("3- saved bank account");
    }
}
