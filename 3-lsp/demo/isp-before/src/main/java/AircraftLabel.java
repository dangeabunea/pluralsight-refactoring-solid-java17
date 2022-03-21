import java.util.List;

public interface AircraftLabel {
    String getDisplayValue();
    String getSelectedLabelColor();
    void onFLightLabelClick();
    void onLabelDoubleClick();
    void onLabelTouched();
    void issueCommand(String id, List<String> commandArgs);
}
