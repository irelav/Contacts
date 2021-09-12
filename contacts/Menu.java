package contacts;

import contacts.commands.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

    public static void displayMenu() {
        HashMap<String, Command> commands = new HashMap<>();
        commands.put("add", new AddCommand());
        commands.put("list", new DisplayListCommand());
        commands.put("search", new SearchCommand());
        commands.put("count", new CountCommand());
        Scanner sc = new Scanner(System.in);
        boolean exitMenu = false;
        while (!exitMenu) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            String action = sc.nextLine().toLowerCase(Locale.ROOT);
            try {
                if (action.equals("exit")) {
                    exitMenu = true;
                    try {
                        PhoneBook.serialize(PhoneBook.getContactsList(), PhoneBook.getFilename());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    PhoneBook.deserialize();
                    Command command = commands.get(action);
                    command.execute(action);
                }
                System.out.println();
            } catch (Exception e) {
                System.out.print("Wrong input!");
                System.out.println(e.getMessage());
            }
        }
    }
}
