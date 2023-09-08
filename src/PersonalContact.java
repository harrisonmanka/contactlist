public class PersonalContact extends Contact implements Cloneable{

    private Label label;

    @Override
    public PersonalContact clone() {
        try {
            return (PersonalContact) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
