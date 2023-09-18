public class WorkContact extends Contact implements Cloneable{

    private String title;
    private String company;
    private String department;

    public WorkContact(String title, String company, String department){
        this.title = title;
        this.company = company;
        this.department = department;
    }

    String getTitle() {
        return this.title;
    }

    void setTitle(String title){
        this.title = title;
    }

    String getCompany() {
        return this.company;
    }

    void setCompany(String company) {
        this.company = company;
    }

    String getDepartment() {
        return this.department;
    }

    void setDepartment(String department) {
        this.department = department;
    }

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

    @Override
    public WorkContact clone() {
        WorkContact clone = (WorkContact) super.clone();
        clone.department = this.department;
        clone.company = this.company;
        clone.title = this.title;
        return clone;
    }
}
