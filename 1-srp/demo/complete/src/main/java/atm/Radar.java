package atm;

import java.util.List;

public class Radar {
    private int originLat;
    private int originLon;

    public Radar(int originLat, int originLon) {
        this.originLat = originLat;
        this.originLon = originLon;
    }

    public String getAircraftInRange(int range, List<AircraftTarget> allAircraft, CoordinateOutputFormatter formatter) {
        var aircraftInRange = allAircraft
                .stream()
                .filter(a -> {
                    var distance = (int) Math.sqrt(
                            (originLat - a.lat()) * (originLat - a.lat()) +
                                    (originLon - a.lon()) * (originLon - a.lon()));
                    return distance <= range;
                })
                .toList();

        return formatter.parse(aircraftInRange);
    }
}
