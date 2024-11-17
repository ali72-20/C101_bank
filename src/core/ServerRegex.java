package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerRegex {
   private ServerRegex(){};

    private static final String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";


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
}
