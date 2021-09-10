package contacts.commands;

import contacts.PhoneBook;
import contacts.form.Organization;
import contacts.form.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AddCommand implements Command {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the type (person, organization): ");
        String type = sc.nextLine();
        String name, surname, birthDate, gender, address, phoneNumber;
        if (type.equals("person")) {
            System.out.print("Enter the name: ");
            name = sc.nextLine();
            System.out.print("Enter the surname: ");
            surname = sc.nextLine();
            System.out.print("Enter the birth date: ");
            birthDate = sc.nextLine();
            if (birthDate.isEmpty()) {
                System.out.println("Bad birth date!");
            }
            System.out.print("Enter the gender (M, F): ");
            gender = sc.nextLine();
            if (!(gender != null & (gender.equals("M") || gender.equals("F")))) {
                gender = "[no data]";
                System.out.println("Bad gender!");
            }
            System.out.print("Enter the number: ");
            phoneNumber = sc.nextLine();
            PhoneBook.add(new Person(name, surname, birthDate, gender, phoneNumber));
            System.out.println("The record added.");
        } else if (type.equals("organization")) {
            System.out.print("Enter the name: ");
            name = sc.nextLine();
            System.out.print("Enter the address: ");
            address = sc.nextLine();
            System.out.print("Enter the number: ");
            phoneNumber = sc.nextLine();
            PhoneBook.add(new Organization(name, address, phoneNumber));
            System.out.println("The record added.");
        } else {
            System.out.println("Wrong input!");
        }
    }
}
