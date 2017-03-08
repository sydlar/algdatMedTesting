package algdat.bag;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by sydlar on 08.03.17.
 */
public class LinkedBagTest extends BagTest<Integer> {
    private Random rGen = new Random();

    public Bag<Integer> createBag(){
        return new LinkedBag<>();
    }

    public Integer createRandomValue() {
        return rGen.nextInt();
    }

}