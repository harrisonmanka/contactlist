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

    public PersonalContact clone() {
        try {
            return (PersonalContact) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
