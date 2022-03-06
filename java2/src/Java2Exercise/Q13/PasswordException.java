package Java2Exercise.Q13;

public class PasswordException extends Exception {

    int len;
    PasswordException(int len){
        this.len=len;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("password length is too small"+len);
    }
}
