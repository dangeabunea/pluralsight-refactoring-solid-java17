public class PasswordChecker {
    public boolean isPasswordValid(String password) {
        if (password.length() < PasswordConstants.MIN_PASSWORD_LENGTH) {
            return false;
        }

        var nbSpecialChars = 0;
        for (int i = 0; i < password.length(); i++) {
            var currentChar = password.charAt(i);
            if(currentChar == '#' || currentChar == '$' || currentChar == '_'){
                nbSpecialChars++;
            }
        }
        if(nbSpecialChars < PasswordConstants.NB_SPECIAL_CHARS_IN_PASSWORD){
            return false;
        }

        return true;
    }
}
