package algdat.bag;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Created by sydlar on 08.03.17.
 */
public abstract class BagTest<T> {
    int MAX_TEST_SIZE = 1000;

    private Bag<T> bag;

    abstract Bag<T> createBag();
    abstract T createRandomValue();

    @Before
    public void init(){
        bag = createBag();
    }

    @SuppressWarnings("unchecked")
    private T[] createRandomValues(int n){
        T[] elems = (T[]) new Object[n];
        for(int i = 0; i < elems.length; i++)
            elems[i] = createRandomValue();
        return elems;
    }

    private T[] createRandomValues(){
        return createRandomValues(new Random().nextInt(MAX_TEST_SIZE));
    }

    @Test
    public void testIsEmpty(){
        assertTrue(bag.isEmpty());
    }

    @Test
    public void testSizeEmpty(){
        assertEquals(0,bag.size());
    }

    @Test
    public void testIteratorEmpty(){
        int count = 0;
        for(T b: bag) count++;
        assertEquals(0,count);
    }


    @Test
    public void testSize(){
        T[] elems = createRandomValues();
        for(T e: elems) bag.add(e);
        assertEquals("Wrong size of bag",elems.length,bag.size());
    }

    @Test
    public void testIterator(){
        T[] elems = createRandomValues();
        for(T e : elems) bag.add(e);

        int count = 0;
        for(T b: bag) {
            count++;
            boolean found = false;
            for(T e: elems){
                if (e.equals(b)) {
                    found = true;
                    break;
                }
            }
            assertTrue("Bag element not found in array of test values",found);
        }
        assertEquals("Wrong number of elements in iterator",elems.length,count);

        for(T e : elems){
            boolean found = false;
            for(T b : bag) {
                if (b.equals(e)){
                    found = true;
                    break;
                }
            }
            assertTrue("Test array element not found in bag",found);
        }
    }

}