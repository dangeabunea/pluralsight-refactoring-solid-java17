import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExternalContractorTests {
    @Test
    public void shouldNotExtendEmployee() {
        var contractorClass = TestHelpers.getClass("ExternalContractor");
        if(!contractorClass.isPresent()){
            return;
        }

        assertFalse(Employee.class.isAssignableFrom(contractorClass.get()));
    }

    @Test
    public void shouldNotHaveMethodForRemainingTimeOff() {
        var remainingTimeOffMethod = TestHelpers.getMethod("ExternalContractor", "calculateRemainingTimeOff");

        assertFalse(remainingTimeOffMethod.isPresent());
    }

    @Test void shouldHaveNameAndAgeFields(){
        var nameField = TestHelpers.getField("ExternalContractor", "name");
        var ageField = TestHelpers.getField("ExternalContractor", "age");

        assertTrue(nameField.isPresent());
        assertTrue(ageField.isPresent());
    }
}
