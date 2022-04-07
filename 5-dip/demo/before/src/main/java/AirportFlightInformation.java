// High level component that adds business value
public class AirportFlightInformation {
    public void displayFlights() {
        var repo = new FileFlightRepository();
        var flights = repo.findAll();

        flights.forEach(System.out::println);
    }

    public void displayGoToGateFlights() {
        var repo = new FileFlightRepository();
        var flights = repo.findAll();

        flights.stream()
                .filter(f -> f.callToAction().equals("Go to Gate"))
                .forEach(System.out::println);
    }

}
