package algdat.bag;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by sydlar on 09.03.17.
 */
public class BadSetBag<T> implements Bag<T> {

    Collection<T> set = new HashSet<>();
    @Override
    public void add(T elem) {
        set.add(elem);
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
