package algdat.stack;

import java.util.Random;

public class LinkedStackTest extends StackTest<Integer> {
    private Random rGen = new Random();

    public Stack<Integer> createStack(){
        return new LinkedStack<>();
    }

    public Integer createRandomValue() {
        return rGen.nextInt();
    }
}
