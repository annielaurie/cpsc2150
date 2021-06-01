package cpsc2150.MyDeque;

/**
 * A deque containing characters.
 * A deque is a data structure a double-ended queue that allows you
 * to insert and remove from both ends.
 * This deque is bounded by MAX_LENGTH
 *
 * @author          Annie Hayes, Marc Caramello
 *
 * @constraints     MAX_LENGTH = 100 and MAX_LENGTH > 0
 *                 0 <= length of myQ < 100
 *                 0 <= mylength < 100
 *                 initialization of all variables
 *
 * @preconditons    [ArrayDeque AND DequeApp AND ListDeque AND AbsDeque are implemented]
 *
 * @postconditions  enqueue method is initiated
 *                  deque method is initiated
 *                  inject method is initiated
 *                  removeLast method is initiated
 *                  length method is initiated
 *                  clear method is initiated
 */
public interface IDeque<T> {
    public static final int MAX_LENGTH = 100;

    /**
     * @pre     x is not null
     *          size < MAX_LENGTH
     * @post    x is added to the end of deque
     * @param value
     */
    public void enqueue(T value);

    /**
     * @pre     size > 0
     * @post    remove first character of deque
     *          returns character
     *          adjusts length of deque
     */
    public T dequeue();

    /**
     * @pre     x is not null
     *          size < MAX_LENGTH
     * @post    x is added to the front of deque
     *          adjusts length of deque
     * @param value
     */
    public void inject(T value);

    /**
     * @pre     size > 0
     * @post    removes last character in the deque
     *          returns last character
     *          adjusts legth of deque
     */
    public T removeLast();

    /**
     * @post    returns length of deque
     *          deque doesn't change
     */
    public Integer length();

    /**
     * @post    deque is cleared
     */
    public void clear();

    /**
     * @pre     size > 0
     * @post    returns first character in deque
     */
    default T peek()
    {
        if(length() == 0)
        {
            System.out.println("Deque is empty");
            return null;
        }
        else
        {
            T value = dequeue();
            inject(value);
            return value;
        }
    }

    /**
     * @pre     size > 0
     * @post    returns last character in deque
     */
    default T endOfDeque()
    {
        if (length() == 0)
        {
            System.out.println("Deque is empty");
            return null;
        }
        else
        {
            T value = removeLast();
            enqueue(value);
            return value;
        }
    }

    /**
     * @pre     posInput > q.length()
     *          size > 0
     * @post    c is inserted at pos
     */
    
    default void insert(T value, Integer pos) {
        if (pos == 0)
        {
            inject(value);
        }
        else {
            T tempArray[] = (T[]) new Object[pos];

            for (int i = pos; i > 0; i--) {
                tempArray[i - 1] = dequeue();
            }
            for (int i = pos; i < tempArray.length; i++) {
                inject(tempArray[i]);
            }
        }        
    }

    /**
     * @pre     size > 0
     * @post    remove character that is at pos
     *          returns character
     *          adjusts length of deque
     */
    default T remove (Integer pos)
    {
        if (pos == 0)
        {
            T value = dequeue();
            return value;
        }
        T arr[] = (T[]) new Object[pos];
        for (int i=pos-1; i> 0; i--)
        {
            arr[i-1]=dequeue();
        }
        T value = dequeue();
        for (int i=0; i < arr.length-1; i++)
        {
            inject(arr[i]);
        }
        return value;

    }

    /**
     * @pre     size > 0
     *          pos < size
     * @post    returns character at pos
     */
    default T get(Integer pos)
    {
        if (pos == 0)
        {
            T value = dequeue();
            return value;
        }
        T arr[] = (T[]) new Object[pos];
        for (int i = pos; i > 0; i--)
        {
            arr[i-1] = dequeue();
        }
        T value = dequeue();
        inject(value);
        for(int i = 0; i < arr.length; i++)
        {
            inject(arr[i]);
        }

        return value;
    }

}
