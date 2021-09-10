package contacts.form;

public class Person extends Contact{
    private String surname;
    private String birthDate;
    private String gender;

    public Person(String name, String surname, String  birthDate, String gender,
                  String phoneNumber) {
        super(name, phoneNumber);
        this.surname = surname;
        setBirthDate(birthDate);
        setGender(gender);
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(String birthDate) {
        if (!birthDate.isEmpty()) {
            this.birthDate = birthDate;
        } else {
            this.birthDate = "[no data]";
            System.out.println("Bad birth date!");
        }
    }

    public void setGender(String gender) {
        if (!gender.isEmpty()) {
            this.gender = gender;
        } else {
            this.gender = "[no data]";
            System.out.println("Bad gender");
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s \n" +
                "Surname: %s \n" +
                "Birth date: %s \n" +
                "Gender: %s \n" +
                "Number: %s \n" +
                "Time created: %s\n" +
                "Time last edit: %s", name, surname, birthDate, gender, phoneNumber, getCreationDateTime(), getEditDateTime());
    }

    @Override
    public String getFullName() {
        return name + " " + surname;
    }
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
