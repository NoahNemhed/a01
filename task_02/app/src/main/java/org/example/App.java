package org.example;

import se.company.resource.Menu;

/**
 * The entry point for the application. It initializes the {@link Menu} class 
 * and starts the menu-driven user interface to interact with the system.
 * @author Noah Nemhed Uppgren
 */
public class App {

    /**
     * The main method that serves as the entry point for the application.
     * It creates an instance of {@link Menu} and invokes the {@link Menu#run()} 
     * method to start the menu-based user interaction.
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
}
