package algdat.stack;

import java.util.ArrayList;
import java.util.Iterator;

public interface Stack<T> extends Iterable<T> {

    /**
     * Legger elementet elem øverst i stakken
     */
    void push(T elem);

    /**
     * Returnerer og fjerner det sist tillagte elementet
     * i stakken.
     */
    T pop();

    /**
     * Returnerer antallet elementer på stakken.
     *
     * Størrelsen avtar med 1 ved hvert kall av pop(),
     * og øker med 1 ved hvert kall av push().
     */
    int size();

    /**
     * Returnerer det elementet som litter øvert på stakken.
     */
    default T peek(){
        T out = pop();
        push(out);
        return out;
    }

    /**
     * Returnerer true dersom stakken er tom.
     * Ellers returneres false.
     */
    default boolean isEmpty(){return size()==0;}


    /**
     * Returnerer en iterator som lar oss iterere
     * over elementee på stakken.
     */
    default Iterator<T> iterator(){
        ArrayList<T> lst = new ArrayList<>();
        while(!isEmpty()) lst.add(pop());
        for(int i = lst.size()-1; i >= 0; i--) push(lst.get(i));
        return lst.iterator();
    }
}
