package contacts.form;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Contact {
    protected boolean isPerson;
    protected String name;
    protected String phoneNumber;
    protected LocalDateTime creationDateTime;
    protected LocalDateTime editDateTime;

    public Contact (Boolean isPerson, String name, String phoneNumber) {
        this.isPerson = isPerson;
        this.name = name;
        setPhoneNumber(phoneNumber);
        this.creationDateTime = LocalDateTime.now();
        this.editDateTime = LocalDateTime.now();
    }

    public void setPerson(boolean person) {
        isPerson = person;
    }

    public boolean isPerson() {
        return isPerson;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "[no number]";
            System.out.println("Wrong number format!");
        }

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean hasNumber() {
        return phoneNumber != null && !phoneNumber.equals("[no number]");
    }

    public boolean checkNumberFormat(String phoneNumber) {
        String regex1 = "^\\+?[a-zA-Z0-9]+(\\s|-)*([a-zA-Z0-9]{2,}+|(\\s|-)[a-zA-Z0-9]{2,}+)*$";
        String regex2 = "^\\+?([\\(]([a-zA-Z0-9]+)[\\)])((\\s|-)*)([a-zA-Z0-9]{2,}+|(\\s|-)[a-zA-Z0-9]{2,}+)*$";
        String regex3 = "^\\+?([a-zA-Z0-9]+)((\\s|-)*([\\(][a-zA-Z0-9]{2,}+[\\)])|(\\s|-)[a-zA-Z0-9]{2,}+)*$";
        boolean correctPhoneNumberFormat = phoneNumber.matches(regex1) ||
                phoneNumber.matches(regex2) || phoneNumber.matches(regex3);

        return correctPhoneNumberFormat;
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        boolean personHasNumber = false;
        if (!phoneNumber.isEmpty()) {
            personHasNumber = checkNumberFormat(phoneNumber);
        }
        return personHasNumber;
    }
    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getCreationDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String creationDateTime = this.creationDateTime.format(formatter);
        return creationDateTime;
    }

    public void setEditDateTime(LocalDateTime editDateTime) {
        this.editDateTime = editDateTime;
    }

    public String getEditDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String editDateTime = this.editDateTime.format(formatter);
        return editDateTime;
    }
}
