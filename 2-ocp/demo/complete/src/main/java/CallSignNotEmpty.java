public class CallSignNotEmpty implements ValidationRule{
    @Override
    public ValidationResult check(FlightPlan fp) {
        var result = new ValidationResult();
        if (fp.getCallSign() == null || fp.getCallSign().equals("")) {
            result.errors().add("CallSign is empty");
        }

        return result;
    }
}
