public class Contact{

    private PersonalInfoIF info;
    private Address address;
    private String phoneNumber;
    private String email;

    
    public PersonalInfoIF getInfo() {
        return this.info;
    }

    
    public Address getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public class Address {

        
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
