package contacts.commands;

import contacts.Menu;
import contacts.PhoneBook;
import contacts.form.Contact;
import contacts.form.Organization;
import contacts.form.Person;

import java.util.*;
import java.util.regex.Pattern;

public class SearchCommand implements Command {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void execute(String action) {
        System.out.print("Enter search query: ");
        String search = sc.nextLine();
        HashMap<String, Integer> result = new HashMap<>();
        int counter = 0;
        for (Contact contact : PhoneBook.getContactsList()) {
            if (contact instanceof Person) {
                if (Pattern.compile(Pattern.quote(search),
                        Pattern.CASE_INSENSITIVE).matcher(contact.getFullName()).find()) {
                    result.put(contact.getFullName(), counter);
                } else if (Pattern.compile(Pattern.quote(search),
                        Pattern.CASE_INSENSITIVE).matcher(contact.getPhoneNumber()).find()) {
                    result.put(contact.getPhoneNumber(), counter);
                } else if (Pattern.compile(Pattern.quote(search),
                        Pattern.CASE_INSENSITIVE).matcher(((Person) contact).getBirthDate()).find()) {
                    result.put(((Person) contact).getBirthDate(), counter);
                }
            } else if (contact instanceof Organization) {
                if (Pattern.compile(Pattern.quote(search),
                        Pattern.CASE_INSENSITIVE).matcher(contact.getFullName()).find()) {
                    result.put(contact.getFullName(), counter);
                } else if (Pattern.compile(Pattern.quote(search),
                        Pattern.CASE_INSENSITIVE).matcher(contact.getPhoneNumber()).find()) {
                    result.put(contact.getPhoneNumber(), counter);
                } else if (Pattern.compile(Pattern.quote(search),
                        Pattern.CASE_INSENSITIVE).matcher(((Organization) contact).getAddress()).find()) {
                    result.put(((Organization) contact).getAddress(), counter);
                }
            }
            counter++;
        }

        if (result.size() > 1) {
            System.out.printf("Found %d results\n", result.size());
        } else if (result.size() == 1) {
            System.out.printf("Found %d result\n", result.size());
        } else {
            result.size();
            System.out.print("No results found\n");
        }

        counter = 1;
        for (String i : result.keySet()) {
            if (PhoneBook.get(result.get(i)).getFullName().equals(i)) {
                System.out.println(counter + ". " + PhoneBook.get(result.get(i)).getFullName());
            } else {
                System.out.println(counter + ". " + PhoneBook.get(result.get(i)).getFullName() + " " + i);
            }
            counter++;
        }

        System.out.print("\n[search] Enter action ([number], back, again): ");
        String option = sc.nextLine();
        try {
            if (option.equals("back")) {
                new Menu();
            } else if (option.equals("again")) {
                new SearchCommand().execute(option);
            } else if (Integer.parseInt(option) <= result.size()) {
                counter = 1;
                for (String i : result.keySet()) {
                    if (counter == Integer.parseInt(option)) {
                        new DisplayInfoCommand().execute(String.valueOf(result.get(i) + 1));
                    }
                    counter++;
                }
            }
        } catch (Exception e) {
            System.out.print("Wrong input!");
        }
    }
}
