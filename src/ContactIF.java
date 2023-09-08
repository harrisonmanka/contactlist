public interface ContactIF {

    PersonalInfoIF getInfo();

    AddressIF getAddress();

    public interface AddressIF {

        String getStreetAddress();

        void setStreetAddress(String streetAddress);

        String getCity();

        void setCity(String city);

        String getState();

        void setState(String state);

        String getZipCode();

        void setZipCode(String zipCode);
    }
}
