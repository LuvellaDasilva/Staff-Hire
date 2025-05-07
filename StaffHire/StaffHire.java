public class StaffHire {
    protected int vacancyNumber;
    protected String designation;
    protected String jobType;
    protected String staffName;
    protected String joiningDate;
    protected String qualification;
    protected String appointedBy;
    protected boolean joined;

    public StaffHire(int vacancyNumber, String designation, String jobType) {
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.joined = joined;
    }

    public StaffHire(int vacancyNumber2, String designation2, String jobType2, String staffName2, String joiningDate2,
            String qualification2, String appointedBy2, boolean joined2) {
        //TODO Auto-generated constructor stub
    }

    // Getters and setters
    public int getVacancyNumber() {
        return vacancyNumber;
    }

    public String getStaffName() {
        return staffName;
    }
}
