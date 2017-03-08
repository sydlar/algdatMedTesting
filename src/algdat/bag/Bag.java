package algdat.bag;

import java.util.Iterator;

public interface Bag<T> extends Iterable<T> {
    void add(T elem);
    int size();
    Iterator<T> iterator();
    default boolean isEmpty(){return size()==0;}
}