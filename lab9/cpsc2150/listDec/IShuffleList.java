package cpsc2150.listDec;

import java.util.List;
import java.util.Random;

public interface IShuffleList<T> extends List<T>{

    default void shuffle(int swaps)
    {
        Random rand = new Random();
        for(int i = 0; i < swaps; i++)
        {
            int first = rand.nextInt(this.size());
            int second = rand.nextInt(this.size());
            this.swap(first, second);
        }


    }
    default void swap(int i, int j)
    {
        T first = this.get(i);
        T second = this.get(j);
        this.set(j, first);
        this.set(i, second);
    }

}
