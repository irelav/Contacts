package contacts.commands;

import contacts.PhoneBook;
import contacts.form.Organization;
import contacts.form.Person;

import java.time.LocalDateTime;
import java.util.Scanner;

public class EditCommand implements Command {
    @Override
    public void execute() {
        if (PhoneBook.size() == 0) {
            System.out.println("No records to edit!");
        } else {
            Scanner sc = new Scanner(System.in);
            new DisplayListCommand().execute();
            System.out.print("Enter index to show info: ");
            int recordNumber = Integer.valueOf(sc.nextLine()) - 1;
            if (PhoneBook.getContactsList().get(recordNumber).isPerson()) {
                Person personToUpdate = PhoneBook.getPerson(recordNumber);
                System.out.print("Select a field (name, surname, birth, gender, number): ");
                String option = sc.nextLine();
                switch (option) {
                    case "name":
                        System.out.print("Enter name: ");
                        String newName = sc.nextLine();
                        personToUpdate.setName(newName);
                        personToUpdate.setEditDateTime(LocalDateTime.now());
                        PhoneBook.setPerson(recordNumber, personToUpdate);
                        System.out.println("The record updated!");
                        break;
                    case "surname":
                        System.out.print("Enter surname: ");
                        String newSurname = sc.nextLine();
                        personToUpdate.setSurname(newSurname);
                        personToUpdate.setEditDateTime(LocalDateTime.now());
                        PhoneBook.setPerson(recordNumber, personToUpdate);
                        System.out.println("The record updated!");
                        break;
                    case "birth":
                        System.out.print("Enter birth date: ");
                        String newBirthDate = sc.nextLine();
                        personToUpdate.setBirthDate(newBirthDate);
                        personToUpdate.setEditDateTime(LocalDateTime.now());
                        PhoneBook.setPerson(recordNumber, personToUpdate);
                        System.out.println("The record updated!");
                        break;
                    case "gender":
                        System.out.print("Enter gender: ");
                        String newGender = sc.nextLine();
                        personToUpdate.setGender(newGender);
                        personToUpdate.setEditDateTime(LocalDateTime.now());
                        PhoneBook.setPerson(recordNumber, personToUpdate);
                        System.out.println("The record updated!");
                        break;
                    case "number":
                        System.out.print("Enter number: ");
                        String newNumber = sc.nextLine();
                        personToUpdate.setPhoneNumber(newNumber);
                        personToUpdate.setEditDateTime(LocalDateTime.now());
                        PhoneBook.setPerson(recordNumber, personToUpdate);
                        System.out.println("The record updated!");
                        break;
                }
            } else {
                Organization organizationToUpdate = PhoneBook.getOrganization(recordNumber);
                System.out.print("Select a field (name, address, number):");
                String option = sc.nextLine();
                switch (option) {
                    case "name":
                        System.out.print("Enter name: ");
                        String newName = sc.nextLine();
                        organizationToUpdate.setName(newName);
                        organizationToUpdate.setEditDateTime(LocalDateTime.now());
                        PhoneBook.setOrganization(recordNumber, organizationToUpdate);
                        System.out.println("The record updated!");
                        break;
                    case "address":
                        System.out.print("Enter address: ");
                        String newAddress = sc.nextLine();
                        organizationToUpdate.setAddress(newAddress);
                        organizationToUpdate.setEditDateTime(LocalDateTime.now());
                        PhoneBook.setOrganization(recordNumber, organizationToUpdate);
                        System.out.println("The record updated!");
                        break;
                    case "number":
                        System.out.print("Enter number: ");
                        String newNumber = sc.nextLine();
                        organizationToUpdate.setPhoneNumber(newNumber);
                        organizationToUpdate.setEditDateTime(LocalDateTime.now());
                        PhoneBook.setOrganization(recordNumber, organizationToUpdate);
                        System.out.println("The record updated!");
                        break;
                }
            }
        }
    }
}
