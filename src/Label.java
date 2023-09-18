/**
 * Enum class representing enums for a variety of Label's.
 */
public enum Label {

    MOM("mom"),
    DAD("dad"),
    SON("son"),
    DAUGHTER("daughter"),
    FRIEND("friend"),
    SISTER("sister"),
    BROTHER("brother");

    private final String label;

    private Label(String label) {
        this.label = label;
    }
}
