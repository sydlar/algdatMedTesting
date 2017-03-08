package algdat.stack;

import java.util.Random;

/**
 * Created by sydlar on 08.03.17.
 */
public class LinkedStackTest extends StackTest<Integer> {
    private Random rGen = new Random();

    public Stack<Integer> createStack(){
        return new LinkedStack<>();
    }

    public Integer createRandomValue() {
        return rGen.nextInt();
    }
}
