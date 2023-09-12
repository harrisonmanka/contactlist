public class Contact{

    private PersonalInfo info;
    private Address address;
    private String phoneNumber;
    private String email;

    public PersonalInfo getInfo() {
        return this.info;
    }

    public Address getAddress() {
        return this.address;
    }

    public class Address{

        public String getStreetAddress() {
            return null;
        }

        public void setStreetAddress(String streetAddress) {

        }

        public String getCity() {
            return null;
        }

        public void setCity(String city) {

        }

        public String getState() {
            return null;
        }

        public void setState(String state) {

        }

        public String getZipCode() {
            return null;
        }

        public void setZipCode(String zipCode) {

        }
    }
}
