import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        var calc = new DistanceCalculator();

        // Correct result
        TwoDimensionalPoint p1 = new TwoDimensionalPoint(1, 1);
        TwoDimensionalPoint p2 = new TwoDimensionalPoint(3, 3);
        out.println(calc.calculate(p1, p2));

        ThreeDimensionalPoint p3 = new ThreeDimensionalPoint(1, 1, 0);
        ThreeDimensionalPoint p4 = new ThreeDimensionalPoint(3, 3, 4);
        out.println(calc.calculate(p3, p4));
    }
}
