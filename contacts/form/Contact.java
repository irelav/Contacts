package contacts.form;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Contact implements Serializable {
    protected String name;
    protected String phoneNumber;
    protected LocalDateTime creationDateTime;
    protected LocalDateTime editDateTime;
    private static final long serialVersionUID = 372626319979007907L;

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public Contact (String name, String phoneNumber) {
        this.name = name;
        setPhoneNumber(phoneNumber);
        this.creationDateTime = LocalDateTime.now();
        this.editDateTime = LocalDateTime.now();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "[no number]";
            System.out.println("Wrong number format");
        }
    }

    public boolean hasNumber() {
        return phoneNumber != null && !phoneNumber.equals("[no number]");
    }

    public boolean checkNumberFormat(String phoneNumber) {
        String regex = "((\\+?\\([a-z\\d]+\\))(((\\s|-)[a-z\\d]{2,})*))|" +
                "((\\+?[a-z\\d]+)(((-|\\s)\\([a-z\\d]{2,}\\))?)(((\\s|-)[a-z\\d]{2,})*))";

        return phoneNumber.matches(regex);
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
        String creationDateTime = this.creationDateTime.format(formatter);
        return creationDateTime;
    }

    public void setEditDateTime(LocalDateTime editDateTime) {
        this.editDateTime = editDateTime;
    }

    public String getEditDateTime() {
        String editDateTime = this.editDateTime.format(formatter);
        return editDateTime;
    }

    public boolean isPerson() {
        return this instanceof Person;
    }

    public abstract String getFullName();

    public abstract String getPhoneNumber();
}
