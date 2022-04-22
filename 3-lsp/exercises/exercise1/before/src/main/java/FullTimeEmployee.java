public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, int age) {
        super(name, age);
    }

    @Override
    public int calculateRemainingTimeOff() {
        // Standard time off
        int maxTimeOffDays = 21;

        // Allowed time off increases with age
        if (this.getAge() > 40) {
            maxTimeOffDays = 23;
        }

        return maxTimeOffDays - this.getTimeOffDaysTaken();
    }
}
