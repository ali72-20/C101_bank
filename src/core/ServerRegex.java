package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerRegex {
   private ServerRegex(){};

    private static final String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
//    private static final String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$\n";

    /**
     * Valid email for regex "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
     * @param email
     * @return is email is match the email regex
     */
    public static boolean isValidEmailRegex(String email){
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }

    /**
     * valid password for password rules:"^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$\n";
     * 1- password must contain upper case and lower case letters
     * 2- password must contain digits number
     * 3- password must contain Sympoles
     * @param password
     * @return is password valid
     */
//    public static boolean isValidPasswordRegex(String password){
//        Pattern pattern = Pattern.compile(passwordRegex);
//        Matcher matcher = pattern.matcher(password);
//        return matcher.matches();
//    }

}
