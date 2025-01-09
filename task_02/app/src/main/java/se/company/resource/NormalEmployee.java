package se.company.resource;

/**
 * Represents a normal employee with a name, job role, and salary.
 * This class extends the {@link Employee} class and provides the implementation 
 * for the {@link #work()} method specific to normal employees.
 */
public class NormalEmployee extends Employee {

    /**
     * Constructor for creating a new NormalEmployee with the given name, job role, and salary.
     *
     * @param name   The name of the employee.
     * @param work   The job role or work description of the employee.
     * @param salary The salary of the employee.
     */
    public NormalEmployee(String name, String work, int salary){
        super(name, work, salary); 
    }

    /**
     * Returns a string describing what the normal employee is working on.
     * This method overrides the {@link Employee#work()} method to provide 
     * a customized message specific to normal employees.
     *
     * @return A string describing the employee's work.
     */
    @Override
    public String work() {
        return "Emp: " + name + " is working on a report in " + work + ".";
    }
}
