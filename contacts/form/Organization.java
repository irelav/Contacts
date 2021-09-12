package contacts.form;

public class Organization extends Contact {
    private String address;

    public Organization(String name, String address, String phoneNumber) {
        super(name, phoneNumber);
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("Organization name: %s \n" +
                "Address: %s \n" +
                "Number: %s \n" +
                "Time created: %s\n" +
                "Time last edit: %s", name, address, phoneNumber, getCreationDateTime(), getEditDateTime());
    }

    @Override
    public String getFullName() {
        return name;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
