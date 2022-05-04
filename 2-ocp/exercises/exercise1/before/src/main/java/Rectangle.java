public class Rectangle extends Shape {
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;


    public Rectangle(int xUpperLeft, int yUpperLeft, int xLowerRight, int yLowerRight) {
        this.minX = xUpperLeft;
        this.minY = yUpperLeft;
        this.maxX = xLowerRight;
        this.maxY = yLowerRight;
    }

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
