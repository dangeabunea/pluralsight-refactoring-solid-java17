import java.text.MessageFormat;
import java.util.List;

public class StandardDisplayAircraftLabel implements AircraftLabel {
    private final String callSign;
    private Coordinate position;
    private int speedLKnots;
    private String currentColor = "white";

    public StandardDisplayAircraftLabel(String callSign, Coordinate position, int speedLKnots) {
        this.callSign = callSign;
        this.position = position;
        this.speedLKnots = speedLKnots;
    }

    @Override
    public String getDisplayValue() {
        return MessageFormat.format("{0} - {1} ft - {2} kn",
                callSign,
                position.alt(),
                speedLKnots);
    }

    @Override
    public String getSelectedLabelColor() {
        return "orange";
    }

    @Override
    public void onFLightLabelClick() {
        this.currentColor  = this.getSelectedLabelColor();
    }

    @Override
    public void onLabelDoubleClick() {
        this.currentColor  = this.getSelectedLabelColor();
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
