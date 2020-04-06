import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Contacts {

    public static void main(String[] args) throws IOException {
        String directory = "contactsManager"; // Declares directory name
        String filename = "contacts.txt"; // Declares file name

        Path dataPath = Paths.get(directory); // Main path
        Path dataDirectory = Paths.get(directory, filename); // Main directory

        searchContact();

//      ESTABLISHES FILE AND DIRECTORY EXISTS
        if (Files.notExists(dataDirectory)) { // If "file name" does NOT exist within directory, create the DIRECTORY...
            Files.createDirectories(dataDirectory);
        }
        if (!Files.exists(dataPath)) { // If "file name" does NOT exist, create the FILE
            Files.createFile(dataPath);
        }
        List<Contacts> contacts = new ArrayList<>();
        Contacts contact = new Contacts("John", "Doe", "0000000000");
        contacts.add(contact);
        contact = new Contacts("Jane", "Doe", "0000000000");
        contacts.add(contact);
        contact = new Contacts("Jake", "Doe", "0000000000");
        contacts.add(contact);

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
        }else if (i == 2){
            contacts.add(addContact());
        }else if (i == 3){
//            contacts.add(addContact()); <-------------
        }else if(i == 6){
//            TODO add to save file
        }
    }
//  END OF MAIN

    private String firstName;
    private String lastName;
    private String phoneNumber;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
//  CONSTRUCTOR
    public Contacts(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // HASH MAP
    static HashMap<String, String> contactsList = new HashMap<>(); // Define hash map

    // OPTION 1
    public static void viewContacts(Path dataDirectory) throws IOException {
        System.out.println("\n" + Files.readAllLines(dataDirectory));
    }

    // OPTION 2

    public static Contacts addContact() {
        System.out.println("Enter a new contact?");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter First Name: ");
        String newFirstName = input.nextLine();
        System.out.println("Please enter Last Name: ");
        String newLastName = input.nextLine();
        System.out.println("Please enter Phone Number: ");
        String newPhoneNumber = input.nextLine();
        Contacts contact = new Contacts(newFirstName, newLastName, newPhoneNumber);
        return contact;
    }

    // OPTION 3
    public static Map<String, String> searchContact() {
        System.out.println("\t\nEnter a contact to search for (e.g. name or number): ");
        Scanner input = new Scanner(System.in);
        contactsList.get("Ruben");
        contactsList.getOrDefault("Sorry", "No results found!");
        return contactsList;
    }

    // OPTION 6
    public void saveContacts(List<String> contacts, Path dataDirectory) throws IOException {
        Files.write(dataDirectory, contacts);
    }
}
