package algdat.bag;

import java.util.Iterator;

public interface Bag<T> extends Iterable<T> {

    /**
     * Leger elementet `elem` inn i beholderen
     */
    void add(T elem);

    /**
     * Returnerer antallet elementer som er lagt inn
     * i beholdren.
     *
     * size() skal alltid returnere antallet kall av `add`.
     */
    int size();

    /**
     * Returnerer en iterator som gir tilgang til alle
     * elementene i beholderen.
     */
    Iterator<T> iterator();

    /**
     * Returnerer true dersom beholderen ikke inneholder
     * noen elementer.
     *
     * isEmpty() skal alltid gi samme resultat som testen size() == 0
     */
    default boolean isEmpty(){return size()==0;}
}