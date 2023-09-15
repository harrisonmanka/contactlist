import java.util.Objects;

public class Contact{

    private PersonalInfo info;
    private Address address;
    private String phoneNumber;
    private String email;

    public Contact(PersonalInfo info, Address address, String phoneNumber, String email){
        this.info = info;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Contact(){
        this.info = null;
        this.address = null;
        this.phoneNumber = "";
        this.email = "";
    }

    public PersonalInfo getInfo() {
        return info;
    }

    public void setInfo(PersonalInfo info) {
        this.info = info;
    }

    public String getFirstName(){
        return this.info.getFirstName();
    }

    public String getLastName(){
        return this.info.getLastName();
    }

    public String getStatus(){
        return this.info.getStatus().toString();
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet(){
        return this.address.streetAddress;
    }

    public String getCity(){
        return this.address.city;
    }

    public String getState(){
        return this.address.state;
    }

    public String getZip(){
        return this.address.zip;
    }

    public void buildAddress(String streetAddress, String city, String state, String zip){
        this.address = new Address(streetAddress, city, state, zip);
    }

    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;
        if (this == o) {
            isEqual = true;
        }
        else if (o == null || o instanceof Contact) {
            Contact contact = (Contact) o;
            if (this.info.getFirstName().equals(contact.getInfo().getFirstName()) &&
                    this.info.getLastName().equals(contact.getInfo().getLastName()) &&
                    this.email.equals(contact.getEmail()) &&
                    this.phoneNumber.equals(contact.getPhoneNumber()) &&
                    this.address.streetAddress.equals(contact.address.streetAddress) &&
                    this.address.city.equals(contact.address.city) &&
                    this.address.state.equals(contact.address.state) &&
                    this.address.zip.equals(contact.address.zip)) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    private class Address{
        String streetAddress;
        String city;
        String state;
        String zip;

        public Address(String streetAddress, String city, String state, String zip){
            this.streetAddress = streetAddress;
            this.city = city;
            this.state = state;
            this.zip = zip;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }
    }
}
