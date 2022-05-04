public class Circle extends Shape {
    private int xOrigin;
    private int yOrigin;
    private int radius;

    public Circle(int xOrigin, int yOrigin, int radius) {
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.radius = radius;
    }

    public int getxOrigin() {
        return xOrigin;
    }

    public int getyOrigin() {
        return yOrigin;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean isPointInsideArea(int x, int y) {
        var distToOrigin = Math.sqrt(
                (getyOrigin() - y) * (getyOrigin() - y) +
                        (getxOrigin() - x) * (getxOrigin() - x)
        );
        return distToOrigin <= getRadius();
    }
}
