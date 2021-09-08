package contacts.commands;

import contacts.PhoneBook;

public class DisplayListCommand implements Command {
    @Override
    public void execute() {
        for (int i = 0; i < PhoneBook.size(); i++) {
            if (PhoneBook.getContactsList().get(i).isPerson()) {
                System.out.println(String.format("%d. %s %s, %s", i + 1,
                        PhoneBook.getPerson(i).getName(),
                        PhoneBook.getPerson(i).getSurname(),
                        PhoneBook.getPerson(i).getPhoneNumber()));
            } else {
                System.out.println(String.format("%d. %s %s, %s", i + 1,
                        PhoneBook.getOrganization(i).getName(),
                        PhoneBook.getOrganization(i).getAddress(),
                        PhoneBook.getOrganization(i).getPhoneNumber()));
            }
        }
    }
}
