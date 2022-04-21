import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordCheckerTest {
    @Test
    public void WhenPasswordCorrectShouldPass(){
        var correctPassword = "$Pluralsight123";

        var passwordChecker = new PasswordChecker();

        var result = passwordChecker.isPasswordValid(correctPassword);
        assertTrue(result);
    }
}
