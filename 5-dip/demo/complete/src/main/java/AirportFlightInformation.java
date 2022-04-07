// High level component that adds business value
public class AirportFlightInformation {
    // Depends on abstraction
    private FlightRepository repo;

    public AirportFlightInformation(FlightRepository repo) {
        this.repo = repo;
    }

    public void displayFlights() {
        var flights = repo.findAll();

        flights.forEach(System.out::println);
    }

    public void displayGoToGateFlights() {
        var flights = repo.findAll();

        flights.stream()
                .filter(f -> f.callToAction().equals("Go to Gate"))
                .forEach(System.out::println);
    }

}
