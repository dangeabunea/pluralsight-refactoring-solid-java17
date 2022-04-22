public abstract class Task {
    private String description;
    private int estimationInDays;
    private boolean open;

    protected Task(String description, int estimationInDays) {
        this.description = description;
        this.estimationInDays = estimationInDays;
        this.open = true;
    }

    public void close() {
        this.open = false;
    }

    public String getDescription() {
        return description;
    }

    public int getEstimationInDays() {
        return estimationInDays;
    }

    public boolean isOpen() {
        return open;
    }
}
