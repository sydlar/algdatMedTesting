package algdat.bag;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BagTest {
    private static final int MAX_TEST_SIZE = 1000;
    private static final Random rGen = new Random();
    private static final Supplier<Integer> INTEGER_SOURCE = () -> rGen.nextInt(100)- 50;

    @Parameters(name = "{index} [0: ArrayBag, 1: LinkedBag, 2: BadSetBag]")
    public static Collection<Supplier<Bag<?>>> data(){
        return Arrays.asList(ArrayBag::new, LinkedBag::new, BadSetBag::new);
    }

    private Supplier<Bag<Integer>> bagSupplier;
    private Supplier<Integer> valueSupplier = INTEGER_SOURCE;
    private Bag<Integer> bag;

    public BagTest(Supplier<Bag<Integer>> supplier){bagSupplier = supplier;}

    @Before
    public void init(){bag = bagSupplier.get();}

    @SuppressWarnings("unchecked")
    private Integer[] createRandomValues(int n){
        Integer[] elems = new Integer[n];
        for(int i = 0; i < elems.length; i++)
            elems[i] = valueSupplier.get();
        return elems;
    }

    private Integer[] createRandomValues(){
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
        for(Integer b: bag) count++;
        assertEquals(0,count);
    }


    @Test
    public void testSize(){
        Integer[] elems = createRandomValues();
        for(Integer e: elems) bag.add(e);
        assertEquals("Wrong size of bag",elems.length,bag.size());
    }

    @Test
    public void testIterator(){
        Integer[] elems = createRandomValues();
        for(Integer e : elems) bag.add(e);

        int count = 0;
        for(Integer b: bag) {
            count++;
            boolean found = false;
            for(Integer e: elems){
                if (e.equals(b)) {
                    found = true;
                    break;
                }
            }
            assertTrue("Bag element not found in array of test values",found);
        }
        assertEquals("Wrong number of elements in iterator",elems.length,count);

        for(Integer e : elems){
            boolean found = false;
            for(Integer b : bag) {
                if (b.equals(e)){
                    found = true;
                    break;
                }
            }
            assertTrue("Test array element not found in bag",found);
        }
    }

}