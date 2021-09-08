package contacts.commands;

import contacts.PhoneBook;

public class CountCommand implements Command {
    @Override
    public void execute() {
        System.out.println(String.format("The Phone Book has %d records.", PhoneBook.size()));
    }
}
