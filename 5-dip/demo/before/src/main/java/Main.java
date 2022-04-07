public class Main {
    public static void main(String[] args) {
        var airportInfo = new AirportFlightInformation();

        System.out.println("ALL");
        airportInfo.displayFlights();

        System.out.println("GO TO GATE");
        airportInfo.displayGoToGateFlights();
    }
}
