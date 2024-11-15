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
        Object longerObject[] = new Object[size * 2];
        Object objAtIndex = object[index];

        // copies original array and makes a new, longer array
        for (int i = 0; i < object.length-1; i++) {
            if (i == index) {
                object[index+1] = objAtIndex;
            }
            longerObject[i] = object[i];
        }

        //object list is now longer
        object = longerObject;

        object[index] = obj;
        size++;
    }

    // remove item @ specific index
    public void remove(int index) {
        Object replicatedObject = new Object();
        
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            object[index] = null; // null TUAH! delete that thang!
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
