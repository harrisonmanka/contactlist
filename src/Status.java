public enum Status {

    MARRIED("Married"),
    SINGLE("Single"),
    DIVORCED("Divorced"),
    WIDOWED("Widowed"),
    NA("NA");

    private final String status;

    private Status(String status) {
        this.status = status;
    }

    String getStatus() {
        return this.status;
    }
}
