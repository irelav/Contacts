package contacts;

import contacts.commands.*;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    public static void displayMenu() {
        HashMap<String, Command> commands = new HashMap<>();
        commands.put("add", new AddCommand());
        commands.put("edit", new EditCommand());
        commands.put("remove", new RemoveCommand());
        commands.put("info", new DisplayInfoCommand());
        commands.put("count", new CountCommand());
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
            String action = sc.nextLine();
            if (action.equals("exit")) {
                exit = true;
            } else {
                Command command = commands.get(action);
                command.execute();
            }
            System.out.println();
        } while (!exit);
    }
}
