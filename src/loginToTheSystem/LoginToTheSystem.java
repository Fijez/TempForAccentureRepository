package loginToTheSystem;

import loginToTheSystem.exceptions.wrongLoginException;
import loginToTheSystem.exceptions.wrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginToTheSystem {
    public static void main(String[] args) {
        System.out.println(LoginToTheSystem.login("lsh", "sdfkgj1", "sdfkgj1"));
    }
    private static final Pattern pattern = Pattern.compile("[^a-zA-Z\\d]");
    private static Matcher matcher;

    public static boolean login (String login, String password, String confirmPassword) {

        matcher = pattern.matcher(login);
        try {
            if (login.length() >= 20 || matcher.find()) {
                throw new wrongLoginException();
            }
            matcher = matcher.reset(password);
            if (password.length() >= 20 || matcher.find() ||
                    !password.equals(confirmPassword)) {
                throw new wrongPasswordException();
            }
        }  catch(wrongLoginException | wrongPasswordException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
