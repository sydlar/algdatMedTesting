package algdat.bag;

import java.util.Random;

/*
 * Created by sydlar on 08.03.17.
 */
public class ArrayBagTest extends BagTest<Integer> {

    private Random rGen = new Random();

    public Bag<Integer> createBag(){
        return new ArrayBag<>();
    }

    public Integer createRandomValue() {
        return rGen.nextInt();
    }
}