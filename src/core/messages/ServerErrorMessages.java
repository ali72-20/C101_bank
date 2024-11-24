package core.messages;


/**
 * This class hold server error message
 * All error string is static, so you can access any message
 * with the name of class
 */
class ServerErrorMessages {
    private ServerErrorMessages() {
    }

    ;
    public static final String notValidEmail = "Not valid email";

    /**
     * This error message if user choose number not in the menu
     */
    public static final String outOfMenuChoices = "Your choice is not in the menu\nplease choose correct number";

    public static final String existInDataBase = "User already registered";
    public static final String notValidInRegex = "Email must be like: test@test.com";

    public static final String passwordNotMatch = "Password not match confirm password";

    public static final String passwordInValidLength = "Password must be more than 6 digits";
    public static final String passwordViolateRegex = "Password must contains upper case and lower case letters, digits number, Sympoles\nTest@test11";
    public static final String userNameExist = "User name already exist";

    public static final String notValidPhoneNumber = "Not valid phone number";
    public static final String loginFailed = "Login failed, Incorrect email or password!";

}
