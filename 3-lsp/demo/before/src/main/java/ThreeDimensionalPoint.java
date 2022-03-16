public class ThreeDimensionalPoint extends TwoDimensionalPoint{
    private int alt;

    public ThreeDimensionalPoint(int lat, int lon, int alt) {
        super(lat, lon);
        this.alt = alt;
    }

    public int getAlt() {
        return alt;
    }
}
