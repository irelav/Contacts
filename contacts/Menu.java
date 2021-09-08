package contacts;

import contacts.commands.*;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    public static void displayMenu() {
        HashMap<String, Command> commands = new HashMap<>();
        commands.put("add", new AddPersonCommand());
        commands.put("edit", new EditCommand());
        commands.put("remove", new RemoveCommand());
        commands.put("list", new DisplayListCommand());
        commands.put("info", new DisplayInfoCommand());
        commands.put("count", new CountCommand());
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
            String action = sc.nextLine();
            if (action.equals("exit")) {
                exit = true;
            } else if (action.equals("add")) {
                System.out.print("Enter the type (person, organization): ");
                String addValue = sc.nextLine();
                if (addValue.equals("person")) {
                    Command command = new AddPersonCommand();
                    command.execute();
                } else if (addValue.equals("organization")) {
                    Command command = new AddOrganizationCommand();
                    command.execute();
                }
            } else if (action.equals("info")) {
                Command command1 = new DisplayListCommand();
                command1.execute();
                Command command2 = new DisplayInfoCommand();
                command2.execute();
            } else {
                Command command = commands.get(action);
                command.execute();
            }
            System.out.println();
        } while (!exit);
    }
}
