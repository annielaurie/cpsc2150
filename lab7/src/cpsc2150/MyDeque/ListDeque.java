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
        myQ = new ArrayList<T>();
    }

    /**
     * adds character x to end of list
     * @param x, the character being added to list
     */

    public void enqueue(T x) {
        if (myQ.size() < MAX_LENGTH)
        {
            myQ.add(x);
        }
    }

    /**
     * removes front character in the list and adjusts array accordingly
     * @return frontChar, the character at the front of the list
     */

    public T dequeue() {
        T frontChar = myQ.get(0);
        myQ.remove(0);
        return frontChar;
    }

    /**
     * adds character to the front of the list
     * @param x, the character being added to list
     */
    public void inject(T x) {
        myQ.add(0, x);
    }

    /**
     * removes and returns the last array value and adjusts list accordingly
     * @return lastChar, the character that at the end of the list
     */
    public T removeLast() {
        T lastIndex = myQ.get(myQ.size() - 1);

        myQ.remove(myQ.size() - 1);
        return lastIndex;
    }

    /**
     * returns length of list
     * @return myQ.size(), the number of characters in the list
     */

    public Integer length() {
        return myQ.size();
    }

    /**
     * clears the list
     */
    public void clear() {
        myQ.clear();
    }
}