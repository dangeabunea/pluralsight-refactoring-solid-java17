package atm;

import java.util.List;

public class CoordinateOutputFormatter {
    private boolean latFirst;

    public CoordinateOutputFormatter(boolean latFirst) {
        this.latFirst = latFirst;
    }

    public String parse(List<AircraftTarget> targets) {
        var sb = new StringBuilder();
        if (latFirst) {
            targets.forEach(target -> buildLatLon(sb, target));
        } else {
            targets.forEach(target -> buildLonLat(sb, target));
        }

        return sb.toString();
    }

    private StringBuilder buildLonLat(StringBuilder sb, AircraftTarget target) {
        return sb
                .append("[")
                .append(target.lon())
                .append(" ")
                .append(target.lat())
                .append("] ");
    }

    private StringBuilder buildLatLon(StringBuilder sb, AircraftTarget target) {
        return sb
                .append("[")
                .append(target.lat())
                .append(" ")
                .append(target.lon())
                .append("] ");
    }
}
