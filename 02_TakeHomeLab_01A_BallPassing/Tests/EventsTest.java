import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.ListIterator;

import static org.junit.Assert.*;

public class EventsTest {

    private LinkedList<Student> circle;
    Events e = new Events();
    ListIterator<Student> iterator;

    @Before
    public void setUp() throws Exception {
        circle = new LinkedList<Student>();
        circle.add(new Student("A"));
        circle.add(new Student("B"));
        circle.add(new Student("C"));
        circle.add(new Student("D"));
        circle.add(new Student("E"));

        iterator = circle.listIterator();

    }

    @Test
    public void nextWhenNotEndOfQueue() {
        e.next(circle, iterator); // returns A
        e.next(circle, iterator); // B
        ListIterator<Student> addressOfFinalIterator = e.next(circle, iterator); // C

        assertEquals(iterator, addressOfFinalIterator);
    }


    @Test
    public void nextWhenEndOfQueue() {

        e.next(circle, iterator); // returns A
        e.next(circle, iterator); // B
        e.next(circle, iterator); // C
        e.next(circle, iterator); // D
        e.next(circle, iterator); // E

        ListIterator<Student> addressOfNewIterator = e.next(circle, iterator); // A
        assertEquals(addressOfNewIterator, iterator);

//
//        e.next(circle, iterator); // B
//        ListIterator<Student> addressOfFinalIterator = e.next(circle, iterator); // C
//
//
//        assertEquals(addressOfNewIterator, addressOfFinalIterator);

    }


}