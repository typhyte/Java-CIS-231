public class MyLinkedList<T> implements MyList {
    int size;
    Node head, tail;


    public int size() {
        return size;
    }
    
    // gets data from given index from list
    public Object get (int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node curr = head;

        while (i < index) {
            curr = curr.next;
            i++;
        }

        return curr.obj;
    }

    // adders
    public void add(Object obj) {
        Node node = new Node(obj);

        if (size == 0) {
            tail = node;
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public void add (int index, Object obj) {
        Node node = new Node (obj);

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            node.next = head;
            head.prev = node; 
            head = node;
        } else if (index == size) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else {
            int i = 0;
            Node curr = head;
            
            while (i < index - 1) {
                curr = curr.next;
                i++;
            }

            node.prev = curr;
            node .next = curr.next;
            curr.next.prev = node;
            curr.next = node;
        }
        size++;
    }

    public int indexOf(Object obj) {
        int index = -1;
        Node curr = head;
        int i = 0;

        while (curr != null) {
            if (curr.obj == obj) {
                return i;
            }

            i++;
            curr = curr.next;
        }

        return -1;
    }

    public boolean contains (Object obj) {
        return indexOf(obj) != -1;
    }
}
