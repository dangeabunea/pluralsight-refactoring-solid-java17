public class PasswordChecker {
    public boolean isPasswordValid(String password){
        if(password.length() < Constants.MIN_PASSWORD_LENGTH){
            return false;
        }
        if(!password.contains("#") && !password.contains("_") && !password.contains("$")){
            return false;
        }

        return true;
    }
}
