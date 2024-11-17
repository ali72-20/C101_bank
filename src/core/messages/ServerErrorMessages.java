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
}
