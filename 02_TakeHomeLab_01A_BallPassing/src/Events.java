import java.util.LinkedList;
import java.util.ListIterator;

public class Events {

     ListIterator<Student> next(LinkedList<Student> circle, ListIterator<Student> iterator) {
        Student nextStudent;

        if (iterator.hasNext()) {
            nextStudent = iterator.next();
        } else {
            iterator = circle.listIterator();
            nextStudent = iterator.next();
        }

        System.out.println(nextStudent + " pass to");

        return iterator;
    }


    ListIterator<Student> leave(LinkedList<Student> circle, ListIterator<Student> iterator) {
        Student nextStudent;

        // remove currentStudent
        iterator.previous();
        iterator.remove();

        if (iterator.hasNext()) {
            nextStudent = iterator.next();
        } else {
            Student firstStudent = circle.get(0);
            circle.addLast(firstStudent);
            circle.removeFirst();

            iterator = circle.listIterator();

            nextStudent = iterator.next();
        }

        System.out.println(nextStudent);

        return iterator;
    }


}
