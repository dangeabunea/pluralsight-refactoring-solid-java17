import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileTests {
    @Test
    public void allShapesShouldHaveIsPointInsideMethod(){
        var shapeMethod = TestHelpers.getMethod("Shape", "isPointInside");
        var circleMethod = TestHelpers.getMethod("Circle", "isPointInside");
        var rectangleMethod = TestHelpers.getMethod("Rectangle", "isPointInside");

        assertTrue(shapeMethod.isPresent());
        assertTrue(circleMethod.isPresent());
        assertTrue(rectangleMethod.isPresent());
    }
}
