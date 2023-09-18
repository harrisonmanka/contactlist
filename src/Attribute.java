/**
 * Enum class representing enums for a variety of Attributes.
 */
public enum Attribute {

    FIRST("first"),
    LAST("last"),
    STATUS("status"),
    STREET_ADDRESS("street address"),
    CITY("city"),
    STATE("State"),
    ZIP("zip"),
    PHONE("phone"),
    EMAIL("email");

    private final String attribute;

    Attribute(String attribute) {
        this.attribute = attribute;
    }
}
