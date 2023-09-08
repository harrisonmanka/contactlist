

public interface TableIF<T extends ContactIF> {
    
    TableIF<T> difference(TableIF<T> table);
    
    void insert (T data);
    
    TableIF<T> intersect(String attb, String value, TableIF<T> table);
    
    void remove(String attb, String value);
    
    TableIF<T> select(String attb, String value);
    
    TableIF<T> union(TableIF<T> table);
    
    public interface Node {
        
    }
}
