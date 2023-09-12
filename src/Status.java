public enum Status {

    MARRIED("Married"),
    SINGLE("Single"),
    DIVORCED("Divorced"),
    WIDOWED("Widowed"),
    FRIEND("Friend"),
    NA("NA");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    String getStatus() {
        return this.status;
    }
}
