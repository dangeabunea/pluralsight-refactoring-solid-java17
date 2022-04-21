import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileTest {
    @Test
    public void UnitConversionClassConstantsExists(){
        var unitConversionClass = TestHelpers.getClass("UnitConversionConstants");
        assertTrue(unitConversionClass.isPresent());
    }

    @Test
    public void PasswordConstantsClassExists(){
        var passwordConstants = TestHelpers.getClass("PasswordConstants");
        assertTrue(passwordConstants.isPresent());
    }

    @Test
    public void ConstantsClassWasRemoved(){
        var passwordConstants = TestHelpers.getClass("Constants");
        assertFalse(passwordConstants.isPresent());
    }
}
