import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StaffHireForm extends JFrame {
    private JTextArea outputArea;
    private List<StaffHire> staffList;  // List to hold StaffHire objects

    public StaffHireForm() {
        staffList = new ArrayList<>();
        setTitle("Staff Hire Form");
        setLayout(new GridLayout(14, 2, 5, 5));

        // Input fields for adding Full-Time and Part-Time Staff
        JTextField vacancyField = new JTextField();
        JTextField designationField = new JTextField();
        JTextField jobTypeField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField qualificationField = new JTextField();
        JTextField appointedByField = new JTextField();
        JTextField salaryField = new JTextField();
        JTextField workingHoursField = new JTextField();
        JTextField wagesField = new JTextField();
        JTextField shiftsField = new JTextField();
        JCheckBox joinedCheck = new JCheckBox("Joined");
       

        // Adding labels and input fields to form
        add(new JLabel("Vacancy Number:"));
        add(vacancyField);
        add(new JLabel("Designation:"));
        add(designationField);
        add(new JLabel("Job Type:"));
        add(jobTypeField);
        add(new JLabel("Staff Name:"));
        add(nameField);
        add(new JLabel("Joining Date:"));
        add(dateField);
        add(new JLabel("Qualification:"));
        add(qualificationField);
        add(new JLabel("Appointed By:"));
        add(appointedByField);
        add(new JLabel("Salary:"));
        add(salaryField);
        add(new JLabel("Working Hours:"));
        add(workingHoursField);
        add(new JLabel("Wages Per Hour:"));
        add(wagesField);
        add(new JLabel("Shifts:"));
        add(shiftsField);
        add(new JLabel(""));
        add(joinedCheck);

        // Buttons for functionality
        JButton addFullTimeButton = new JButton("Add Full-Time Staff");
        JButton addPartTimeButton = new JButton("Add Part-Time Staff");
        JButton setSalaryButton = new JButton("Set Salary");
        JButton setShiftsButton = new JButton("Set Shifts");
        JButton terminateButton = new JButton("Terminate Part-Time Staff");
        JButton displayButton = new JButton("Display Staff Info");
        JButton clearButton = new JButton("Clear Fields");

        add(addFullTimeButton);
        add(addPartTimeButton);
        add(setSalaryButton);
        add(setShiftsButton);
        add(terminateButton);
        add(displayButton);
        add(clearButton);

        // Text area for displaying results
        outputArea = new JTextArea(5, 30);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        // Action listeners for buttons
        addFullTimeButton.addActionListener(e -> {
            try {
                int vacancyNo = Integer.parseInt(vacancyField.getText());
                String designation = designationField.getText();
                String jobType = jobTypeField.getText();
                String name = nameField.getText();
                String date = dateField.getText();
                String qualification = qualificationField.getText();
                String appointedBy = appointedByField.getText();
                boolean joined = joinedCheck.isSelected();
                double salary = Double.parseDouble(salaryField.getText());

                FullTimeStaffHire staff = new FullTimeStaffHire(vacancyNo, designation, jobType, name, date,
                        qualification, appointedBy, joined, salary);
                staffList.add(staff);
                outputArea.setText("Full-Time Staff Added");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            }
        });

        addPartTimeButton.addActionListener(e -> {
            try {
                int vacancyNo = Integer.parseInt(vacancyField.getText());

                String designation = designationField.getText();

                String jobType = jobTypeField.getText();

                String name = nameField.getText();

                String date = dateField.getText();

                String qualification = qualificationField.getText();

                String appointedBy = appointedByField.getText();

                boolean joined = joinedCheck.isSelected();

                int workingHours = Integer.parseInt(workingHoursField.getText());

                double wages = Double.parseDouble(wagesField.getText());

                String shifts = shiftsField.getText();

                PartTimeStaffHire staff = new PartTimeStaffHire(vacancyNo, designation, jobType, name, date,
                        qualification, appointedBy, joined, workingHours, wages, shifts);
                staffList.add(staff);
                outputArea.setText("Part-Time Staff Added");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            }
        });

        setSalaryButton.addActionListener(e -> {
            try {
                int vacancyNo = Integer.parseInt(vacancyField.getText());
                String staffName = nameField.getText();
                double salary = Double.parseDouble(salaryField.getText());

                // Search for matching Full-Time Staff
                for (StaffHire staff : staffList) {
                    if (staff instanceof FullTimeStaffHire) {
                        FullTimeStaffHire fullTimeStaff = (FullTimeStaffHire) staff;
                        if (fullTimeStaff.getVacancyNumber() == vacancyNo && fullTimeStaff.getStaffName().equalsIgnoreCase(staffName)) {
                            fullTimeStaff.setSalary(salary);
                            outputArea.setText("Salary updated for: " + staffName);
                            return;
                        }
                    }
                }
                outputArea.setText("No matching Full-Time Staff found.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            }
        });

        setShiftsButton.addActionListener(e -> {
            try {
                int vacancyNo = Integer.parseInt(vacancyField.getText());
                String staffName = nameField.getText();
                String newShifts = shiftsField.getText();

                // Search for matching Part-Time Staff
                for (StaffHire staff : staffList) {
                    if (staff instanceof PartTimeStaffHire) {
                        PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                        if (partTimeStaff.getVacancyNumber() == vacancyNo && partTimeStaff.getStaffName().equalsIgnoreCase(staffName)) {
                            partTimeStaff.setShifts(newShifts);
                            outputArea.setText("Shifts updated for: " + staffName);
                            return;
                        }
                    }
                }
                outputArea.setText("No matching Part-Time Staff found.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            }
        });

        terminateButton.addActionListener(e -> {
            try {
                int vacancyNo = Integer.parseInt(vacancyField.getText());

                // Search and terminate matching Part-Time Staff
                for (StaffHire staff : staffList) {
                    if (staff instanceof PartTimeStaffHire) {
                        PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                        if (partTimeStaff.getVacancyNumber() == vacancyNo) {
                            partTimeStaff.terminate();
                            outputArea.setText("Part-Time Staff terminated.");
                            return;
                        }
                    }
                }
                outputArea.setText("No matching Part-Time Staff found.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            }
        });

        displayButton.addActionListener(e -> {
            if (staffList.isEmpty()) {
                outputArea.setText("No staff data available.");
                return;
            }
        
            StringBuilder allStaffInfo = new StringBuilder();
            for (StaffHire staff : staffList) {
                if (staff instanceof PartTimeStaffHire) {
                    allStaffInfo.append(((PartTimeStaffHire) staff).displayDetails()).append("\n\n");
                } else if (staff instanceof FullTimeStaffHire) {
                    allStaffInfo.append(((FullTimeStaffHire) staff).displayDetails()).append("\n\n");
                }
            }
        
            outputArea.setText(allStaffInfo.toString());
        });
        
            
        

        clearButton.addActionListener(e -> {
            // Clear all input fields
            vacancyField.setText("");
            designationField.setText("");
            jobTypeField.setText("");
            nameField.setText("");
            dateField.setText("");
            qualificationField.setText("");
            appointedByField.setText("");
            salaryField.setText("");
            workingHoursField.setText("");
            wagesField.setText("");
            shiftsField.setText("");
            joinedCheck.setSelected(false);
            outputArea.setText("");  // Clear the output area
        });

        // Set the window properties
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StaffHireForm();
    }
}
