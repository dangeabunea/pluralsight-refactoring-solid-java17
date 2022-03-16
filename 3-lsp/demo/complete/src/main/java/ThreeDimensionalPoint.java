public class ThreeDimensionalPoint {
    private int lat;
    private int lon;
    private int alt;

    public ThreeDimensionalPoint(int lat, int lon, int alt) {
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
    }

    public int getAlt() {
        return alt;
    }

    public int getLat() {
        return lat;
    }

    public int getLon() {
        return lon;
    }
}
