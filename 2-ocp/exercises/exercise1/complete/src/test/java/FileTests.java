import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileTests {
    @Test
    public void allShapesShouldHaveIsPointInsideMethod(){
        var shapeMethod = TestHelpers.getMethod("Shape", "isPointInsideArea");
        var circleMethod = TestHelpers.getMethod("Circle", "isPointInsideArea");
        var rectangleMethod = TestHelpers.getMethod("Rectangle", "isPointInsideArea");

        assertTrue(shapeMethod.isPresent());
        assertTrue(circleMethod.isPresent());
        assertTrue(rectangleMethod.isPresent());
    }
}
