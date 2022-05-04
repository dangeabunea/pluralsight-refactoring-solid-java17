import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PointInsideAreasCalculatorTests {
    @Test
    public void calculateMethodShouldReturnTrueIfPointInCircle() {
        List<Shape> shapes = List.of(
                new Circle(0,0,10)
        );
        var calc = new PointInsideAreasCalculator();

        var result = calc.isPointInsideAreas(2,2,shapes);
        assertTrue(result);
    }

    @Test
    public void calculateMethodShouldReturnFalseIfPointOutsideCircle() {
        List<Shape> shapes = List.of(
                new Circle(0,0,10)
        );
        var calc = new PointInsideAreasCalculator();

        var result = calc.isPointInsideAreas(11,11,shapes);
        assertFalse(result);
    }

    @Test
    public void calculateMethodShouldReturnTrueIfPointInRectangle() {
        List<Shape> shapes = List.of(
                new Rectangle(0,0,4,4)
        );
        var calc = new PointInsideAreasCalculator();

        var result = calc.isPointInsideAreas(3,3,shapes);
        assertTrue(result);
    }

    @Test
    public void calculateMethodShouldReturnFalseIfPointOutsideRectangle() {
        List<Shape> shapes = List.of(
                new Rectangle(0,0,4,4)
        );
        var calc = new PointInsideAreasCalculator();

        var result = calc.isPointInsideAreas(4,5,shapes);
        assertFalse(result);
    }

    @Test
    public void calculateMethodShouldReturnTrueIfPointInShapes() {
        List<Shape> shapes = List.of(
                new Rectangle(0,0,4,4),
                new Circle(10,10, 7)
        );
        var calc = new PointInsideAreasCalculator();

        var result = calc.isPointInsideAreas(6,6,shapes);
        assertTrue(result);
    }
}
