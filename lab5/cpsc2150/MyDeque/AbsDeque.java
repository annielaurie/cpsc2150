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
    public String toString() {
        String entireDeque = "Deque is:\n<";

        for(int i = 0; i < length(); i++) {
            entireDeque = entireDeque.concat(String.valueOf(get(i)));

            if(i != length() - 1) {
                entireDeque = entireDeque.concat(", ");
            }
        }
        entireDeque = entireDeque.concat(">");

        return entireDeque;
    }
}
