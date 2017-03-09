package algdat.stack;

import algdat.exceptions.EmptyStackException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.function.Supplier;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StackTest {
    private static final int MAX_IntegerESInteger_SIZE = 100;
    private static final Random rGen = new Random();
    private static final Supplier<Integer> INTEGER_SOURCE = () -> rGen.nextInt(20)-10;


    @Parameters(name="{index} (0: LinkedStack, 1: ArrayStack)")
    public static Collection<Supplier<Stack<Integer>>> data(){
        return Arrays.asList(LinkedStack::new,ArrayStack::new);
    }

    private final Supplier<Stack<Integer>> supplier;
    private final Supplier<Integer> intSource;
    private Stack<Integer> stack;

    public StackTest(Supplier<Stack<Integer>> theSupplier){
        supplier = theSupplier;
        intSource = INTEGER_SOURCE;
    }

    @Before
    public void init(){
        stack = supplier.get();
    }

    @SuppressWarnings("unchecked")
    private Integer[] createRandomValues(int n){
        Integer[] elems = new Integer[n];
        for(int i = 0; i < elems.length; i++)
            elems[i] = intSource.get();
        return elems;
    }

    private Integer[] createRandomValues(){
        return createRandomValues(new Random().nextInt(MAX_IntegerESInteger_SIZE));
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
        Integer[] elems = createRandomValues();
        for (Integer e : elems) stack.push(e);
        assertEquals("Wrong size of stack", elems.length, stack.size());
        assumeFalse(elems.length == 0);
        assertFalse("Wrong result of isEmpty", stack.isEmpty());
    }

    @Test
    public void testIterator() {
        Integer[] elems = createRandomValues();
        for (Integer e : elems) stack.push(e);

        int pos = elems.length;
        for (Integer s : stack)
            assertEquals("Feil verdi fra iterator", s, elems[--pos]);
        assertEquals("Wrong number of elements in iterator", 0, pos);
    }

    @Test
    public void testPopIteration(){
        Integer[] elems = createRandomValues();
        for(Integer e: elems) stack.push(e);

        int pos = elems.length;
        while(!stack.isEmpty()) {
            assertEquals("Feil størrelse ved pop",stack.size(),pos);
            assertEquals("Feil verdi fra pop", stack.pop(), elems[--pos]);
        }
        assertEquals("Wrong number of elements popped",0,pos);
    }
}