package contacts;

import contacts.form.Contact;
import contacts.form.Organization;
import contacts.form.Person;

import java.util.ArrayList;

public class PhoneBook {

    private static long currentId = 1L;
    private static ArrayList<Contact> contactsList = new ArrayList<>();

    public static ArrayList<Contact> getContactsList() {
        return contactsList;
    }

    public static void add(Contact contact) {
        contactsList.add(contact);
    }

    public static int size() {
        return contactsList.size();
    }

    public static Contact get(int index) {
        return contactsList.get(index);
    }

    public static void remove(int index) {
        contactsList.remove(index);
    }

    public static void set(int index, Contact contact) {
        contactsList.set(index, contact);
    }

}
