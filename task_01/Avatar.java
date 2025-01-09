import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

class Avatar {
    public static void printMarvin() {
        Path path = Path.of("avatar.txt");
        try {
            String asciiArt = Files.readString(path);
            System.out.println(asciiArt);
        } catch (IOException e) {
            System.err.println("Error reading the file " + path);
        }
    }
}
