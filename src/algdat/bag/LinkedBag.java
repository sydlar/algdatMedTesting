package algdat.bag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by sydlar on 08.03.17.
 */
public class LinkedBag<T> implements Bag<T> {

    private Node top = null;
    private int count = 0;


    public void add(T elem){
        count++;
        top = new Node(elem,top);
        return;
    }

    public Iterator<T> iterator(){
        return new Itr();
    }

    public int size(){
        return count;
    }

    private class Node {
        T data;
        Node next;
        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    private class Itr implements Iterator<T> {
        Node cursor = new Node(null,top);
        public boolean hasNext(){return cursor.next != null;}
        public T next(){ cursor = cursor.next; return cursor.data;}
    }
}
