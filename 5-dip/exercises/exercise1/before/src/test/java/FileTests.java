import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileTests {
    @Test
    public void auditorInterfaceShouldExist() {
        var interfacePresent = TestHelpers.getClass("MoneyTransferAuditor").isPresent();
        assertTrue(interfacePresent);
    }

    @Test
    public void auditorInterfaceHasTwoMethods(){
        var logTransferMethodPresent = TestHelpers
                .getMethod("MoneyTransferAuditor", "logTransfer")
                .isPresent();
        var noFundsMethodPresent = TestHelpers
                .getMethod("MoneyTransferAuditor", "logInsufficientFunds")
                .isPresent();

        assertTrue(logTransferMethodPresent);
        assertTrue(noFundsMethodPresent);
    }

    @Test
    public void moneyTransferServiceShouldHaveAuditorField() {
        var fieldPresent = TestHelpers
                .getField("MoneyTransferService", "auditor")
                .isPresent();
        assertTrue(fieldPresent);
    }

    @Test
    public void moneyTransferServiceShouldDeclareDepInConstructor() {
        var constructors = TestHelpers.getConstructors("MoneyTransferService");
        assertEquals(1, constructors.size(), "Constructor not present");

        var ctorParams = Arrays.stream(constructors.get(0).getParameterTypes()).toList();
        assertEquals(ctorParams.get(0).getTypeName(), "MoneyTransferAuditor", "Constructor does not have correct param list");
    }
}
