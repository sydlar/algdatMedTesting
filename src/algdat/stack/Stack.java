package algdat.stack;

import java.util.ArrayList;
import java.util.Iterator;

public interface Stack<T> extends Iterable<T> {
    void push(T elem);
    T pop();
    int size();

    default T peek(){
        T out = pop();
        push(out);
        return out;
    }

    /* depends on size() */
    default boolean isEmpty(){return size()==0;}

    /*
    dumps stack to ArrayList
    should be replaced by sensible implementation
    */
    default Iterator<T> iterator(){
        ArrayList<T> lst = new ArrayList<>();
        while(!isEmpty()) lst.add(pop());
        for(int i = lst.size()-1; i >= 0; i--) push(lst.get(i));
        return lst.iterator();
    }
}
