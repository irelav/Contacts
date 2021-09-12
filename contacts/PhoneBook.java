package contacts;

import contacts.form.Contact;

import java.io.*;
import java.util.ArrayList;

public class PhoneBook implements Serializable {
    private final static String fileName = "phonebook.db";
    private static ArrayList<Contact> contactsList;
    private static final long serialVersionUID = 1L;

    public static String getFilename() {
        return fileName;
    }

    public static ArrayList<Contact> getContactsList() {
        return contactsList;
    }

    public static void add(Contact contact) throws IOException {
        contactsList.add(contact);
        serialize(contactsList, fileName);
        System.out.print("Phonebook updated.\n");
    }

    public static int size() {
        return contactsList.size();
    }

    public static Contact get(int index) {
        return contactsList.get(index);
    }

    public static void remove(int index) throws IOException {
        contactsList.remove(index);
        serialize(contactsList, fileName);
        System.out.print("Phonebook updated.\n");
    }

    public static void set(int index, Contact contact) throws IOException {
        contactsList.set(index, contact);
        serialize(contactsList, fileName);
        System.out.print("Phonebook updated.\n");
    }

    public static void run() {
        System.out.print("Loaded phonebook.db\n");
        try {
            contactsList = deserialize();
        } catch (Exception e) {
            contactsList = new ArrayList<>();
        }
    }

    public static void serialize(ArrayList<Contact> phoneBook, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(phoneBook);
        oos.close();
    }

    public static ArrayList<Contact> deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object result = ois.readObject();
        ois.close();
        if (result instanceof ArrayList<?>) {
            return (ArrayList<Contact>) result;
        } else {
            return new ArrayList<>();
        }
    }
}
