package cpsc2150.MyDeque;
import java.util.Scanner;


public class DequeApp {
    /**
     * @author          Annie Hayes, Marc Caramello
     * @invariants      MAX_LENGTH = 100 and MAX_LENGTH > 0
     *                  0 <= length of myQ < 100
     * @preconditions   [ArrayDeque AND ListDeque must be implemented]
     * @postconditions  userInput = 1 iff q = ArrayDeque()
     *                  userInput = 2 iff q = ListDeque()
     *                  current char = q.deque()
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("\nSelect implementation:");
        System.out.println("1. Array");
        System.out.println("2. List\n");

        System.out.print("Input number here ---> ");
        int userInput = myObj.nextInt();

        IDeque q = null;

        if(userInput == 1) {
            q = new ArrayDeque();
        }
        else if(userInput == 2) {
            q = new ListDeque();
        }

        Character x = 'a';
        if (q != null) {
            q.enqueue(x);
            x = 'k';
            q.enqueue(x);
            x = 'j';
            q.enqueue(x);
            x = '1';
            q.enqueue(x);
            x = 'f';
            q.enqueue(x);
        }

        char currentChar;
        //print out chars
        for(int i = 0; i < q.length(); i++) {
            currentChar = q.dequeue();
            q.enqueue(currentChar);
            System.out.format("%c ", currentChar);  // FIX: The print won't work
        }
        System.out.println();
    }
}
