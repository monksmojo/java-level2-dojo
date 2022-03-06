package Java2Exercise.Q13;

public class Q13PaswordChecker {
    String password;
    int passwordLength;

    Q13PaswordChecker(String p){
            this.password = p;
            this.passwordLength = p.length();

    }
    public void checkLength()throws PasswordException{
        if(this.passwordLength<=8){
            throw new PasswordException(passwordLength);
        }
        else{
            System.out.println("password length is accepted");
        }
    }
}
