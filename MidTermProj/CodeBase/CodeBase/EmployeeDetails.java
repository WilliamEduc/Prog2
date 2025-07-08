package Project.CodeBase.CodeBase;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeDetails {

    private String employeeId;
    private String employeeName;
    private String department;
    private Payroll payroll;

    public EmployeeDetails() {
        this.payroll = new Payroll(); // connect to Payroll class
    }

    public void inputEmployeeDetails() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome to ABC Payroll System");

            String regex = "^EMP-\\d{4}$";

            while (true) {
                System.out.print("Enter Employee ID (Format: EMP-XXXX): ");
                String inputId = scanner.nextLine();

                if (Pattern.matches(regex, inputId)) {
                    this.setEmployeeId(inputId);
                    break;
                }
                System.out.println("Invalid format. Please follow the format: EMP-XXXX");
            }

            while (true) {
                System.out.print("Enter Full Name: ");
                String nameInput = scanner.nextLine().trim();
                if (!nameInput.isEmpty() && !nameInput.matches(".*\\d.*")) {
                    this.setEmployeeName(nameInput);
                    break;
                }
                System.out.println("Invalid input. Please try again!");
            }

            System.out.print("Enter Department: ");
            this.setDepartment(scanner.nextLine());

            System.out.print("Enter Basic Monthly Salary ₱: ");
            double basicSalary = scanner.nextDouble();
            while (basicSalary < 0) {
                System.out.print("Negative value! Enter again: ");
                basicSalary = scanner.nextDouble();
            }

            System.out.print("Enter Overtime Hours Worked: ");
            int overtimeHours = scanner.nextInt();
            while (overtimeHours < 0) {
                System.out.print("Negative value! Enter again: ");
                overtimeHours = scanner.nextInt();
            }

            // Set the payroll data via the Payroll class setters
            payroll.setBasicSalary(basicSalary);
            payroll.setOvertimeHours(overtimeHours);

            // Now you can add methods like:
            // calculatePayrollValues() or printPayslip() if you want

        } catch (Exception e) {
            System.out.println("An error occurred: Invalid input.");
        }
    }

    // Getters and setters for employee fields
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Payroll getPayroll() {
        return payroll;
    }

    // Optionally: getters for ID, name, etc. if needed
}
