package cpsc2150.sets;

import java.util.List;

public class ArraySet<T> extends SetAbs<T> implements ISet<T> {
    /**
     * Correspondences size = arraySet.size() and self = arraySet
     *
     * @invariants [set contains no duplicate values]
     */

    private final T[] arraySet;
    private int arraySize;


    /**
     * @post [Set is empty]
     */
    @SuppressWarnings("unchecked")
    public ArraySet() {
        arraySet = (T[]) new Object[MAX_SIZE];
        arraySize = 0;
    }

    public void add(T val) {
        arraySet[arraySize] = val;
        arraySize++;
    }


    public T remove() {
        T val = arraySet[arraySize - 1];
        if (arraySize-1 > 0) {
            arraySet[arraySize - 1] = null;
        }
        arraySize--;
        return val;
    }


    public boolean contains(T val) {
        for (int i = 0; i < arraySize; i++)
        {
            if(arraySet[i].equals(val))
            {
                return true;
            }
        }
        return false;
    }


    public int getSize() {
        return arraySize;
    }
}
