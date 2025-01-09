package se.company.resource;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Represents a team that can hold a collection of {@link Employee} objects.
 * Provides functionality for managing employees, generating salary reports, and 
 * displaying information about the work being done by the team.
 */
public class Team {
    private ArrayList<Employee> employees;

    /**
     * Constructs an empty team by initializing the employee list.
     */
    public Team() {
        employees = new ArrayList<>();
    }

    /**
     * Adds an {@link Employee} to the team.
     *
     * @param emp The employee to be added to the team.
     */
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    /**
     * Generates a salary report for the team, including the total salary and a list of 
     * each employee's salary. If no employees exist in the team, a message is returned.
     *
     * @return A formatted string containing the salary report.
     */
    public String salaryReport() {
        if (employees.isEmpty()) {
            return "No employees in team. Try adding employees.";
        }

        // Get the current month and year
        LocalDateTime now = LocalDateTime.now();
        int currentYear = now.getYear();
        Month currentMonth = now.getMonth();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = now.format(dateFormatter);

        StringBuilder sb = new StringBuilder("# TEAM Salary " + currentYear + " " + currentMonth + "\n");
        sb.append("--------------------------------\n");

        // Variable to keep track of the total salary
        int totalSalary = 0;

        // Employee index
        int index = 1;

        // Loop through employees to build the salary report
        for (Employee emp : employees) {
            String formattedSalary = String.format("%,d", emp.getSalary());
            sb.append(String.format(" (%d) %-20s %s\n", index++, emp.toString(), formattedSalary));
            totalSalary += emp.getSalary();
        }

        // Append total salary and report generation date
        sb.append("--------------------------------\n");
        sb.append("Total salary is          " + String.format("%,d", totalSalary) + "\n");
        sb.append("Report generated " + formattedDate + ".\n");

        return sb.toString().trim();  // Return the final formatted report
    }

    /**
     * Displays a list of what each employee in the team is working on.
     * If no employees exist, a message is returned.
     *
     * @return A string describing the work being done by the team.
     */
    public String work() {
        if (employees.isEmpty()) {
            return "No employees in team. Try adding employees.";
        }
        StringBuilder sb = new StringBuilder("# TEAM Salary 2024 November\n");
        for (Employee emp : employees) {
            sb.append(emp.work()).append("\n");
        }
        return sb.toString().trim();
    }

    /**
     * Returns a string representation of the team, including the details of each employee.
     * If no employees exist, a message indicating an empty team is returned.
     *
     * @return A string representation of the team and its employees.
     */
    @Override
    public String toString() {
        if (employees.isEmpty()) {
            return "# TEAM:\n (empty team)";
        }
        StringBuilder sb = new StringBuilder("# TEAM:\n");
        for (Employee emp : employees) {
            sb.append(emp.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}
