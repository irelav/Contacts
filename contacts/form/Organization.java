package contacts.form;

public class Organization extends Contact {
    private String address;

    public Organization(boolean isPerson, String organizationName, String address, String phoneNumber) {
        super(isPerson, organizationName, phoneNumber);
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
