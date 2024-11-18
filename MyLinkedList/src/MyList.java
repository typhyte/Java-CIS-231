public interface MyList {
    // returns the amount of items in the list
    public int size(); //done

    // gets data from given index from list
    public Object get (int index); //done

    // adders
    public void add(Object obj); //done
    public void add(int index, Object obj); //done

    // removers
    public void remove(int index); //done
    public void remove(Object obj); //done
    public void removeAll(); //done

    // sets
    public void set(int index, Object obj); //done
    
    // contains a certain substring (?)
    public boolean contains(Object obj); //done
    
    // returns index of substring
    public int indexOf(Object obj); //done

    // returns true if list has nothing
    public boolean isEmpty(); //done
}