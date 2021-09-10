package contacts.commands;

import contacts.PhoneBook;

import java.util.Scanner;

public class DisplayInfoCommand implements Command{
    @Override
    public void execute() {
        new DisplayListCommand().execute();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index to show info: ");
        int recordNumber = Integer.valueOf(sc.nextLine()) - 1;
        System.out.println(PhoneBook.get(recordNumber).toString());
    }
}
