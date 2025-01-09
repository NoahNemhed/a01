package se.adlez.game;

import java.io.*;

public class ForestToFile {

    /**
     * Save forest to a file using serialization.
     */
    public static void save(Forest forest, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(forest);
            System.out.println("Saved serialized forest to file '" + fileName + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load forest from a file using serialization.
     */
    public static Forest load(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Forest forest = (Forest) in.readObject();
            System.out.println("Loaded serialized forest from file '" + fileName + "'.");
            return forest;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null; // Return null in case of error
    }
}

