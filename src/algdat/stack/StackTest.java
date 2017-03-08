package algdat.stack;

import algdat.exceptions.EmptyStackException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

/**
 * Created by sydlar on 08.03.17.
 */
public abstract class StackTest<T> {
    private static final int MAX_TEST_SIZE = 100;

    abstract Stack<T> createStack();
    abstract T createRandomValue();

    private Stack<T> stack;

    @Before
    public void init(){
        stack = createStack();
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
    public void testEmptyIsEmpty(){
        assertTrue("Stack is initially not empty",stack.isEmpty());
    }

    @Test
    public void testEmptySize(){
        assertEquals("Initial stack size is nonzero",0,stack.size());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = EmptyStackException.class)
    public void testEmptyPop(){
        stack.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyPeek(){
        stack.peek();
    }

    @Test
    public void testFill() {
        T[] elems = createRandomValues();
        for (T e : elems) stack.push(e);
        assertEquals("Wrong size of stack", elems.length, stack.size());
        assumeFalse(elems.length == 0);
        assertFalse("Wrong result of isEmpty", stack.isEmpty());
    }

    @Test
    public void testIterator() {
        T[] elems = createRandomValues();
        for (T e : elems) stack.push(e);

        int pos = elems.length;
        for (T s : stack)
            assertEquals("Feil verdi fra iterator", s, elems[--pos]);
        assertEquals("Wrong number of elements in iterator", 0, pos);
    }

    @Test
    public void testPopIteration(){
        T[] elems = createRandomValues();
        for(T e: elems) stack.push(e);

        int pos = elems.length;
        while(!stack.isEmpty()) {
            assertEquals("Feil størrelse ved pop",stack.size(),pos);
            assertEquals("Feil verdi fra pop", stack.pop(), elems[--pos]);
        }
        assertEquals("Wrong number of elements popped",0,pos);
    }
}