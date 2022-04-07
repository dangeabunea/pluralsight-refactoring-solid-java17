public class Main {
    public static void main(String[] args) {
        var repo = new FileFlightRepository();
        var airportInfo = new AirportFlightInformation(repo);

        System.out.println("ALL");
        airportInfo.displayFlights();

        System.out.println("GO TO GATE");
        airportInfo.displayGoToGateFlights();
    }
}
