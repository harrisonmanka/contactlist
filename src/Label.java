public enum Label {

    MOM("Mom"),
    DAD("Dad"),
    SON("Son"),
    DAUGHTER("Daughter"),
    FRIEND("Friend"),
    SISTER("Sister"),
    BROTHER("Brother");

    private final String label;

    private Label(String label) {
        this.label = label;
    }

    String getLabel(){
        return this.label;
    }
}
