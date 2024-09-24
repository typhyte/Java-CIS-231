public class MyArrayList<T> implements MyList {
    //<T> allows the class to be any type

    int size;
    Object[] object = new Object[1];
    
    public int size() {
        return size;
    }

    public Object get (int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return object[index];
        }
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

    public int indexOf(Object obj) {
        for (int i=0; i < size; i++) {
            if (object[i] == obj) {
                return i;
            }
        }

        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void removeAll() {
        object = new Object[1];
        size = 0;
    }
}
