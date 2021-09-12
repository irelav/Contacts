package contacts.commands;

import contacts.PhoneBook;

import java.io.IOException;

public class RemoveCommand implements Command {
    @Override
    public void execute(String action) throws IOException {
        if (PhoneBook.size() == 0) {
            System.out.println("No records to remove!");
        } else {
            int input = Integer.parseInt(action) - 1;
            PhoneBook.remove(input);
        }
    }
}
