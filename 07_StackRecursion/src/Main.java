import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();

        s.push(100);
        s.push(-77);
        s.push(22);
        s.push(-3);
        s.push(-41);

        sort(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void insert(Stack<Integer> s, Integer val) {
        if (s.empty() || s.peek() < val) {
            s.push(val);
        } else {
            Integer temp = s.pop();
            insert(s, val);
            insert(s, temp);
        }
    }

    public static void delete(Stack<Integer> s, Integer val) {
        if (s.empty()) return;

        if (val == s.peek()) {
          s.pop();
        } else {
            Integer temp = s.pop();
            delete(s, val);
            s.push(temp);
        }
    }

    public static void sort(Stack<Integer> s) {
        if (s.empty()) {

        } else {
            Integer temp = s.pop();
            sort(s);
            insert(s, temp);
        }
    }
}
