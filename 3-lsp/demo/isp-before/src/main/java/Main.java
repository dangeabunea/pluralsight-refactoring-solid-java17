import java.util.List;

public class Main {
    public static void main(String[] args) {
        var radarLabel = new StandardDisplayAircraftLabel(
                "RO1234",
                new Coordinate(45,24,9000),
                100
        );

        System.out.println(radarLabel.getDisplayValue());
        radarLabel.onLabelTouched();
        radarLabel.issueCommand("changeAlt", List.of("8000"));
    }
}
