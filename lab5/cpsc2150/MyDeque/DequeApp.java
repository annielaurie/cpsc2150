package cpsc2150.MyDeque;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class DequeApp {
    /**
     * @author Annie Hayes, Marc Caramello
     * @invariants MAX_LENGTH = 100 and MAX_LENGTH > 0
     * 0 <= length of myQ < 100
     * @preconditions [ArrayDeque AND ListDeque AND AbsDeque must be implemented]
     * @postconditions userInput = 1 iff q = ArrayDeque()
     * userInput = 2 iff q = ListDeque()
     * current char = q.deque()
     */
    public static void main(String[] args) {
        IDeque<Character> q = null;
        Scanner myObj = new Scanner(System.in);

        int menuChoiceInput, posInput;
        Character charInput;

        System.out.println("\nEnter 1 for array implementation or 2 for List implementation");
        menuChoiceInput = myObj.nextInt();

        switch (menuChoiceInput) {
            case 1:
                q = new ArrayDeque<Character>();
                break;
            case 2:
                q = new ListDeque<Character>();
                break;
            default:
                System.out.format("%d is not one of the specified options. Exiting program now.", menuChoiceInput);
                System.exit(0);
                break;
        }

        while (2 > 1) {
            System.out.println("\nSelect an option:");
            System.out.println("1.	Add to the end of the Deque");
            System.out.println("2.	Add to the front of the Deque");
            System.out.println("3.	Remove from the front of the Deque");
            System.out.println("4.	Remove from the end of the Deque");
            System.out.println("5.	Peek from the front of the Deque");
            System.out.println("6.	Peek from the end of the Deque");
            System.out.println("7.	Insert to a position in the Deque");
            System.out.println("8.	Remove from a position in the Deque");
            System.out.println("9.	Get a position in the Deque");
            System.out.println("10.	Get the length of the Deque");
            System.out.println("11.	Clear the Deque");
            System.out.println("12.	Quit");
            menuChoiceInput = myObj.nextInt();

            switch (menuChoiceInput) {
                case 1:
                    if (q.length() == IDeque.MAX_LENGTH) {
                        System.out.println("Deque is at the maximum length!");
                        break;
                    }
                    System.out.println("What character to enqueue to the end of the Deque?");
                    charInput = myObj.next().charAt(0);
                    q.enqueue(charInput);
                    break;

                case 2:
                    if (q.length() == IDeque.MAX_LENGTH) {
                        System.out.println("Deque is at the maximum length!");
                        break;
                    }
                    System.out.println("What character to inject to the front of the Deque?");
                    charInput = myObj.next().charAt(0);
                    q.inject(charInput);
                    break;

                case 3:
                    if (q.length() == 0) {
                        System.out.println("Deque is empty!");
                        break;
                    }
                    System.out.format("Character at the front: %c\n", q.dequeue());
                    break;

                case 4:
                    if (q.length() == 0) {
                        System.out.println("Deque is empty!");
                        break;
                    }
                    System.out.format("Character at the end: %c\n", q.removeLast());
                    break;

                case 5:
                    if (q.length() == 0) {
                        System.out.println("Deque is empty!");
                        break;
                    }
                    System.out.format("Peek: %c\n", q.peek());
                    break;

                case 6:
                    if (q.length() == 0) {
                        System.out.println("Deque is empty!");
                        break;
                    }
                    System.out.format("EndOfDeque: %c\n", q.get(q.length()));
                    break;

                case 7:
                    if (q.length() == IDeque.MAX_LENGTH) {
                        System.out.println("Deque is at the maximum length!");
                        break;
                    } else if (q.length() == 0) {
                        System.out.println("Deque is empty!");
                        break;
                    }
                    System.out.println("What character to insert to the Deque?");
                    charInput = myObj.next().charAt(0);

                    do {
                        System.out.println("What position to insert in?");
                        posInput = myObj.nextInt();

                        if (posInput > q.length()) {
                            System.out.println("Not a valid position in the Deque!");
                        }
                    } while (posInput > q.length());

                    q.insert(charInput, posInput);
                    break;

                case 8:
                    if (q.length() == 0) {
                        System.out.println("Deque is empty!");
                        break;
                    }
                    do {
                        System.out.println("What position to remove from the Deque?");
                        posInput = myObj.nextInt();

                        if (posInput > q.length()) {
                            System.out.println("Not a valid position in the Deque!");
                        }
                    } while (posInput > q.length());

                    System.out.format("%c was at position %d in the Deque.\n", q.remove(posInput), posInput);
                    break;

                case 9:
                    if (q.length() == 0) {
                        System.out.println("Deque is empty!");
                        break;
                    }
                    do {
                        System.out.println("What position to get from the Deque?");
                        posInput = myObj.nextInt();

                        if (posInput > q.length()) {
                            System.out.println("Not a valid position in the Deque!");
                        }
                    } while (posInput > q.length());

                    System.out.format("%c is at position %d in the Deque.\n", q.get(posInput), posInput);
                    break;

                case 10:
                    System.out.format("Length of Deque: %d\n", q.length());
                    break;

                case 11:
                    q.clear();
                    System.out.println("Deque is now empty!");
                    break;

                case 12:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Not a valid option!");
                    break;
            }
            System.out.println(q.toString());
        }
    }
}