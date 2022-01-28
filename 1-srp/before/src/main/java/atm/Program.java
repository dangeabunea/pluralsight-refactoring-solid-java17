package atm;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        var aircraft = List.of(
                new AircraftTarget("a1", 1, 2),
                new AircraftTarget("a2", 10, 3),
                new AircraftTarget("a3", -2, 7),
                new AircraftTarget("a4", 6, -3),
                new AircraftTarget("a5", 3, 4),
                new AircraftTarget("a6", 9, 10)
        );

        var radar = new Radar(0, 0);

        // lat first
        System.out.println(radar.getAircraftInRange(6, aircraft, true));

        // lon first
        System.out.println(radar.getAircraftInRange(6, aircraft, false));
    }
}
