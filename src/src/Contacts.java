import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Contacts {

    public static void main(String[] args) throws IOException {
        String directory = "contactsManager"; // Declares directory name
        String filename = "contacts.txt"; // Declares file name

        Path dataPath = Paths.get(directory); // Main path
        Path dataDirectory = Paths.get(directory, filename); // Main directory to file

//      ESTABLISHES FILE AND DIRECTORY EXISTS

        if (Files.notExists(dataDirectory)) { // If "file name" does NOT exist within directory, create the DIRECTORY...
            Files.createDirectories(dataDirectory);
        }
        if (!Files.exists(dataPath)) { // If "file name" does NOT exist, create the FILE
            Files.createFile(dataPath);
        }

//      CREATES CONTACTS AS ARRAY LIST OF STRINGS

        List<String> contactsArray = new ArrayList<>();
        contactsArray = Files.readAllLines(dataDirectory);

//      USER MAIN MENU + OPTIONS

        Scanner sc = new Scanner(System.in);
        boolean keepGoing = true;
        do {

            System.out.println("\n\t1. View contacts.\n" +
                    "\t2. Add a new contact.\n" +
                    "\t3. Search a contact by name.\n" +
                    "\t4. Delete an existing contact.\n" +
                    "\t5. Exit.\n" + //Save to contacts.txt on Exit (and Discard changes)
                    "\tEnter an option (1, 2, 3, 4, 5, or 6):");

            int i = sc.nextInt();

            if (i == 1) {
                viewContacts(dataDirectory);
            } else if (i == 2) {
                contactsArray.add(addContact(contactsArray, dataDirectory));
                Files.write(dataDirectory, contactsArray, StandardOpenOption.APPEND);
            } else if (i == 3) {
                // Enter search by name method here...
            } else if (i == 4) {
                contactsArray.remove(removeContact(contactsArray, dataDirectory));
                Files.write(dataDirectory, contactsArray);
            } else if (i == 5) {
                keepGoing = false;
                exitContacts(contactsArray, dataDirectory);
            }
        } while (keepGoing);
    }

//  END OF MAIN ---------------------------------

    private String entry;

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getEntry() {
        return entry;
    }

    //  CONTACT CONSTRUCTOR

    public Contacts(String entry) {
        this.entry = entry;
    }

    // OPTION 1: VIEW CONTACTS

    public static void viewContacts(Path dataDirectory) throws IOException {
        System.out.println("\n" + Files.readAllLines(dataDirectory));
    }

    // OPTION 2: ADD A CONTACT

    public static String addContact(List<String> contactsArray, Path dataDirectory) throws IOException {
        System.out.println("Enter a new name and phone number.");
        Scanner input = new Scanner(System.in);
        String newEntry = input.nextLine();
        Contacts contact = new Contacts(newEntry);
        return newEntry;
    }

    // OPTION 3: SEARCH BY NAME


    // OPTION 4: DELETE A CONTACT

    public static String removeContact(List<String> contactsArray, Path dataDirectory) throws IOException {
        System.out.println("Remove a name and phone number.");
        Scanner input = new Scanner(System.in);
        String newEntry = input.nextLine();
        Contacts contact = new Contacts(newEntry);
        return newEntry;
    }

    // OPTION 5: EXIT

    public static void exitContacts(List<String> contactsArray, Path dataDirectory) throws IOException {
//        Files.write(dataDirectory, contactsArray);
        System.out.println("\tSession data has been saved. Goodbye!");
    }
}
