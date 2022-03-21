import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        var radarLabel = new StandardDisplayAircraftLabel(
                "RO1234",
                new Coordinate(45, 24, 9000),
                100
        );

        out.println(radarLabel.getDisplayValue());
    }
}
