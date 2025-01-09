package se.adlez.game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ForestToJson {

    /**
     * Print the forest as JSON data structure.
     */
    public static void printForestAsJson(Forest forest) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(forest);
        System.out.println(json);
    }

    /**
     * Save the forest as JSON data structure to file.
     */
    public static void saveForestAsJson(Forest forest, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(forest);
        Path path = Path.of(fileName);

        try {
            Files.writeString(path, json);
            System.out.println("Saved JSON data to '" + fileName + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
