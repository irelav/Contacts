package contacts.commands;

import contacts.PhoneBook;
import contacts.form.Person;

import java.util.Scanner;

public class AddPersonCommand implements Command {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name = sc.nextLine();
        System.out.print("Enter the surname: ");
        String surname = sc.nextLine();
        System.out.print("Enter the birth date: ");
        String birthDate = sc.nextLine();
        System.out.print("Enter the gender (M, F): ");
        String gender = sc.nextLine();
        System.out.print("Enter the number: ");
        String number = sc.nextLine();
        PhoneBook.addPerson(new Person(true, name, surname, birthDate, gender, number));
        System.out.println("The record added.");
    }
}
