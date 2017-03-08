package algdat.stack;

import algdat.exceptions.EmptyStackException;
import sun.invoke.empty.Empty;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by sydlar on 08.03.17.
 */
public class ArrayStack<T> implements Stack<T> {

    private T[] array = createArray(2);
    private int count = 0;

    public void push(T elem){
        sizeCheck();
        array[count++] = elem;
    }

    public T pop(){
        if(count == 0) throw new EmptyStackException();

        sizeCheck();
        T out = array[--count];
        array[count] = null; // To let gc do it's job
        return out;
    }

    public T peek(){
        if(count == 0) throw new EmptyStackException();
        return array[count-1];
    }

    public int size(){
        return count;
    }

    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        int here = count;
        public boolean hasNext(){return here > 0;}
        public T next(){return array[--here];}
    }

    @SuppressWarnings("unchecked")
    private T[] createArray(int n){
        return (T[]) new Object[n];
    }

    private void resize(int n){
        array = Arrays.copyOf(array,n);
    }

    private void sizeCheck() {
        if (count == array.length || (count > 0 && 4*count <= array.length))
            resize(2*count);
    }

}
