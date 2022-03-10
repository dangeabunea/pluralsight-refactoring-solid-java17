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

    public ValidationResult isValid() {
        var result = new ValidationResult();
        if (callSign == null || callSign.equals("")) {
            result.errors().add("CallSign is empty");
        }

        if (callSign != null && callSign.length() < 4) {
            result.errors().add("CallSign length less than 4");
        }

        if (callSign != null && callSign.length() > 6) {
            result.errors().add("CallSign length greater than 6");
        }

        if (departure == null || departure.equals("")) {
            result.errors().add("Departure not valid");
        }

        if (destination == null || destination.equals("")) {
            result.errors().add("Destination not valid");
        }

        return result;
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
