package cpsc2150.MyDeque;
import java.util.*;
/**
 * @author          Annie Hayes, Marc Caramello
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
 */
public class ListDeque implements IDeque {
    // this time store the deque in a list
    // myQ.get(0) is the front of the deque
    private List<Character> myQ;

    /**
     * initializes myQ by setting all values equal to 0
     * @param
     * @return
     */
    public ListDeque() {
        myQ = new ArrayList<>();
    }

    /**
     * adds character x to end of list
     * @param x the character being added to list
     * @return void
     */
    @Override
    public void enqueue(Character x) {
        myQ.add(x);
    }

    /**
     * removes front character in array and adjusts array accordingly
     * @param
     * @return frontChar the character at the front of the list
     */
    @Override
    public Character dequeue() {
        char frontChar = myQ.get(0);
        myQ.remove(0);
        return frontChar;
    }

    /**
     * adds character to the front of the list
     * @param x the character being added to list
     * @return void
     */
    @Override
    public void inject(Character x) {
        myQ.add(0, x);
    }

    /**
     * removes and returns the last array value and adjusts list accordingly
     * @param
     * @return lastChar the character that at the end of the list
     */
    @Override
    public Character removeLast() {
        int lastIndex = myQ.size() - 1;
        char LastChar = myQ.get(lastIndex);
        myQ.remove(lastIndex);
        return LastChar;
    }

    /**
     * returns length of list
     * @param
     * @return length the number of characters in list
     */
    @Override
    public int length() {
        return myQ.size();
    }

    /**
     * clears the list
     * @param
     * @return void
     */
    @Override
    public void clear() {
        myQ.clear();
    }
}