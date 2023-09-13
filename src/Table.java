import java.util.Objects;

public class Table<T extends Contact>{

    private Node<T> head;

    private int length;

    public Table() {
        this.head = null;
        this.length = 0;
    }

    public Table<T> difference(Table<T> table) {
        Table<T> resultTable = new Table<>();
        Node<T> currentThis = this.head;
        Node<T> currentThat = table.head;
        boolean isInside = false;
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < table.length && !isInside; j++) {
                if (currentThis.equals(currentThat)) {
                    isInside = true;
                }
                currentThat = currentThat.next;
            }
            if (!isInside) {
                resultTable.insert(currentThis.data);
            }
            currentThis = currentThis.next;
        }
        return resultTable;
    }

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

    public Table<T> intersect(String attribute, String value, Table<T> table) {
        Table<T> resultTable = new Table<>();
        Node<T> compareThis = this.head;
        Node<T> compareThat = table.head;
        Attribute attb = null;
        try {
            attb = Attribute.valueOf(value.toLowerCase().trim());
        }
        catch (IllegalArgumentException e) {
            System.out.println("-----------------------------------------------" +
                    "\nThe attribute given does not exist" +
                    "\n-----------------------------------------------");
        }

        String tempVal1 = null;
        String tempVal2 = null;
        for (int i = 0; i < this.length; i++) {
            tempVal1 = this.attributeGrabber(attb, compareThis);
            for (int j = 0; j < table.length; j++) {
                tempVal2 = this.attributeGrabber(attb, compareThat);
                if (tempVal1.equals(tempVal2)) {
                    resultTable.insert(compareThis.data);
                }
                compareThat = compareThat.next;
            }
            compareThis = compareThis.next;
        }
        return resultTable;
    }

    private String attributeGrabber(Attribute attribute, Node<T> node) {
        String result = null;
        switch (attribute) {
            case FIRST -> result = node.data.getInfo().getFirstName();
            case LAST -> result = node.data.getInfo().getLastName();
            case STATUS -> result = node.data.getInfo().getStatus().toString();
            case ADDRESS -> result = node.data.getAddress().toString();
            case PHONE -> result = node.data.getPhoneNumber();
            case EMAIL -> result = node.data.getEmail();
        }
        return result;
    }

    public void remove(String attribute, String value) {
        value = value.toLowerCase().trim();
        Attribute attb = null;
        try {
            attb = Attribute.valueOf(value.toLowerCase().trim());
        }
        catch (IllegalArgumentException e) {
            System.out.println("The attribute given does not exist\n");
        }

        Node<T> current = head;
        Node<T> tempNode = current;
        for (int i = 0; i < length; i++) {
            String tempVal = null;
            tempVal = this.attributeGrabber(attb, current);
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

    public Table<T> select(String attribute, String value) {
        value = value.toLowerCase().trim();
        Attribute attb = null;
        try {
            attb = Attribute.valueOf(value.toLowerCase().trim());
        }
        catch (IllegalArgumentException e) {
            System.out.println("The attribute given does not exist\n");
        }

        Table<T> tempTable = new Table<>();
        Node<T> current = head;
        boolean found = false;
        for (int i = 0; i < length; i++) {
            String tempVal = null;
            tempVal = this.attributeGrabber(attb, current);
            if (value.equals(tempVal)) {
                tempTable.insert(current.data);
            }
            current = current.next;
        }

        return tempTable;
    }

    public Table<T> union(Table<T> table) {
        Table<T> resultTable = new Table<>();
        Node<T> current = this.head;
        Node<T> compareThis = null;
        for (int i = 0; i < this.length; i++) {
            resultTable.insert(current.data);
            current = current.next;
        };
        for (int i = 0; i < table.length; i++) {
            resultTable.insert(table.getNodeAt(i).data);
        }
        compareThis = table.head;
        current = table.head;
        for (int i = 0; i < resultTable.length; i++) {
            for (int j = i; j < resultTable.length; j++) {
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

    private static class Node<T>{


        /** Contact information for the current node */
        private final Contact data;
        /** A pointer to the next node in the Linked List */
        private Node<T> next;

        private Node(Contact data) {
            this.data = data;
        }
    }
}
