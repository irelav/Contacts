package contacts.commands;

import contacts.Menu;
import contacts.PhoneBook;
import contacts.form.Contact;

import java.util.Scanner;

public class DisplayListCommand implements Command {
    private static Scanner sc = new Scanner(System.in);

    @Override
    public void execute(String action) {
        for (int i = 0; i < PhoneBook.size(); i++) {
            Contact contact = PhoneBook.get(i);
            System.out.printf("%d. %s %s%n", i + 1,
                    contact.getFullName(), contact.getPhoneNumber());
        }
        System.out.print("\n[list] Enter action ([number], back): ");
        String input = sc.nextLine();
        try {
            if (input.equals("back")) {
                new Menu();
            } else if (Integer.parseInt(input) <= PhoneBook.size()) {
                new DisplayInfoCommand().execute(input);
            }
        } catch (Exception e) {
            System.out.print("Wrong input!");
        }
    }
}
