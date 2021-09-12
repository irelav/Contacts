package contacts.commands;

import contacts.Menu;
import contacts.PhoneBook;

import java.util.Scanner;

public class DisplayInfoCommand implements Command {
    private static Scanner sc = new Scanner(System.in);

    @Override
    public void execute(String action) {
        System.out.println(PhoneBook.get(Integer.parseInt(action) - 1).toString());
        System.out.print("\n[record] Enter action (edit, delete, menu): ");
        String input = sc.nextLine();
        try {
            if (input.equals("edit")) {
                new EditCommand().execute(action);
            } else if (input.equals("delete")) {
                new RemoveCommand().execute(action);
            } else if (input.equals("menu")) {
                 new Menu();
            }
        } catch (Exception e) {
            System.out.print("Wrong input!");
        }
    }
}
