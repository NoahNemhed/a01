package se.company.resource;

import java.util.ArrayList;

/**
 * Represents a super employee who has additional superpowers in addition to a name, job role, and salary.
 * This class extends the {@link Employee} class and includes functionality for managing superpowers.
 */
public class SuperEmployee extends Employee {

    private ArrayList<SuperPower> power;

    /**
     * Constructor for creating a new SuperEmployee with the given name and job role.
     * Initializes an empty list of powers for the super employee.
     *
     * @param name The name of the super employee.
     * @param work The job role or work description of the super employee.
     */
    public SuperEmployee(String name, String work) {
        super(name, work, 0); // Super employee salary is assumed to be zero by default
        power = new ArrayList<>();
    }

    /**
     * Adds a new superpower to the super employee's list of powers.
     *
     * @param newPower The new {@link SuperPower} to be added to the super employee.
     */
    public void addPower(SuperPower newPower) {
        power.add(newPower);
    }

    /**
     * Returns a string describing what the super employee is working on.
     * This method overrides the {@link Employee#work()} method to provide 
     * a customized message specific to super employees.
     *
     * @return A string describing the super employee's work.
     */
    @Override
    public String work() {
        return "Sup: " + name + " is working on a report in " + work + ".";
    }

    /**
     * Returns a string representation of the super employee, including their name, work, and any superpowers they have.
     * If the super employee has powers, the list of powers will be included in the output.
     * 
     * @return A string representing the super employee, including their superpowers if any.
     */
    @Override
    public String toString() {
        if (power.isEmpty()) {
            return "Sup: " + name + " (" + work + ")";
        }

        // Build a comma-separated list of power types
        StringBuilder powerList = new StringBuilder();
        for (SuperPower p : power) {
            powerList.append(p.getType()).append(", ");
        }

        // Remove the trailing comma and space
        if (powerList.length() > 0) {
            powerList.setLength(powerList.length() - 2);
        }

        return "Sup: " + name + " (" + work + ") - " + powerList.toString();
    }
}
