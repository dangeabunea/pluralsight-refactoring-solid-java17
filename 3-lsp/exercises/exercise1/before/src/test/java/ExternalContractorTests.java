import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
}
