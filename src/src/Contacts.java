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

//      ARRAY

        List<String> contactsArray = new ArrayList<>();

//        Contacts contact = new Contacts("John");
//        contactsArray.add(contact);
//        contact = new Contacts("Jane");
//        contactsArray.add(contact);
//        contact = new Contacts("Joe");
//        contactsArray.add(contact);
//        System.out.println("ArrayList before: " + contact);
//
//        Iterator<Contacts> itr = contactsArray.iterator();
//        Scanner scannerValue = new Scanner(System.in);
//        System.out.println("What do you want to delete?");
//        String userInput = scannerValue.nextLine();
//
//        while (itr.hasNext()) {
//            Contacts contactItr = itr.next();
//            if (contactItr.equals(userInput)) {
//                contactsArray.remove(contact);
//            }
//        }
//
//        System.out.println("ArrayList: new array list " + contactsArray);

        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("\n\t1. View contacts.\n" +
                    "\t2. Add a new contact.\n" +
                    "\t3. Search a contact by name.\n" +
                    "\t4. Delete an existing contact.\n" +
                    "\t5. Save Contacts.\n" +
                    "\t6. Exit.\n" + //Save to contacts.txt on Exit (and Discard changes)
                    "\tEnter an option (1, 2, 3, 4, 5, or 6):");

            int i = sc.nextInt();

            if (i == 1) {
                viewContacts(dataDirectory);
            } else if (i == 2) {
                contactsArray.add(addContact(contactsArray, dataDirectory));
                Files.write(dataDirectory, contactsArray, StandardOpenOption.APPEND);
            } else if (i == 3) {

            } else if (i == 4) {
                contactsArray.remove(removeContact(contactsArray, dataDirectory));
                Files.write(dataDirectory, contactsArray);
            } else if (i == 5) {
                Files.write(dataDirectory, contactsArray);
            } else if (i == 6) {

            }
        } while (true);
    }

//  END OF MAIN ---------------------------------

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String entry;

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getEntry() {
        return entry;
    }

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

    public Contacts(String entry) {
        this.entry = entry;

    }

    // OPTION 1

    public static void viewContacts(Path dataDirectory) throws IOException {
        System.out.println("\n" + Files.readAllLines(dataDirectory));
    }

    // OPTION 2

    public static String addContact(List<String> contactsArray, Path dataDirectory) throws IOException {
        System.out.println("Enter a new name and phone number.");
        Scanner input = new Scanner(System.in);
        String newEntry = input.nextLine();
        Contacts contact = new Contacts(newEntry);
        return newEntry;
    }

    // OPTION 3


    // OPTION 4

    public static String removeContact(List<String> contactsArray, Path dataDirectory) throws IOException {
        System.out.println("Remove a name and phone number.");
        Scanner input = new Scanner(System.in);
        String newEntry = input.nextLine();
        Contacts contact = new Contacts(newEntry);
        return newEntry;
    }

    // OPTION 5

    public void saveContacts(List<String> contactsArray, Path dataDirectory) throws IOException {
        Files.write(dataDirectory, contactsArray);
    }
}
