public enum Attribute {

    FIRST("first"),
    LAST("last"),
    STATUS("status"),
    ADDRESS("address"),
    PHONE("phone"),
    EMAIL("email");

    private final String attribute;

    Attribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
