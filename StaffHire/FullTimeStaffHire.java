public class FullTimeStaffHire extends StaffHire {
    private double salary;

    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName,
                             String joiningDate, String qualification, String appointedBy, boolean joined, double salary) {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String displayDetails() {
        return String.format("Full Time Staff Details:\nVacancy Number: %d\nStaff Name: %s\nSalary: %.2f",
                             vacancyNumber, staffName, salary);
    }
}
