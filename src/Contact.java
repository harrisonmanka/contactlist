/**
 * Class representing our Contact with information
 * about a person.
 */

public class Contact implements Cloneable, ContactInterface{

    /**
     * PersonalInfo field representing a Contacts' PersonalInfo
     */
    private PersonalInfo info;
    /**
     * Address field representing a Contacts' Address
     */
    private Address address;
    /**
     * String field representing a Contacts' phoneNumber
     */
    private String phoneNumber;
    /**
     * String field representing a Contacts' email
     */
    private String email;

    /**
     * Constructor for the Contact class which initializes
     * our fields respectively.
     */
    public Contact() {
        this.info = null;
        this.address = null;
        this.phoneNumber = "";
        this.email = "";
    }

    /**
     * Getter method to return a Contact's object PersonalInfo field.
     *
     * @return PersonalInfo object
     */
    public PersonalInfo getInfo() {
        return info;
    }

    /**
     * Setter method that takes in a PersonalInfo object and sets a Contact's PersonalInfo field
     * to the new PersonalInfo object.
     *
     * @param info
     */
    public void setInfo(PersonalInfo info) {
        this.info = info;
    }

    /**
     * Getter method to return a Contact's PersonalInfo firstName field.
     *
     * @return String representing firstName
     */
    public String getFirstName() {
        return this.info.getFirstName();
    }

    /**
     * Getter method to return a Contact's PersonalInfo lastName field.
     *
     * @return String representing lastName
     */
    public String getLastName() {
        return this.info.getLastName();
    }

    /**
     * Getter method to return a Contact's PersonalInfo status field.
     *
     * @return String presenting a Status
     */
    public String getStatus() {
        return this.info.getStatus().toString();
    }

    /**
     * Getter method to return a Contact's Address object field.
     *
     * @return Address object
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * Getter method to return a Contact's phoneNumber field.
     *
     * @return String representing a phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter method to set a Contact's phoneNumber to a new phoneNumber.
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter method to return a Contact's email field.
     *
     * @return String representing an email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method to set a Contact's email to a new email.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method to return a Contact's inner Address's streetAddress field.
     * @return String representing a streetAddress
     */
    public String getStreet() {
        return this.address.streetAddress;
    }

    /**
     * Getter method to return a Contact's inner Address's city field.
     * @return String representing a city
     */
    public String getCity() {
        return this.address.city;
    }

    /**
     * Getter method to return a Contact's inner Address's state field.
     * @return String representing a state
     */
    public String getState() {
        return this.address.state;
    }

    /**
     * Getter method to return a Contact's inner Address's zip code field.
     * @return String representing a zip code
     */
    public String getZip() {
        return this.address.zip;
    }

    /**
     * Build method to create build a new Address given specific params for an address.
     * @param streetAddress
     * @param city
     * @param state
     * @param zip
     */
    public void buildAddress(String streetAddress, String city, String state, String zip) {
        this.address = new Address(streetAddress, city, state, zip);
    }

    /**
     * Equals method that compares firstName, lastName, email, phoneNumber, streetAddress,
     * city, state, and zip code.
     * @param o
     * @return Boolean representing true or false if both Objects are equal
     */
    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;
        if (this == o) {
            isEqual = true;
        } else if (o == null || o instanceof Contact) {
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

    /**
     * Clone method to clone a Contact.
     * @return Cloned Contact
     */
    public Contact clone() {
        Contact clone = null;
        try {
            clone = (Contact) super.clone();
            clone.info.setFirstName(this.getFirstName());
            clone.info.setLastName(this.getLastName());
            clone.info.setStatus(Status.valueOf(this.getStatus().toUpperCase()));
            clone.address.city = this.address.city;
            clone.address.streetAddress = this.address.streetAddress;
            clone.address.zip = this.address.zip;
            clone.address.state = this.address.state;
            clone.phoneNumber = this.phoneNumber;
            clone.email = this.email;
        }
        catch (CloneNotSupportedException e) {
            System.out.println("Cannot create clone");
        }
        return clone;
    }

    /**
     * Check to see if a record has an attribute. Should not be case-sensitive.
     * @param attribute possible attribute within a record.
     * @return true if the value is contained in the object, false otherwise.
     */
    @Override
    public boolean exists(String attribute) {
        attribute = attribute.toUpperCase();
        if (attribute.equals("STREET ADDRESS")) {
            attribute = "STREET_ADDRESS";
        }
        Attribute attb = Attribute.valueOf(attribute);
        String result = null;
        boolean exists = false;

        switch (attb) {
            case FIRST -> result = this.info.getFirstName();
            case LAST -> result = this.info.getLastName();
            case STATUS -> result = String.valueOf(this.info.getStatus());
            case STREET_ADDRESS -> result = this.address.streetAddress;
            case CITY -> result = this.address.city;
            case STATE -> result = this.address.state;
            case ZIP -> result = this.address.zip;
            case PHONE -> result = this.phoneNumber;
            case EMAIL -> result = this.email;
        }
        if (result != null) {
            exists = true;
        }
        return exists;
    }

    /**
     * Check to see if a record has an attribute containing a specific value. Should not be case-sensitive.
     * @param attribute possible attribute within a record.
     * @param value desired value of the attribute.
     * @return true if the value is contained in the object, false otherwise.
     * @throws IllegalArgumentException if the attribute is invalid.
     */
    @Override
    public boolean hasValue(String attribute, String value) throws IllegalArgumentException {
        attribute = attribute.toUpperCase();
        if (attribute.equals("STREET ADDRESS")) {
            attribute = "STREET_ADDRESS";
        }
        Attribute attb = Attribute.valueOf(attribute);
        String result = null;
        boolean exists = false;

        switch (attb) {
            case FIRST -> result = this.info.getFirstName();
            case LAST -> result = this.info.getLastName();
            case STATUS -> result = String.valueOf(this.info.getStatus());
            case STREET_ADDRESS -> result = this.address.streetAddress;
            case CITY -> result = this.address.city;
            case STATE -> result = this.address.state;
            case ZIP -> result = this.address.zip;
            case PHONE -> result = this.phoneNumber;
            case EMAIL -> result = this.email;
        }
        if (result != null && result.toLowerCase().equals(value.toLowerCase())) {
            exists = true;
        }
        return exists;
    }

    /**
     * Change the value of a specific attribute.
     * @param attribute possible attribute within a record.
     * @param value new value of the attribute.
     * @throws IllegalArgumentException if the attribute is invalid.
     */
    @Override
    public void setValue(String attribute, String value) throws IllegalArgumentException {
        Attribute attb = Attribute.valueOf(attribute.toUpperCase());
        String result = null;
        switch (attb) {
            case FIRST -> this.info.setFirstName(value);
            case LAST -> this.info.setLastName(value);
            case STATUS -> this.info.setStatus(Status.valueOf(value.toUpperCase()));
            case STREET_ADDRESS -> this.address.streetAddress = value;
            case CITY -> this.address.city = value;
            case STATE -> this.address.state = value;
            case ZIP -> this.address.zip = value;
            case PHONE -> this.phoneNumber = value;
            case EMAIL -> this.email = value;
        }
    }

    private class Address {
        /** String field representing a streetAddress */
        String streetAddress;
        /** String field representing a city */
        String city;
        /** String field representing a state */
        String state;
        /** String field representing a zip */
        String zip;

        /**
         * Constructor for the Contact class which initializes
         * our fields respectively.
         *
         * @param streetAddress
         * @param city
         * @param state
         * @param zip
         */
        public Address(String streetAddress, String city, String state, String zip) {
            this.streetAddress = streetAddress;
            this.city = city;
            this.state = state;
            this.zip = zip;
        }
    }
}
