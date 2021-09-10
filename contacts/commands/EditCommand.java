package contacts.commands;

import contacts.PhoneBook;
import contacts.form.Contact;
import contacts.form.Organization;
import contacts.form.Person;

import java.time.LocalDateTime;
import java.util.Scanner;

public class EditCommand implements Command {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void execute() {
        if (PhoneBook.size() == 0) {
            System.out.println("No records to edit!");
        } else {
            Scanner sc = new Scanner(System.in);
            new DisplayListCommand().execute();
            System.out.print("Enter index to show info: ");
            int recordNumber = Integer.valueOf(sc.nextLine()) - 1;
            Contact contactToUpdate = PhoneBook.get(recordNumber);
            if (contactToUpdate.isPerson()) {
                editPerson((Person) contactToUpdate, recordNumber);
            } else {
                editOrganization((Organization) contactToUpdate, recordNumber);
            }
        }
    }

    private void editPerson(Person contactToUpdate, int recordNumber) {
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String option = sc.nextLine();
        switch (option) {
            case "name":
                System.out.print("Enter name: ");
                contactToUpdate.setName(sc.nextLine());
                saveContactEdit(contactToUpdate, recordNumber);
                break;
            case "surname":
                System.out.print("Enter surname: ");
                contactToUpdate.setSurname(sc.nextLine());
                saveContactEdit(contactToUpdate, recordNumber);
                break;
            case "birth":
                System.out.print("Enter birth date: ");
                contactToUpdate.setBirthDate(sc.nextLine());
                saveContactEdit(contactToUpdate, recordNumber);
                break;
            case "gender":
                System.out.print("Enter gender: ");
                String gender = sc.nextLine();
                if (gender != null & (gender.equals("M") || gender.equals("F"))) {
                    contactToUpdate.setGender(gender);
                } else {
                    System.out.println("Bad gender!");
                }
                saveContactEdit(contactToUpdate, recordNumber);
                break;
            case "number":
                System.out.print("Enter number: ");
                contactToUpdate.setPhoneNumber(sc.nextLine());
                saveContactEdit(contactToUpdate, recordNumber);
                break;
            default:
                System.out.println("Wrong input!");
                break;
        }
    }

    private void saveContactEdit(Person contactToUpdate, int recordNumber) {
        contactToUpdate.setEditDateTime(LocalDateTime.now());
        PhoneBook.set(recordNumber, contactToUpdate);
        System.out.println("The record person updated!");
    }

    private void editOrganization(Organization contactToUpdate, int recordNumber) {
        System.out.print("Select a field (name, address, number):");
        String option = sc.nextLine();
        switch (option) {
            case "name":
                System.out.print("Enter name: ");
                contactToUpdate.setName(sc.nextLine());
                saveContactEdit(contactToUpdate, recordNumber);
                break;
            case "address":
                System.out.print("Enter surname: ");
                contactToUpdate.setAddress(sc.nextLine());
                saveContactEdit(contactToUpdate, recordNumber);
                break;
            case "number":
                System.out.print("Enter number: ");
                contactToUpdate.setPhoneNumber(sc.nextLine());
                saveContactEdit(contactToUpdate, recordNumber);
                break;
            default:
                System.out.println("Wrong input!");
                break;
        }
    }

    private void saveContactEdit(Organization contactToUpdate, int recordNumber) {
        contactToUpdate.setEditDateTime(LocalDateTime.now());
        PhoneBook.set(recordNumber, contactToUpdate);
        System.out.println("The record organization updated!");
    }
}
