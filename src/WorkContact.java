public class WorkContact extends Contact implements Cloneable{

    private String title;
    private String company;
    private String department;


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

    @Override
    public WorkContact clone() {
        try {
            return (WorkContact) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
