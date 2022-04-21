import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodeTest {

    @Test
    public void PasswordConstantsShouldStaticFields(){
        assertTrue(TestHelpers.getField("PasswordConstants", "NB_SPECIAL_CHARS_IN_PASSWORD").isPresent());
        assertTrue(TestHelpers.getField("PasswordConstants", "MIN_PASSWORD_LENGTH").isPresent());
    }

    @Test
    public void UnitConversionConstantsShouldStaticFields(){
        assertTrue(TestHelpers.getField("UnitConversionConstants", "NM_TO_METER").isPresent());
        assertTrue(TestHelpers.getField("UnitConversionConstants", "GALLON_TO_LITER").isPresent());
    }
}
