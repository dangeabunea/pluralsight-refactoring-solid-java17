public abstract class Employee {
    private String name;
    private int age;
    private int timeOffDaysTaken;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getTimeOffDaysTaken() {
        return timeOffDaysTaken;
    }

    public void setTimeOffDaysTaken(int timeOffDaysTaken) {
        this.timeOffDaysTaken = timeOffDaysTaken;
    }

    public abstract int calculateRemainingTimeOff();
}
