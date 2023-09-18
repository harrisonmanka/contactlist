/**
 * Class representing a Table
 * @param <T> Generic type for our table which will hold Personal and Work Contacts
 */
public class Table<T extends Contact>{

    /** Generic Node field representing the head */
    private Node<T> head;
    /** Integer field representing the length */
    private int length;

    /**
     * Constructor for the Table class that intializes its field accordingly.
     */
    public Table() {
        this.head = null;
        this.length = 0;
    }

    /**
     * Insert method that inserts a Node containing a Contact to the end of the list.
     * @param data
     */
    public void insert(Contact data) {
        Node<T> temp = new Node<>(data);
        if (this.head == null) {
            this.head = temp;
        }
        else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }
        this.length++;
    }

    /**
     * Remove method to remove a Node that contains the given attribute matching the given value.
     * @param attribute
     * @param value
     */
    public void remove(String attribute, String value) {
        attribute = attribute.toUpperCase();
        if (attribute.equals("STREET ADDRESS")) {
            attribute = "STREET_ADDRESS";
        }
        Attribute attb = Attribute.valueOf(attribute);
        value = value.trim().toLowerCase();

        Node<T> current = head;
        Node<T> tempNode = current;
        String tempVal = null;
        for (int i = 0; i < length; i++) {
            tempVal = this.attributeGrabber(attb, current).toLowerCase();
            if (value.equals(tempVal)) {
                if(current == head) {
                    head = current.next;
                }
                else {
                    tempNode.next = current.next;
                }
                this.length--;
            }
            tempNode = current;
            current = current.next;
        }
    }

    /**
     * Difference method that creates a new table comprised of nodes in this table,
     * but not in table.
     * @param table
     * @return Table containing nodes that are in this table and not in the table passed in.
     */
    public Table<T> difference(Table<T> table) {
        Table<T> resultTable = new Table<>();
        Node<T> currentThis = this.head;
        Node<T> currentThat = table.head;
        boolean isInside = false;
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < table.length && !isInside; j++) {
                if (currentThis.data.equals(currentThat.data)) {
                    isInside = true;
                }
                currentThat = currentThat.next;
            }
            if (!isInside) {
                resultTable.insert(currentThis.data.clone());
            }
            currentThat = table.head;
            currentThis = currentThis.next;
            isInside = false;
        }
        return resultTable;
    }

    /**
     * Intersect method that creates a new table comprised of nodes having a value for a
     * specific attribute, created from both tables.
     * @param attribute
     * @param value
     * @param table
     * @return Table containing nodes whose attributes match the given attribute and value.
     */
    public Table<T> intersect(String attribute, String value, Table<T> table) {
        value = value.trim().toLowerCase();
        Table<T> resultTable = new Table<>();
        Node<T> compareThis = this.head;
        Node<T> compareThat = table.head;

        attribute = attribute.toUpperCase();
        if (attribute.equals("STREET ADDRESS")) {
            attribute = "STREET_ADDRESS";
        }
        Attribute attb = Attribute.valueOf(attribute);

        String tempVal1 = null;
        String tempVal2 = null;
        for (int i = 0; i < this.length; i++) {
            tempVal1 = this.attributeGrabber(attb, compareThis).toLowerCase();
            if (tempVal1.equals(value)) {
                for (int j = 0; j < table.length; j++) {
                    tempVal2 = this.attributeGrabber(attb, compareThat).toLowerCase();
                    if (tempVal1.equals(tempVal2)) {
                        resultTable.insert(compareThis.data.clone());
                    }
                    compareThat = compareThat.next;
                }
            }
            compareThat = table.head;
            compareThis = compareThis.next;
        }
        return resultTable;
    }

    /**
     * Select method that selects all nodes whose attribute matches the given
     * attribute and value.
     * @param attribute
     * @param value
     * @return Table containing all nodes whose attribute matches the given attribute and value.
     */
    public Table<T> select(String attribute, String value) {
        value = value.trim().toLowerCase();
        attribute = attribute.toUpperCase();
        if (attribute.equals("STREET ADDRESS")) {
            attribute = "STREET_ADDRESS";
        }
        Attribute attb = Attribute.valueOf(attribute);

        Table<T> tempTable = new Table<>();
        Node<T> current = head;
        boolean found = false;
        for (int i = 0; i < length; i++) {
            String tempVal = null;
            tempVal = this.attributeGrabber(attb, current).toLowerCase();
            if (value.equals(tempVal)) {
                tempTable.insert(current.data.clone());
            }
            current = current.next;
        }

        return tempTable;
    }

    /**
     * Union method that creates a new table comprised of nodes that occur in either table(s).
     * @param table
     * @return Table containing all nodes from both tables.
     */
    public Table<T> union(Table<T> table) {
        Table<T> resultTable = new Table<>();
        Node<T> current = this.head;
        Node<T> compareThis;

        for (int i = 0; i < this.length; i++) {
            resultTable.insert(current.data.clone());
            current = current.next;
        };
        for (int i = 0; i < table.length; i++) {
            resultTable.insert(table.getNodeAt(i).data.clone());
        }

        compareThis = resultTable.head;
        current = resultTable.head.next;
        while (compareThis != null) {
            while (current.next != null) {
                if (compareThis.data.equals(current.next.data)) {
                    current.next = current.next.next;
                }
                current = current.next;
            }
            compareThis = compareThis.next;
            current = compareThis;
        }
        return resultTable;
    }

    /**
     * Helper method that takes in an index and returns that node.
     * @param index
     * @return Node at the specified index
     */
    private Node<T> getNodeAt(int index) {
        Node<T> current = null;
        if (index >= 0 && index < this.length) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        return current;
    }

    /**
     * Helper method that grabs an attribute based off the given node.
     * @param attribute
     * @param node
     * @return String representing the attribute grabbed.
     */
    private String attributeGrabber(Attribute attribute, Node<T> node) {
        String result = null;
        switch (attribute) {
            case FIRST -> result = node.data.getInfo().getFirstName();
            case LAST -> result = node.data.getInfo().getLastName();
            case STATUS -> result = node.data.getInfo().getStatus().toString();
            case STREET_ADDRESS -> result = node.data.getStreet();
            case CITY -> result = result = node.data.getCity();
            case STATE -> result = node.data.getState();
            case ZIP -> result = node.data.getZip();
            case PHONE -> result = node.data.getPhoneNumber();
            case EMAIL -> result = node.data.getEmail();
        }
        return result;
    }

    /**
     * toString method that goes through a whole table and returns a string of
     * all the nodes in that table.
     * @return String representing all the nodes in the table.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Node<T> current = head; current != null; current = current.next) {
            result.append(current.data.toString());
        }
        return result.toString();
    }

    /**
     * Private generic class representing our Node.
     * @param <T> Generic type for our table which will hold Personal and Work Contacts
     */
    private static class Node<T>{

        /** Contact information for the current node */
        private final Contact data;
        /** A pointer to the next node in the Linked List */
        private Node<T> next;

        /**
         * Private constructor for initializing a Node's fields.
         * @param data
         */
        private Node(Contact data) {
            this.data = data;
        }
    }
}
