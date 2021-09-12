package contacts.commands;

import contacts.PhoneBook;

public class CountCommand implements Command {
    @Override
    public void execute(String action) {
        System.out.printf("The Phone Book has %d records.\n", PhoneBook.size());
    }
}
