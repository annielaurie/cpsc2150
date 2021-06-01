package cpsc2150.MyDeque;

/**
 * A deque containing characters.
 * A deque is a data structure a double-ended queue that allows you
 * to insert and remove from both ends.
 * This deque is bounded by MAX_LENGTH
 * @author          Annie Hayes, Marc Caramello
 * @invariants      MAX_LENGTH = 100 and MAX_LENGTH > 0
  *                 0 <= length of myQ < 100
  *                 0 <= mylength < 100
 * @preconditons    [ArrayDeque AND DequeApp AND ListDeque are implemented]
 * @postconditions  enqueue method is initiated
 *                  deque method is initiated
 *                  inject method is initiated
 *                  removeLast method is initiated
 *                  length method is initiated
 *                  clear method is initiated
 *
 */
public interface IDeque {
    public static final int MAX_LENGTH = 100;

    /**
     * @pre     x is not null
     * @post    x is added to the end of deque
     */
    // Adds x to the end of the deque
    public void enqueue(Character x);
    /**
     * @post    remove first character of deque
     *          returns character
     *          adjusts length of deque
     */
    //removes and returns the Character at the front of the deque
    public Character dequeue();
    /**
     * @pre     x is not null
     * @post    x is added to the front of deque
     *          adjusts length of deque
     */
    // Adds x to the front of the deque
    public void inject(Character x);
    /**
     * @post    removes last character in the deque
     *          returns last character
     *          adjusts legth of deque
     */
    //removes and returns the Character at the end of the deque
    public Character removeLast();
    /**
     * @post    returns length of deque
     */
    //returns the number of Characters in the deque
    public int length();

    /**
     * @post    deque is cleared
     */
    //clears the entire deque
    public void clear();
}
