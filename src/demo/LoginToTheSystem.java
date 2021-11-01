package demo;

import demo.exceptions.wrongLoginException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginToTheSystem {
    public static boolean login (String login, String password, String confirmPassword) {
        Pattern pattern = Pattern.compile("[^a-zA-Z\\d]");
        Matcher matcher = pattern.matcher(login);
        if(login.length() < 20 && matcher.find()) {
            try {
                throw new wrongLoginException("WrongLoginException");
            } catch (wrongLoginException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
