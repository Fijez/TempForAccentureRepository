package loginToTheSystem.exceptions;

public class wrongPasswordException extends Exception {
    public wrongPasswordException() {

    }
    public wrongPasswordException(String message) {
        super(message);
    }
}
