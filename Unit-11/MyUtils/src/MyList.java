public interface MyList {
    //returns the amount of items in the list
    public int size();

    //gets data from given index from list
    public Object get (int index);

    //adders
    public void add(Object obj);
    // public void add(int index, Object obj);

    // //removers
    // public void remove(int index);
    // public void remove(Object obj);

    // //sets
    // void set(int index, Object obj);
    
    // //contains a certain substring (?)
    // boolean contains(Object obj);
    
    //returns index of substring
    int indexOf(Object obj);

    //returns true if list has nothing
    boolean isEmpty();
}