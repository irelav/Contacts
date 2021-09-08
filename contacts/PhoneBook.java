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

    public static long getNextId() {
        return currentId++;
    }

    public static void addPerson(Person contact) {
        contactsList.add(contact);
    }

    public static void addOrganization(Organization contact) {
        contactsList.add(contact);
    }

    public static int size() {
        return contactsList.size();
    }

    public static Person getPerson(int index) {
        return (Person) contactsList.get(index);
    }

    public static Organization getOrganization(int index) {
        return (Organization) contactsList.get(index);
    }

    public static void remove(int index) {
        contactsList.remove(index);
    }

    public static void setPerson(int index, Person contact) {
        contactsList.set(index, contact);
    }
    public static void setOrganization(int index, Organization contact) {
        contactsList.set(index, contact);
    }

}
