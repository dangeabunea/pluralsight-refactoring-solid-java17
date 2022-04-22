public class Bug extends Task {
    private boolean verifiedByCustomer;

    public Bug(String description, int estimationInDays) {
        super(description, estimationInDays);
        this.verifiedByCustomer = false;
    }

    public boolean isVerifiedByCustomer() {
        return verifiedByCustomer;
    }

    public void setVerifiedByCustomer(boolean verifiedByCustomer) {
        this.verifiedByCustomer = verifiedByCustomer;
    }

    @Override
    public void close() {
        if(isVerifiedByCustomer()) {
            super.close();
        }
    }
}
