package contacts.commands;

import contacts.PhoneBook;
import contacts.form.Contact;

public class DisplayListCommand implements Command {
    @Override
    public void execute() {
        for (int i = 0; i < PhoneBook.size(); i++) {
            Contact contact = PhoneBook.get(i);
            System.out.println(String.format("%d. %s %s", i + 1,
                    contact.getFullName(), contact.getPhoneNumber()));
        }
    }
}
