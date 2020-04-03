import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.*;
import java.util.Scanner;

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
        lines.add("Name" + " | " + "Phone Number\n" +
                "---------------\n" +
                "Jack Blank | 1231231234\n" +
                "Jane Doe | 2342342345\n" +
                "Sam Space | 3453453456\n");
        Files.write(dataDirectory, lines);

        Scanner sc = new Scanner(System.in);

        System.out.println("\n\t1. View contacts.\n" +
                           "\t2. Add a new contact.\n" +
                           "\t3. Search a contact by name.\n" +
                           "\t4. Delete an existing contact.\n" +
                           "\t5. Exit.\n" + //Save to contacts.txt on Exit (and Discard changes)
                           "\t6. Save Contacts.\n" +
                           "\tEnter an option (1, 2, 3, 4, 5, or 6):");

        int i = sc.nextInt();

        if(i == 1){
            viewContacts(dataDirectory);
        } else if(i == 6){
            writeContacts(lines, dataDirectory);
        }
    }
    // OPTION 1
    public static void viewContacts(Path dataDirectory) throws IOException {
        System.out.println("\n" + Files.readAllLines(dataDirectory));
    }
    // OPTION 6
    public static void writeContacts(List<String> contacts, Path dataDirectory) throws IOException {
        Files.write(dataDirectory, contacts);
    }
}
