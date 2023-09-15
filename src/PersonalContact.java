public class PersonalContact extends Contact implements Cloneable{

    private Label label;

    public PersonalContact(Label label){
        this.label = label;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

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

    public PersonalContact clone() {
        try {
            return (PersonalContact) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
