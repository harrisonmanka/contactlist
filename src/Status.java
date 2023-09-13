public enum Status {

    MARRIED("married"),
    SINGLE("single"),
    DIVORCED("divorced"),
    WIDOWED("widowed"),
    NA("na");

    private final String status;

    private Status(String status) {
        this.status = status;
    }

    String getStatus() {
        return this.status;
    }
}
