public class Contact implements ContactIF{

    private PersonalInfoIF info;
    private AddressIF address;
    private String phoneNumber;
    private String email;

    @Override
    public PersonalInfoIF getInfo() {
        return this.info;
    }

    @Override
    public AddressIF getAddress() {
        return this.address;
    }

    public class Address implements AddressIF {

        @Override
        public String getStreetAddress() {
            return null;
        }

        @Override
        public void setStreetAddress(String streetAddress) {

        }

        @Override
        public String getCity() {
            return null;
        }

        @Override
        public void setCity(String city) {

        }

        @Override
        public String getState() {
            return null;
        }

        @Override
        public void setState(String state) {

        }

        @Override
        public String getZipCode() {
            return null;
        }

        @Override
        public void setZipCode(String zipCode) {

        }
    }
}
