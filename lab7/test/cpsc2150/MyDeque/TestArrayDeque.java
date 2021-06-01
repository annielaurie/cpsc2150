package cpsc2150.MyDeque;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDeque {
    private IDeque<Character> MakeADeque() {
        return new ArrayDeque<>();
    }

    //enqueue test 1
    @Test
    public void testEnqueueArray()
    {
        IDeque<Character> test1 = MakeADeque();
        test1.enqueue('a');
        assert(test1.toString().equals("<a>"));

    }

    //enqueue test 2
    @Test
    public void testEnqueueHalf()
    {
        IDeque<Character> test2 = MakeADeque();
        StringBuilder testString = new StringBuilder("<");
        test2.enqueue('a');
        for (int i = 0; i < 10; i++)
        {
            test2.enqueue('a');
            testString.append("a, ");
        }
        test2.enqueue('a');
        testString.append("a, a>");
        assert(test2.toString().equals(testString.toString()));


    }
    //enqueue test 3
    @Test
    public void testEnqueueFull()
    {
        IDeque<Character> test3 = MakeADeque();
        StringBuilder testString = new StringBuilder("<");
        test3.enqueue('a');
        for (int i = 0; i < 98; i++)
        {
            test3.enqueue('a');
            testString.append("a, ");
        }
        test3.enqueue('a');
        testString.append("a, a>");
        assert(test3.toString().equals(testString.toString()));
    }

    //dequeue test 1
    @Test
    public void testDequeueEmpty()
    {
        IDeque<Character> test1 = MakeADeque();
        test1.enqueue('a');
        test1.dequeue();
        assert(test1.toString().equals("<>"));

    }
    //dequeue test 2
    @Test
    public void testDequeueHalf()
    {
        IDeque<Character> test2 = MakeADeque();
        StringBuilder testString = new StringBuilder("<");
        test2.enqueue('a');
        for (int i = 0; i < 5; i++)
        {
            test2.enqueue('a');
            testString.append("a, ");
        }

        test2.inject('b');
        testString.append("a>");
        assert(test2.dequeue().equals('b'));
        assert(test2.toString().equals(testString.toString()));


    }
    //dequeue test 3
    @Test
    public void testDequeueFull()
    {
        IDeque<Character> test3 = MakeADeque();
        StringBuilder testString = new StringBuilder("<");
        test3.enqueue('a');
        for (int i = 0; i < 98; i++)
        {
            test3.enqueue('a');
            testString.append("a, ");
        }
        test3.inject('b');
        testString.append("a>");
        assert(test3.dequeue().equals('b'));
        assert(test3.toString().equals(testString.toString()));
    }

    //inject test 1
    @Test
    public void testInjectEmpty()
    {
        IDeque<Character> test1 = MakeADeque();
        test1.inject('a');
        assert(test1.toString().equals("<a>"));

    }

    //inject test 2
    @Test
    public void testInjectHalf()
    {
        IDeque<Character> test2 = MakeADeque();
        StringBuilder testString = new StringBuilder("<");
        test2.inject('a');
        for (int i = 0; i < 10; i++)
        {
            test2.inject('a');
            testString.append("a, ");
        }
        test2.inject('a');
        testString.append("a, a>");
        assert(test2.toString().equals(testString.toString()));


    }

    //inject test 3
    @Test
    public void testInjectFull()
    {
        IDeque<Character> test3 = MakeADeque();
        StringBuilder testString = new StringBuilder("<");
        test3.inject('a');
        for (int i = 0; i < 98; i++)
        {
            test3.inject('a');
            testString.append("a, ");
        }
        test3.inject('a');
        testString.append("a, a>");
        assert(test3.toString().equals(testString.toString()));
    }

    //removeLast test 1
    @Test
    public void testRemoveLastEmpty()
    {
        IDeque<Character> test1 = MakeADeque();
        test1.enqueue('a');
        assert(test1.removeLast().equals('a'));
        assert(test1.toString().equals("<>"));

    }
    //removeLast test 2
    @Test
    public void testRemoveLastHalf()
    {
        IDeque<Character> test2 = MakeADeque();
        StringBuilder testString = new StringBuilder("<");
        test2.enqueue('a');
        for (int i = 0; i < 10; i++)
        {
            test2.enqueue('a');
            testString.append("a, ");
        }
        test2.enqueue('b');
        testString.append("a>");
        assert(test2.removeLast().equals('b'));
        assert(test2.toString().equals(testString.toString()));


    }
    //removeLast test 3
    @Test
    public void testRemoveLastFull()
    {
        IDeque<Character> test3 = MakeADeque();
        StringBuilder testString = new StringBuilder("<");
        test3.enqueue('a');
        for (int i = 0; i < 98; i++)
        {
            test3.enqueue('a');
            testString.append("a, ");
        }
        test3.enqueue('b');
        testString.append("a>");
        assert(test3.removeLast().equals('b'));
        assert(test3.toString().equals(testString.toString()));
    }
    //clear test 1
    @Test
    public void testClearEmpty()
    {
        IDeque<Character> test1 = MakeADeque();
        test1.clear();
        assert(test1.toString().equals("<>"));

    }
    //clear test 2
    @Test
    public void testClearHalf()
    {
        IDeque<Character> test2 = MakeADeque();
        for (int i = 0; i < 10; i++)
        {
            test2.enqueue('a');
        }
        test2.clear();

        assert(test2.toString().equals("<>"));

    }

    //clear test 3
    @Test
    public void testClearFull()
    {
        IDeque<Character> test3 = MakeADeque();
        for (int i = 0; i < 100; i++)
        {
            test3.enqueue('a');
        }
        test3.clear();

        assert(test3.toString().equals("<>"));

    }

    //peek test 1
    @Test
    public void testPeakStart()
    {
        IDeque<Character> test1 = MakeADeque();
        test1.enqueue('a');

        assert(test1.peek().equals('a'));
        assert(test1.toString().equals("<a>"));
    }

    //peek test 2
    @Test
    public void testPeakHalf()
    {
        IDeque<Character> test2 = MakeADeque();
        test2.enqueue('a');
        test2.enqueue('a');
        test2.enqueue('b');
        test2.enqueue('a');
        test2.enqueue('a');

        assert(test2.peek().equals('a'));
        assert(test2.toString().equals("<a, a, b, a, a>"));

    }

    //peek test 3
    @Test
    public void testPeakLast()
    {
        IDeque<Character> test3 = MakeADeque();
        StringBuilder testString = new StringBuilder("<");

        for (int i = 0; i < 99; i++)
        {
            test3.enqueue('a');
            testString.append("a, ");
        }
        test3.insert('b',100);
        testString.append("b>");

        assert(test3.toString().equals(testString.toString()));
        assert(test3.peek().equals('a'));

    }

    //peek test 1
    @Test
    public void testEndOfDequeStart()
    {
        IDeque<Character> test1 = MakeADeque();
        test1.enqueue('a');

        assert(test1.endOfDeque().equals('a'));
        assert(test1.toString().equals("<a>"));
    }

    //peek test 2
    @Test
    public void testEndOfDequeHalf()
    {
        IDeque<Character> test2 = MakeADeque();
        test2.enqueue('a');
        test2.enqueue('a');
        test2.enqueue('a');
        test2.enqueue('a');
        test2.enqueue('b');

        assert(test2.endOfDeque().equals('b'));
        assert(test2.toString().equals("<a, a, a, a, b>"));
    }

    //peek test 3
    @Test
    public void testEndOfDequeLast()
    {
        IDeque<Character> test3 = MakeADeque();
        StringBuilder testString = new StringBuilder("<");

        for (int i = 0; i < 99; i++)
        {
            test3.enqueue('a');
            testString.append("a, ");
        }
        test3.enqueue('b');
        testString.append("b>");

        assert(test3.toString().equals(testString.toString()));
        assert(test3.endOfDeque().equals('b'));
    }

    //insert test 1
    @Test
    public void testInsertFirst()
    {
        IDeque<Character> test1 = MakeADeque();
        test1.insert('a', 1);

        assert(test1.get(1).equals('a'));
        assert(test1.toString().equals("<a>"));

    }

    //insert test 2
    @Test
    public void testInsertMiddle()
    {
        IDeque<Character> test2 = MakeADeque();
        test2.enqueue('a');
        test2.enqueue('a');
        test2.enqueue('a');
        test2.enqueue('a');
        test2.insert('b',3);

        assert(test2.get(3).equals('b'));
        assert(test2.toString().equals("<a, a, b, a, a>"));

    }

    //insert test 3
    @Test
    public void testInsertLast()
    {
        IDeque<Character> test3 = MakeADeque();
        StringBuilder testString = new StringBuilder("<");

        for (int i = 0; i < 99; i++)
        {
            test3.enqueue('a');
            testString.append("a, ");
        }
        test3.insert('b',100);
        testString.append("b>");

        assert(test3.toString().equals(testString.toString()));
        assert(test3.get(100).equals('b'));
    }

    //remove test 1
    @Test
    public void testRemoveFront()
    {
        IDeque<Character> test1 = MakeADeque();
        for (int i = 0; i < 100; i++)
        {
            test1.inject('a');

        }
        test1.clear();
        assert(test1.toString().equals("<>"));
    }
    //remove test 2
    @Test
    public void testRemoveMiddle() {
        IDeque<Character> test2 = MakeADeque();
        test2.enqueue('a');
        test2.enqueue('a');
        test2.enqueue('b');
        test2.enqueue('a');
        test2.enqueue('a');

        assert(test2.remove(3).equals('b'));
        assert(test2.toString().equals("<a, a, a, a>"));
    }

    //remove test 3
    @Test
    public void testRemoveLast() {
        IDeque<Character> test3 = MakeADeque();
        StringBuilder testString = new StringBuilder("<");

        for (int i = 0; i < 99; i++)
        {
            test3.enqueue('a');
            testString.append("a, ");
        }
        test3.enqueue('b');
        testString.append("b>");

        assert(test3.toString().equals(testString.toString()));
        assert(test3.remove(100).equals('b'));
    }

    //get test 1
    @Test
    public void testGetFront() {
        IDeque<Character> test1 = MakeADeque();
        test1.enqueue('a');

        assert(test1.get(1).equals('a'));
        assert(test1.toString().equals("<a>"));
    }

    //get test 2
    @Test
    public void testGetMiddle() {
        IDeque<Character> test2 = MakeADeque();
        test2.enqueue('a');
        test2.enqueue('a');
        test2.enqueue('b');
        test2.enqueue('a');
        test2.enqueue('a');

        assert(test2.get(3).equals('b'));
        assert(test2.toString().equals("<a, a, b, a, a>"));
    }

    //get test 3
    @Test
    public void testGetBack() {
        IDeque<Character> test3 = MakeADeque();
        StringBuilder testString = new StringBuilder("<");

        for (int i = 0; i < 99; i++)
        {
            test3.enqueue('a');
            testString.append("a, ");
        }
        test3.enqueue('b');
        testString.append("b>");

        assert(test3.toString().equals(testString.toString()));
        assert(test3.get(100).equals('b'));
    }

}

