import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.*;

import static java.nio.file.Files.*;

public class Contacts {

    public static void main(String[] args) throws IOException {
        String directory = "contactsManager"; // Declares directory name
        String filename = "contacts.txt"; // Declares file name

        Path dataPath = Paths.get(directory); // Main path
        Path dataDirectory = Paths.get(directory, filename); // Main directory


//      ESTABLISHES FILE AND DIRECTORY EXISTS
        if (Files.notExists(dataDirectory)) { // If "file name" does NOT exist within directory, create the DIRECTORY...
            Files.createDirectories(dataDirectory);
        }
        if (!Files.exists(dataPath)) { // If "file name" does NOT exist, create the FILE
            Files.createFile(dataPath);
        }
        List<String> lines = new ArrayList<>();
        Files.write(dataDirectory, lines);
        lines.add("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");


    }
}
