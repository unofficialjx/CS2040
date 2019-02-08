import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        List<Integer> commonList = new LinkedList<>();


        commonList.add(100);
        commonList.add(261);
        commonList.add(333);

        list1.add(3);
        list1.add(7);
        list1.add(-1);
        list1.add(45);
        list1.add(2);
        list1.add(commonList.get(0));
        list1.add(commonList.get(1));
        list1.add(commonList.get(2));


        list2.add(10);
        list2.add(25);
        list2.add(-1);
        list2.add(4);
        list2.add(77);
        list2.add(commonList.get(0));
        list2.add(commonList.get(1));
        list2.add(commonList.get(2));

        int startingIndexOfSubListInList1 = list1.indexOf( valueBeforeOfSubList(list1, list2) ) + 1 ;
        List<Integer> subList = list1.subList(startingIndexOfSubListInList1, list1.size());

        subList.forEach(System.out::println);
    }

    public static Integer valueBeforeOfSubList(List<Integer> list1, List<Integer> list2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        list1.forEach(x -> s1.push(x));
        list2.forEach(x -> s2.push(x));


        while (s1.peek().equals(s2.peek())) {
            s1.pop();
            s2.pop();
        }

        return s1.peek();

    }

}
