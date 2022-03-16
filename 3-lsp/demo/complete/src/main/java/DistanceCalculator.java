import static java.lang.Math.sqrt;

public class DistanceCalculator {
    public double calculate(TwoDimensionalPoint p1, TwoDimensionalPoint p2) {
        return sqrt(
                (p1.getLat() - p2.getLat()) * (p1.getLat() - p2.getLat()) +
                (p1.getLon() - p2.getLon()) * (p1.getLon() - p2.getLon()));
    }

    public double calculate(ThreeDimensionalPoint p1, ThreeDimensionalPoint p2) {
        return sqrt(
                (p1.getLat() - p2.getLat()) * (p1.getLat() - p2.getLat()) +
                        (p1.getLon() - p2.getLon()) * (p1.getLon() - p2.getLon()) +
                        (p1.getAlt() - p2.getAlt()) * (p1.getAlt() - p2.getAlt()));
    }
}
