package contacts.commands;

import contacts.PhoneBook;

import java.util.Scanner;

public class RemoveCommand implements Command {
    @Override
    public void execute() {
        if (PhoneBook.size() == 0) {
            System.out.println("No records to remove!");
        } else {
            Scanner sc = new Scanner(System.in);
            new DisplayListCommand().execute();
            System.out.print("Select a record: ");
            int recordNumber = sc.nextInt();
            PhoneBook.remove(recordNumber - 1);
        }
    }
}
