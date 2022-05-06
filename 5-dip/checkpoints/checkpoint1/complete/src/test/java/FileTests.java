import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileTests {
    @Test
    public void shouldCreateEmployeeApiInterface(){
        var interfacePresent =  TestHelpers.getClass("EmployeeApi").isPresent();
        assertTrue(interfacePresent);
    }
}
