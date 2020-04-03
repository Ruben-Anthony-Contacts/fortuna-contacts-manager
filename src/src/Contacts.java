import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Contacts {

    public static void main(String[] args) throws IOException {
        String directory = "contactsManager"; // Declares directory name
        String filename = "contacts.txt"; // Declares file name

        Path dataDirectory = Paths.get(directory); // Main path
        Path dataFile = Paths.get(directory, filename); // Main directory

        if (Files.notExists(dataDirectory)) { // If "file name" does NOT exist within directory, create the DIRECTORY...
            Files.createDirectories(dataDirectory);
        }

        if (!Files.exists(dataFile)) { // If "file name" does NOT exist, create the FILE
            Files.createFile(dataFile);
        }
//        Path Files.write(Path dataDirectory, List<String> lines[, StandardOpenOption option])

        List<String> contactsList = Arrays.asList("Ruben", "Anthony", "Sugar");
        Path filepath = Paths.get("contactsManager", "contacts.txt");
        Files.write(dataDirectory, contactsList);
    }
}
