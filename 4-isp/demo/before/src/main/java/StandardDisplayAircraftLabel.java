import java.text.MessageFormat;
import java.util.List;

public class StandardDisplayAircraftLabel implements AircraftLabel {
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

    @Override
    public void onLabelTouched() {
// system does not support touch gestures
    }

    @Override
    public void issueCommand(String id, List<String> commandArgs) {
// system not licensed to use commands from controllers directly to aircraft
    }
}
