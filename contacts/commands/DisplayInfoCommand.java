package contacts.commands;

import contacts.PhoneBook;

import java.util.Scanner;

public class DisplayInfoCommand implements Command{
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index to show info: ");
        int index = sc.nextInt();
        index--;
        if (PhoneBook.getContactsList().get(index).isPerson()) {
            System.out.println(String.format("Name: %s%n" +
                            "Surname: %s%n" +
                            "Birth date: %s%n" +
                            "Gender: %s%n" +
                            "Number: %s%n" +
                            "Time created: %s%n" +
                            "Time last edit: %s",
                    PhoneBook.getPerson(index).getName(),
                    PhoneBook.getPerson(index).getSurname(),
                    PhoneBook.getPerson(index).getBirthDate(),
                    PhoneBook.getPerson(index).getGender(),
                    PhoneBook.getPerson(index).getPhoneNumber(),
                    PhoneBook.getPerson(index).getCreationDateTime(),
                    PhoneBook.getPerson(index).getEditDateTime()));
        } else {
            System.out.println(String.format("Organization name: %s %n" +
                            "Address: %s%n" +
                            "Number: %s%n" +
                            "Time created: %s%n" +
                            "Time last edit: %s%n",
                    PhoneBook.getOrganization(index).getName(),
                    PhoneBook.getOrganization(index).getAddress(),
                    PhoneBook.getOrganization(index).getPhoneNumber(),
                    PhoneBook.getOrganization(index).getCreationDateTime(),
                    PhoneBook.getOrganization(index).getEditDateTime()));
        }
    }
}
