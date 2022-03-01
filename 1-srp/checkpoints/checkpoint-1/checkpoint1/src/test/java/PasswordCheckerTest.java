import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordCheckerTest {
    @Test
    public void if_length_less_than_12_should_return_false(){
        var smallPassword = "password";

        var passwordChecker = new PasswordChecker();
        var result = passwordChecker.isPasswordValid(smallPassword);

        assertEquals(result, false);
    }

    @Test
    public void if_no_special_character_should_return_false(){
        var noSpecialCharacter = "someRandomPassword";

        var passwordChecker = new PasswordChecker();
        var result = passwordChecker.isPasswordValid(noSpecialCharacter);

        assertEquals(result, false);
    }

    @Test
    public void if_length_ok_and_special_character_should_return_true(){
        var passwordChecker = new PasswordChecker();

        var result = passwordChecker.isPasswordValid("$someRandomPassword");
        assertEquals(result, true);

        result = passwordChecker.isPasswordValid("#someRandomPassword");
        assertEquals(result, true);

        result = passwordChecker.isPasswordValid("_someRandomPassword");
        assertEquals(result, true);
    }
}
