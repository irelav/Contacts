package contacts.commands;

import contacts.PhoneBook;
import contacts.form.Organization;
import contacts.form.Person;

import java.io.IOException;
import java.util.Scanner;

public class AddCommand implements Command {
    private static Scanner sc = new Scanner(System.in);

    @Override
    public void execute(String action) throws IOException {
        System.out.print("Enter the type (person, organization): ");
        String type = sc.nextLine();
        String name, surname, birthDate, gender, address, phoneNumber;
        if (type.equalsIgnoreCase("person")) {
            System.out.print("Enter the name: ");
            name = sc.nextLine();
            System.out.print("Enter the surname: ");
            surname = sc.nextLine();
            System.out.print("Enter the birth date: ");
            birthDate = sc.nextLine();
            System.out.print("Enter the gender (M, F): ");
            gender = sc.nextLine();
            System.out.print("Enter the number: ");
            phoneNumber = sc.nextLine();
            PhoneBook.add(new Person(name, surname, birthDate, gender, phoneNumber));
            System.out.print("The record added.\n");
        } else if (type.equalsIgnoreCase("organization")) {
            System.out.print("Enter the name: ");
            name = sc.nextLine();
            System.out.print("Enter the address: ");
            address = sc.nextLine();
            System.out.print("Enter the number: ");
            phoneNumber = sc.nextLine();
            PhoneBook.add(new Organization(name, address, phoneNumber));
            System.out.print("The record added.\n");
        } else {
            System.out.print("Wrong input!");
        }
    }
}
