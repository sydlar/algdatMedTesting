package algdat.stack;

import java.util.Random;

/**
 * Created by sydlar on 08.03.17.
 */
public class ArrayStackTest extends StackTest<Integer> {
    private Random rGen = new Random();

    public Stack<Integer> createStack(){
        return new ArrayStack<>();
    }

    public Integer createRandomValue() {
        return rGen.nextInt();
    }
}
