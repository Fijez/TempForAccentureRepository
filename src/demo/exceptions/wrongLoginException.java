package demo.exceptions;

public class wrongLoginException extends Exception{
    public wrongLoginException() {

    }

    public wrongLoginException(String wrongLoginException) {
        System.out.println(wrongLoginException);
    }
}
