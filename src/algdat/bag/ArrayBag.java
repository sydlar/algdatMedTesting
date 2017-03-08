package algdat.bag;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by sydlar on 08.03.17.
 */
public class ArrayBag<T> implements Bag<T> {
    private T[] array = createArray(2);
    private int count = 0;

    public void add(T elem){
        sizeCheck();
        array[count++] = elem;
    }

    public int size(){
        return count;
    }

    public Iterator<T> iterator(){
        return Arrays.stream(array).limit(count).iterator();
    }

    @SuppressWarnings("unchecked")
    private T[] createArray(int n){
        return (T[]) new Object[n];
    }

    private void resize(int n){
        array = Arrays.copyOf(array,n);
    }

    private void sizeCheck() {
        if (count == array.length)
            resize(2*count);
    }
}
