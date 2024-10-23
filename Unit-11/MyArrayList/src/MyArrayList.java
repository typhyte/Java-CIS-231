public class MyArrayList<T> implements MyList {
    //<T> allows the class to be any type

    int size;
    Object[] object = new Object[1];
    
    // returns the size of the list
    public int size() {
        return size;
    }

    public Object get (int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(); // throw error if index is oob
        } else {
            return object[index]; //return object at given index
        }
    }

    public int indexOf(Object obj) {
        for (int i=0; i < size; i++) {
            if (object[i] == obj) { // if index of the given object is found, return index
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0; // if size is 0, return true
    }

    public void add(Object obj) {
        if (size == object.length) {
            Object longerObject[] = new Object[size * 2];

            // copies original array and makes a new, longer array
            for (int i = 0; i < object.length; i++) {
                longerObject[i] = object[i];
            }

            //object list is now longer
            object = longerObject;
        }
        object[size] = obj;
        size++;
    }

    public void add (int index, Object obj) {
        Object replicatedObject = new Object();

        if (size == object.length) { // checks if array is of adequate size
            Object longerObject[] = new Object[size * 2];

            System.out.println(size-1);

            // copies original array and makes a new, longer array
            for (int i = 0; i < size; i++) {
                replicatedObject = object[i + 1]; // copies the object in front of the removed item
                object[i] = replicatedObject; // copies it to the removed index
            }

            //object list is now longer
            object = longerObject;
            replicatedObject = null;
        }

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(); // make sure index isn't out of bounds
        } else {
            for (int i = size; i >= index; i--) {
                replicatedObject = object[i-1];
                object[i] = replicatedObject;
            }

            object[index] = obj;
            size++;
        }
    }

    // remove item @ specific index
    public void remove(int index) {
        Object replicatedObject = new Object();
        
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            object[index] = null;
            for (int i = index; i < size; i++) {
                replicatedObject = object[i + 1]; // copies the object in front of the removed item
                object[i] = replicatedObject; // copies it to the removed index
            }
            size -= 1;
        }
    }

    // remove first occurence of obj
    public void remove(Object obj) {
        for (int i = 0; i < size - 1; i++) {
            if (object[i].equals(obj)) {
                remove(i);
                break;
            }
        }
    }

    public void removeAll() {
        object = new Object[1];
        size = 0;
    }

    public boolean contains (Object obj) {
        return indexOf(obj) != -1;
    }

    public void set(int index, Object obj) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            object[index] = obj;
        }
    }
}
