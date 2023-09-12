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

    public Address getAddress() {
        return address;
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
