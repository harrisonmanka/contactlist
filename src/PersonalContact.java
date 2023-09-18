/**
 * Class representing a PersonalContact which is a subclass of Contact.
 */
public class PersonalContact extends Contact implements Cloneable{
    /** Label field representing a label */
    private Label label;

    /**
     * Constructor for the PersonalContact class that initializes the label field.
     * @param label
     */
    public PersonalContact(Label label){
        this.label = label;
    }

    /**
     * Getter method to return a Label
     * @return Label
     */
    public Label getLabel() {
        return label;
    }

    /**
     * toString method that prints out a PersonalContact's information
     * @return String representing information in the specified format
     */
    public String toString(){
        String result = "";
        result += "Category: " + getLabel() + "\n";
        result += "\t" + super.getFirstName() + ", " + super.getLastName() + ": (" +
                  super.getStatus() + "):";
        result += "\tPhone: " + super.getPhoneNumber() + "\n";
        result += "\t" + super.getStreet() + "\n\t" + super.getCity() + ", " +
                  super.getState() + " " + super.getZip() +
                  "\n--------------------------------------------------------------\n";
        return result;
    }

    /**
     * Clone method that clones a PersonalContact
     * @return Cloned PersonalContact
     */
    @Override
    public PersonalContact clone() {
        PersonalContact clone = (PersonalContact) super.clone();
        clone.label = this.label;
        return clone;
    }
}
