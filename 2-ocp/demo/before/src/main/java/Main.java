import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var flightPlans = List.of(
                // valid
                new FlightPlan(
                        "RO1234", "London", "Bucharest",
                        LocalDateTime.of(2022, 2, 1, 18, 0),
                        LocalDateTime.of(2022, 2, 1, 20, 0)),

                // invalid callsign
                new FlightPlan(
                        "RO1", "London", "Bucharest",
                        LocalDateTime.of(2022, 2, 1, 18, 0),
                        LocalDateTime.of(2022, 2, 1, 20, 0)),

                // invalid departure
                new FlightPlan(
                        "RO1234", "Paris", null,
                        LocalDateTime.of(2022, 2, 1, 18, 0),
                        LocalDateTime.of(2022, 2, 1, 20, 0)),

                // invalid destination
                new FlightPlan(
                        "RO1234", "London", "",
                        LocalDateTime.of(2022, 2, 1, 18, 0),
                        LocalDateTime.of(2022, 2, 1, 20, 0))

        );

        for (var i = 0; i < flightPlans.size(); i++) {
            System.out.println("Flight plan " + i + " -> " + flightPlans.get(i).isValid());
        }
    }
}
