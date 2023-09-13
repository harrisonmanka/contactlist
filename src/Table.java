public class Table<T extends Contact>{

    private Node<T> head;

    private int length;

    public Table() {
        this.head = null;
        this.length = 0;
    }

    public Table<T> difference(Table<T> table) {
        Table<T> returnTable = new Table<>();
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
                returnTable.insert(currentThis.data);
            }
            currentThis = currentThis.next;
        }
        return returnTable;
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
    }

    public Table<T> intersect(String attribute, String value, Table<T> table) {
        return null;
    }

    public void remove(String attribute, String value) {
        value = value.toLowerCase().trim();
        Attribute attb = null;
        try {
            attb = Attribute.valueOf(value);
        }
        catch (IllegalArgumentException e) {
            System.out.println("The attribute given does not exist\n");
        }

        Node<T> current = head;
        Node<T> tempNode = current;
        for (int i = 0; i < length; i++) {
            String tempVal = null;
            switch (attb) {
                case FIRST -> tempVal = current.data.getInfo().getFirstName();
                case LAST -> tempVal = current.data.getInfo().getLastName();
                case STATUS -> tempVal = current.data.getInfo().getStatus().toString();
                case ADDRESS -> tempVal = current.data.getAddress().toString();
                case PHONE -> tempVal = current.data.getPhoneNumber();
                case EMAIL -> tempVal = current.data.getEmail();
            }
            if (value.equals(tempVal)) {
                if(current == head) {
                    head = current.next;
                }
                else {
                    tempNode.next = current.next;
                }
            }
            tempNode = current;
            current = current.next;
        }
    }

    public Table<T> select(String attribute, String value) {
        value = value.toLowerCase().trim();
        Attribute attb = null;
        try {
            attb = Attribute.valueOf(value);
        }
        catch (IllegalArgumentException e) {
            System.out.println("The attribute given does not exist\n");
        }

        Table<T> tempTable = new Table<>();
        Node<T> current = head;
        boolean found = false;
        for (int i = 0; i < length; i++) {
            String tempVal = null;
            switch (attb) {
                case FIRST -> tempVal = current.data.getInfo().getFirstName();
                case LAST -> tempVal = current.data.getInfo().getLastName();
                case STATUS -> tempVal = current.data.getInfo().getStatus().toString();
                case ADDRESS -> tempVal = current.data.getAddress().toString();
                case PHONE -> tempVal = current.data.getPhoneNumber();
                case EMAIL -> tempVal = current.data.getEmail();
            }
            if (value.equals(tempVal)) {
                tempTable.insert(current.data);
            }
            current = current.next;
        }

        return tempTable;
    }

    public Table<T> union(Table<T> table) {
        Table<T> returnTable = new Table<>();
        Node<T> current = this.head;
        Node<T> compareThis = null;
        for (int i = 0; i < this.length; i++) {
            returnTable.insert(current.data);
            current = current.next;
        };
        for (int i = 0; i < table.length; i++) {
            returnTable.insert(table.getNodeAt(i).data);
        }
        compareThis = table.head;
        current = table.head;
        for (int i = 0; i < returnTable.length; i++) {
            for (int j = i; j < returnTable.length; j++) {
                if (compareThis.data.equals(current.next.data)) {
                    current.next = current.next.next;
                }
                current = current.next;
            }
            compareThis = compareThis.next;
            current = compareThis;
        }
        return returnTable;
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
