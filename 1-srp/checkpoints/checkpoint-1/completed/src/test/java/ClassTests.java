import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClassTests {
    @Test
    public void getDiscountPriceMethodExists() {
        var getDiscountMethod = TestHelpers.getMethod("Product", "getDiscountPrice");
        assertTrue(getDiscountMethod.isPresent());
    }
}
