import java.time.LocalDateTime;

public class FlightPlan {
    private String callSign;
    private String departure;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime destinationTime;


    public FlightPlan(String callSign, String departure, String destination, LocalDateTime departureTime, LocalDateTime departureDestination) {
        this.callSign = callSign;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.destinationTime = departureDestination;
    }

    public String getCallSign() {
        return callSign;
    }

    public String getDestination() {
        return destination;
    }

    public String getDeparture() {
        return departure;
    }
}
