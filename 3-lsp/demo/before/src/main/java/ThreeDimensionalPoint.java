public class ThreeDimensionalPoint extends TwoDimensionalPoint{
    private int alt;

    public ThreeDimensionalPoint(int x, int y, int alt) {
        super(x, y);
        this.alt = alt;
    }

    public int getAlt() {
        return alt;
    }
}
