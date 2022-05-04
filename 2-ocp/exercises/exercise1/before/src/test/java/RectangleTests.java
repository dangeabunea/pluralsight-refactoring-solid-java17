import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RectangleTests {
    @Test
    public void shouldImplementIsPointInAreaMethod() throws InvocationTargetException, IllegalAccessException {
        var rectangle = new Rectangle(0,0,4,4);
        var method = TestHelpers.getMethod("Rectangle", "isPointInsideArea");

        boolean result1 = (boolean) method.get().invoke(rectangle,2,2);
        assertTrue(result1);

        boolean result2 = (boolean) method.get().invoke(rectangle,5,5);
        assertFalse(result2);
    }
}
