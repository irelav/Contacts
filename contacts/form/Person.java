package contacts.form;

public class Person extends Contact{
    private String surname;
    private String birthDate;
    private String gender;

    public Person(boolean isPerson, String name, String surname, String  birthDate, String gender,
                  String phoneNumber) {
        super(isPerson, name, phoneNumber);
        this.surname = surname;
        setBirthDate(birthDate);
        setGender(gender);
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setBirthDate(String birthDate) {
        if (!birthDate.isEmpty()) {
            this.birthDate = birthDate;
        } else {
            this.birthDate = "[no data]";
            System.out.println("Bad birth date!");
        }
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setGender(String gender) {
        if (!gender.isEmpty()) {
            this.gender = gender;
        } else {
            this.gender = "[no data]";
            System.out.println("Bad gender");
        }
    }

    public String getGender() {
        return gender;
    }
}
