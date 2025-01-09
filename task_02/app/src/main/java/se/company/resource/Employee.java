package se.company.resource;

/**
 * Represents an employee with a name, work role, and salary.
 */
public class Employee {
    
    /** The name of the employee. */
    protected String name;
    
    /** The work role of the employee. */
    protected String work;
    
    /** The salary of the employee. */
    private int salary;

    /**
     * Constructs an Employee object with the specified name, work role, and salary.
     *
     * @param name   The name of the employee.
     * @param work   The work role of the employee.
     * @param salary The salary of the employee.
     */
    public Employee(String name, String work, int salary) {
        this.name = name;
        this.work = work;
        this.salary = salary;
    }

    /**
     * Returns a description of the employee's work activity.
     *
     * @return A string describing the employee's work.
     */
    public String work() {
        return name + " is working on a report in " + work + ".";
    }

    /**
     * Returns a string representation of the employee, including their name and work role.
     *
     * @return A string in the format "name (work)".
     */
    @Override
    public String toString() {
        return name + " (" + work + ")";
    }

    /**
     * Returns the salary of the employee.
     *
     * @return The salary of the employee.
     */
    public int getSalary() {
        return salary;
    }
}
