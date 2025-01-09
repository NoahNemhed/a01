package se.company.resource;

import java.util.Scanner;

/**
 * Represents a menu interface for interacting with a team of employees.
 * Allows the user to create teams, add employees, and various operations like generating salary reports and add employees.
 */
public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private Team team = null;

    /**
     * Starts the menu interaction loop, allowing the user to select options to manage the team and employees.
     */
    public void run() {
        String choice;
        do {
            printMenu();
            choice = getChoice();

            switch (choice) {
                case "1":
                    team = new Team();
                    System.out.println(team.toString());
                    break;
                case "2":
                    if (isTeamEmpty()) break;
                    addSingleEmployee(team);
                    break;
                case "3":
                    if (isTeamEmpty()) break;
                    addThreeNormalEmployees(team);
                    break;
                case "4":
                    if (isTeamEmpty()) break;
                    System.out.println(team.work());
                    break;
                case "5":
                    if (isTeamEmpty()) break;
                    addSingleSuperEmployee(team);
                    break;
                case "6":
                    if (isTeamEmpty()) break;
                    addThreeSuperEmployeesWithPowers(team);
                    break;
                case "7":
                    if (isTeamEmpty()) break;
                    System.out.println(team.salaryReport());
                    break;
                case "m":
                    printMenu();
                    break;
                case "q":
                case "Q":
                    System.out.println("Quitting..");
                    sc.close();
                    break;
                default:
                    System.err.println("Bad menu choice, use 'm' to get the menu.");
            }
        } while (!(choice.equalsIgnoreCase("q")));
    }

    /**
     * Checks if a team has been created. If not, prompts the user to create one.
     *
     * @return true if the team is null, false otherwise.
     */
    protected boolean isTeamEmpty() {
        if (team == null) {
            System.out.println("You need to create a team first (choose option 1).\n");
            return true;
        }
        return false;
    }

    /**
     * Adds three normal employees to the team with predefined details.
     *
     * @param team The team to which the employees will be added.
     */
    protected void addThreeNormalEmployees(Team team) {
        team.addEmployee(new NormalEmployee("Jane Doe", "IT", 250));
        team.addEmployee(new NormalEmployee("John Doe", "Economic", 250));
        team.addEmployee(new NormalEmployee("Little JR Doe", "Trainee", 250));
        System.out.println(team.toString());
    }

    /**
     * Adds three super employees, each with different powers, to the team.
     *
     * @param team The team to which the super employees will be added.
     */
    protected void addThreeSuperEmployeesWithPowers(Team team) {
        SuperPower flight = new SuperPower("Flight", "Fly at supersonic speeds.");
        SuperPower invisibility = new SuperPower("Invisibility", "Become invisible to the naked eye.");
        SuperPower strength = new SuperPower("Strength", "Becomes insanely strong.");

        SuperEmployee Clark = new SuperEmployee("Clark Kent", "IT");
        Clark.addPower(flight);
        Clark.addPower(strength);

        SuperEmployee Jessica = new SuperEmployee("Jessica Jones", "Investigations");
        Jessica.addPower(strength);
        Jessica.addPower(invisibility);

        SuperEmployee Wade = new SuperEmployee("Wade Wilson", "Public relations");
        Wade.addPower(flight);
        Wade.addPower(invisibility);

        team.addEmployee(Clark);
        team.addEmployee(Jessica);
        team.addEmployee(Wade);

        System.out.println(team.toString());
    }

    /**
     * Prompts the user to enter details for a new normal employee and adds them to the team.
     * @param team The team to which the super employees will be added.
     */
    protected void addSingleEmployee(Team team) {
        System.out.println("# Create new NormalEmployee");

        sc.nextLine(); // Avoids name and work printing on the same line
        System.out.print("Enter name : ");
        String normalEmployeeName = sc.nextLine();

        System.out.print("Enter work : ");
        String normalEmployeeWork = sc.nextLine();

        int normalEmployeeSalary = 0;
        boolean validSalary = false;

        while (!validSalary) {
            System.out.print("Enter salary : ");
            try {
                normalEmployeeSalary = Integer.parseInt(sc.nextLine());
                validSalary = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number for salary.");
            }
        }

        Employee normaEmployee = new NormalEmployee(normalEmployeeName, normalEmployeeWork, normalEmployeeSalary);
        team.addEmployee(normaEmployee);

        System.out.println(team.toString());
    }

    /**
     * Prompts the user to enter details for a new super employee and adds them to the team.
     * @param team The team to which the super employees will be added.
     */
    protected void addSingleSuperEmployee(Team team) {
        System.out.println("# Create new SuperEmployee");
        sc.nextLine(); // Avoids name and work printing on the same line

        System.out.print("Enter name : ");
        String superEmployeeName = sc.nextLine();

        System.out.print("Enter work : ");
        String superEmployeeWork = sc.nextLine();

        team.addEmployee(new SuperEmployee(superEmployeeName, superEmployeeWork));

        System.out.println(team.toString());
    }

    /**
     * Prints the menu options to the console, allowing the user to choose an action.
     */
    /** */
    public void printMenu() {
        String menuText = """
                 -----------------
                | 1) Create a new empty team
                | 2) Add normal employee to team
                | 3) Add John, Jane and little Jr
                | 4) Print out work being done
                | 5) Add super employee to team
                | 6) Add three super employee, with powers, to team
                | 7) Salary report
                | m) Print menu
                | qQ) Quit
                -----------------
                """;
        System.out.println(menuText);
    }

    /**
     * Prompts the user to enter their choice from the menu.
     *
     * @return The user's choice as a string.
     */
    public String getChoice() {
        System.out.print("Enter your choice : ");
        return sc.next();
    }
}
