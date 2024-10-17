public interface MyList {
    // returns the amount of items in the list
    public int size();

    // gets data from given index from list
    public Object get (int index);

    // adders
    public void add(Object obj);
    // public void add(int index, Object obj);

    // removers
    public void remove(int index);
    // public void remove(Object obj);
    public void removeAll();

    // sets
    public void set(int index, Object obj);
    
    //contains a certain substring (?)
    public boolean contains(Object obj);
    
    //returns index of substring
    public int indexOf(Object obj);

    //returns true if list has nothing
    public boolean isEmpty();
}