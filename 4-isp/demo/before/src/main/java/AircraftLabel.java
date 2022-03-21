import java.util.List;

public interface AircraftLabel {
    String getDisplayValue();
    String getSelectedLabelColor();
    void onFlightLabelClick();
    void onLabelDoubleClick();
    void onLabelTouched();
    void issueCommand(String id, List<String> commandArgs);
}
