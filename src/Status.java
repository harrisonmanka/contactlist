public enum Status {

    MARRIED("married"),
    SINGLE("single"),
    DIVORCED("divorced"),
    WIDOWED("widowed"),
    FRIEND("friend"),
    NA("na");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    String getStatus() {
        return this.status;
    }
}
