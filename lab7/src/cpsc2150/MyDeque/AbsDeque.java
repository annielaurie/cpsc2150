package cpsc2150.MyDeque;

import java.util.List;
/**
 * @author          Annie Hayes, Marc Caramello
 *
 * @invariants      MAX_LENGTH = 100 and MAX_LENGTH > 0
 *                  0 <= length of myQ < 100
 *
 * @preconditions   [IDeque must be implemented]
 *                  queueList is not NULL
 *
 * @postconditions  entireDeque = string of queueList

 * @coorespondences
 */
public abstract class AbsDeque<T> implements IDeque<T> {
   @Override
    public String toString() {
        String deque = "<";
        int length = length();
        for (int i = 1; i < length + 1; i++) { //shifting by 1 nad starting at index at 1
            if (i == length()) {
                deque += get(i);
            } else {
                deque += (get(i) + ", ");

            }

        }
        deque += ">";
        return deque;

    }
}
