package contacts.commands;

import contacts.PhoneBook;
import contacts.form.Organization;

import java.util.Scanner;

public class AddOrganizationCommand implements Command {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name = sc.nextLine();
        System.out.print("Enter the address: ");
        String address = sc.nextLine();
        System.out.print("Enter the number: ");
        String number = sc.nextLine();
        PhoneBook.addOrganization(new Organization(false, name, address, number));
        System.out.println("The record added.");
    }
}
