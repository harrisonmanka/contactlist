public class Table<T extends Contact> implements TableIF{

    @Override
    public TableIF<T> difference(TableIF table) {
        return null;
    }

    @Override
    public void insert(ContactIF data) {

    }

    @Override
    public TableIF<T> intersect(String attb, String value, TableIF table) {
        return null;
    }

    @Override
    public void remove(String attb, String value) {

    }

    @Override
    public TableIF<T> select(String attb, String value) {
        return null;
    }

    @Override
    public TableIF<T> union(TableIF table) {
        return null;
    }
}
