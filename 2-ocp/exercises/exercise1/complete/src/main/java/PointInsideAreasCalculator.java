import java.util.List;

public class PointInsideAreasCalculator {
    public boolean isPointInsideAreas(int x, int y, List<Shape> shapes) {
        for (var s : shapes) {
            // For each new shape type we need to modify
            // this calculator
            /*

            if (s instanceof Rectangle r) {
                if (x <= r.getMaxX() &&
                        x >= r.getMinX() &&
                        y >= r.getMinY() &&
                        y <= r.getMaxY()) {
                    return true;
                }
            }

            if (s instanceof Circle c) {
                var distToOrigin = Math.sqrt(
                        (c.getyOrigin() - y) * (c.getyOrigin() - y) +
                        (c.getxOrigin() - x) * (c.getxOrigin() - x)
                );
                if (distToOrigin <= c.getRadius()) {
                    return true;
                }
            }
            */
            if(s.isPointInsideArea(x, y)){
                return true;
            }
        }
        return false;
    }
}
