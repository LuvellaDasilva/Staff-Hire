public class PartTimeStaffHire extends StaffHire {
    private String staffName, joiningDate, qualification, appointedBy, shifts;
    private int workingHours;
    private double wagesPerHour;
    private boolean joined;
    private boolean terminated;

    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType,
                             String staffName, String joiningDate, String qualification,
                             String appointedBy, boolean joined, int workingHours,
                             double wagesPerHour, String shifts) {
        super(vacancyNumber, designation, jobType);
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.joined = joined;
        this.workingHours = workingHours;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }

    public void terminate() {
        if (!terminated) {
            this.staffName = "";
            this.joiningDate = "";
            this.qualification = "";
            this.appointedBy = "";
            this.joined = false;
            this.terminated = true;
        }
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setShifts(String shifts) {
        if (!terminated) {
            this.shifts = shifts;
        }
    }

    public int getVacancyNumber() {
        return super.getVacancyNumber();
    }

    public String getStaffName() {
        return staffName;
    }

    public String displayDetails() {
        if (terminated) {
            return "Staff (Vacancy " + getVacancyNumber() + ") has been terminated.";
        }
        return "Name: " + staffName + "\nJoined: " + joined + "\nShifts: " + shifts;
    }
}
