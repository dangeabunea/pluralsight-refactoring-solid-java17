public class DepartureDifferentFromDestination implements ValidationRule {
    @Override
    public ValidationResult check(FlightPlan fp) {
        var result = new ValidationResult();
        if (fp.getDeparture() != null && fp.getDeparture().equals(fp.getDestination())) {
            result.errors().add("Departure and destination are the same");
        }

        return result;
    }
}
