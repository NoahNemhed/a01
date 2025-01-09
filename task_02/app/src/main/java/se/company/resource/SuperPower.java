package se.company.resource;

/**
 * Represents a superpower that a {@link SuperEmployee} can possess.
 * Each superpower has a type and a description of its effect.
 */
public class SuperPower {
    
    private String type;
    private String description;

    /**
     * Constructor for creating a new superpower with a specified type and description.
     *
     * @param type        The type of the superpower (e.g., "Flight", "Strength").
     * @param description A detailed description of what the superpower does.
     */
    public SuperPower(String type, String description) {
        this.type = type;
        this.description = description;
    }
    
    /**
     * Returns a string describing the use of the superpower, including its type and description.
     *
     * @return A string that describes the use of the superpower.
     */
    public String usePower() {
        return "Using power: " + type + ": " + description;
    }

    /**
     * Returns the type of the superpower.
     *
     * @return The type of the superpower (e.g., "Flight", "Strength").
     */
    public String getType() {
        return type;
    }

    /**
     * Returns a string representation of the superpower, including its type and description.
     * This method overrides the default {@link Object#toString()} method to provide a meaningful 
     * description of the superpower.
     *
     * @return A string representation of the superpower.
     */
    @Override
    public String toString() {
        return type + ": " + description;
    }
}
