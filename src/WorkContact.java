/**
 * Class representing a WorkContact which is a subclass of Contact.
 */
public class WorkContact extends Contact implements Cloneable{

    /** String field representing a title */
    private String title;
    /** String field representing a company */
    private String company;
    /** String field representing a department */
    private String department;

    /**
     * Constructor for the WorkContact class that initializes all fields.
     * @param title
     * @param company
     * @param department
     */
    public WorkContact(String title, String company, String department){
        this.title = title;
        this.company = company;
        this.department = department;
    }

    /**
     * Getter method that returns the title
     * @return String representing a title
     */
    String getTitle() {
        return this.title;
    }

    /**
     * Getter method that returns the company name
     * @return String representing a company
     */
    String getCompany() {
        return this.company;
    }

    /**
     * Getter method that returns the department name
     * @return String representing a department
     */
    String getDepartment() {
        return this.department;
    }

    /**
     * toString method that prints out a WorkContact's information
     * @return String representing information in the specified format
     */
    public String toString(){
        String result = "";
        result += "Job Title: " + getTitle() + "\n";
        result += "Company: " + getCompany() + "\n";
        result += "Department: " + getDepartment() + "\n";
        result += "\t" + super.getFirstName() + ", " + super.getLastName() + ": (" +
                super.getStatus() + "):";
        result += "\tPhone: " + super.getPhoneNumber() + "\n";
        result += "\t" + super.getStreet() + "\n\t" + super.getCity() + ", " +
                super.getState() + " " + super.getZip() +
                "\n--------------------------------------------------------------\n";
        return result;
    }

    /**
     * Clone method that clones a WorkContact
     * @return Cloned WorkContact
     */
    @Override
    public WorkContact clone() {
        WorkContact clone = (WorkContact) super.clone();
        clone.department = this.department;
        clone.company = this.company;
        clone.title = this.title;
        return clone;
    }
}
