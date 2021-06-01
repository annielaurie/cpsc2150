package cpsc2150.MyDeque;
import java.util.*;
/**
 * @author          Annie Hayes, Marc Caramello
 *
 * @invariants      MAX_LENGTH = 100 and MAX_LENGTH > 0
 *                  0 <= length of myQ < 100
 *
 * @preconditions   [IDeque must be implemented]
 *                  myQ is not NULL
 *
 * @postconditions  myQ is initialized
 *                  frontChar = first value of myQ
 *                  lastIndex = size of myQ - 1
 *                  lastChar = last value of myQ
 *
 * @coorespondences
 */
public class ListDeque<T> extends AbsDeque<T> implements IDeque<T> {
    private List<T> myQ;

    /**
     * initializes myQ by setting all values equal to 0
     * @post myQ = empty char list
     */
    public ListDeque() {
        myQ = new ArrayList<>();
    }

    /**
     * adds character x to end of list
     * @param x, the character being added to list
     */
    @Override
    public void enqueue(T x) {
        myQ.add(x);
    }

    /**
     * removes front character in the list and adjusts array accordingly
     * @return frontChar, the character at the front of the list
     */
    @Override
    public T dequeue() {
        T frontChar = myQ.get(0);
        myQ.remove(0);
        return frontChar;
    }

    /**
     * adds character to the front of the list
     * @param x, the character being added to list
     */
    @Override
    public void inject(T x) {
        myQ.add(0, x);
    }

    /**
     * removes and returns the last array value and adjusts list accordingly
     * @return lastChar, the character that at the end of the list
     */
    @Override
    public T removeLast() {
        int lastIndex = myQ.size() - 1;
        T[] lastElement = (T[]) new Object[(int) myQ.get(lastIndex)];

        myQ.remove(lastIndex);
        return (T) lastElement;
    }

    /**
     * returns length of list
     * @return myQ.size(), the number of characters in the list
     */
    @Override
    public Integer length() {
        return myQ.size();
    }

    /**
     * clears the list
     */
    @Override
    public void clear() {
        myQ.clear();
    }
}