package cpsc2150.MyDeque;

import java.util.ArrayList;
import java.util.List;

/**
 * @author          Annie Hayes, Marc Caramello
 *
 * @invariants      MAX_LENGTH = 100 and MAX_LENGTH > 0
 *                  0 <= length of myQ < 100
 *
 * @preconditions   [IDeque is implemented]
 *                  MAX_LENGTH = 100
 *
 * @postconditions  frontChar = first value in array
 *                  lastChar = last value in array
 *                  myLength = length of array
 *
 * @coorespondences
 */
public class ArrayDeque<T> extends AbsDeque<T> implements IDeque<T> {
    private int myLength;
    private T[] myQ;

    /**
     * creates the mQ character array
     * @post myQ = array[MAX_LENGTH]
     */
    public ArrayDeque() {
        myQ = (T[]) new Object[IDeque.MAX_LENGTH];
        myLength = 0;
    }

    /**
     * adds character x to end of array
     * @param value, the character being added to array
     */
    @Override
    public void enqueue(T value) {
        myQ[myLength] = value;
        myLength++;
    }

    /**
     * removes front character in array and adjusts array accordingly
     * @return frontChar, the character at the front of the array
     */
    @Override
    public T dequeue() {
        T frontChar = myQ[0];

        for(int i = 1; i < myLength; i++) {
            myQ[i - 1] = myQ[i];
        }
        myLength--;
        return frontChar;
    }

    /**
     * adds character to the front of the array
     * @param value, the character being added to array
     */
    @Override
    public void inject(T value) {
        T[] tempArray = (T[]) new Object[myLength];

        if(myLength == 0) {
            myQ[0] = value;
        }
        for(int i = 0; i < myLength; i++) {
            tempArray[i] = myQ[i];
        }
        for(int i = 1; i <= myLength; i++) {
            myQ[0] = value;
            myQ[i] = tempArray[i - 1];
        }
        myLength++;
    }

    /**
     * removes and returns the last array value and adjusts array accordingly
     * @return lastChar, the character that at the end of the array
     */
    @Override
    public T removeLast() {
        T lastChar = myQ[myLength - 1];
        myQ[myLength - 1] = (T) "\0";
        myLength--;
        return lastChar;
    }

    /**
     * returns length of array
     * @return myQ.size(), the number of characters in the array
     */
    @Override
    public Integer length() {
        return myLength;
    }

    /**
     * clears the array
     */
    @Override
    public void clear() {
        for(int i = 0; i < myLength; i++) {
            myQ[i] =(T) "\0";
        }
        myLength = 0;
    }
}