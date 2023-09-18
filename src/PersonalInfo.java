/**
 * Class representing a Contact's PersonalInfo with its respected fields.
 */
public class PersonalInfo {

    /** String field representing a firstName */
    private String firstName;
    /** String field representing a lastName */
    private String lastName;
    /** String field representing a Status */
    private Status status;

    /**
     * Constructor for initializing a PersonalInfo's field
     * @param firstName
     * @param lastName
     * @param status
     */
    public PersonalInfo(String firstName, String lastName, Status status){
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    /**
     * Getter method for returning a firstName
     * @return String representing a firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for setting a firstName to a new firstName.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter method for returning a lastName
     * @return String representing a lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for setting a lastName to a new lastName.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter method for returning a status.
     * @return Status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Setter method for setting a status to a new status.
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}