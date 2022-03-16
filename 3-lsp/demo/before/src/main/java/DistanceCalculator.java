public class DistanceCalculator {
    public double calculate(TwoDimensionalPoint p1, TwoDimensionalPoint p2) {
        return Math.sqrt(
                (p1.getLat() - p2.getLat()) * (p1.getLat() - p2.getLat()) +
                (p1.getLon() - p2.getLon()) * (p1.getLon() - p2.getLon()));
    }
}
