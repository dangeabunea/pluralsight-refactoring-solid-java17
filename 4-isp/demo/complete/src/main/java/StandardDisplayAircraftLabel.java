import java.text.MessageFormat;
import java.util.List;

public class StandardDisplayAircraftLabel implements AircraftLabel, LabelWithMouseInteraction {
    private final String callSign;
    private Coordinate position;
    private int speedInKnots;
    private String currentColor = "white";

    public StandardDisplayAircraftLabel(String callSign, Coordinate position, int speedInKnots) {
        this.callSign = callSign;
        this.position = position;
        this.speedInKnots = speedInKnots;
    }

    @Override
    public String getDisplayValue() {
        return MessageFormat.format("{0} @ {1} ft - {2} knots",
                callSign,
                position.alt(),
                speedInKnots);
    }

    @Override
    public String getSelectedLabelColor() {
        return "orange";
    }

    @Override
    public void onFlightLabelClick() {
        this.currentColor = getSelectedLabelColor();
    }

    @Override
    public void onLabelDoubleClick() {
        this.currentColor = getSelectedLabelColor();
    }
}
