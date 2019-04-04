/*
 * Name       :Keng Jun Xian
 * Matric No. :A0167718R
 * Plab Acct. :
 */
import java.util.*;

public class Brackets {

    class Input {
        int length;
        String expression;
        Stack<Character> s = new Stack<>();

        public Input(int length, String expression) {
            this.length = length;
            this.expression = expression;
        }

        private boolean checkValidity() {
            if (this.length % 2 != 0) {
                return false;
            }

            if (this.length == 0) {
                return true;
            }

            // for even numbers of brackets
            for (int i = 0; i < expression.length(); i++) {
                char current = expression.charAt(i);
                if (current == '{' || current == '(' || current == '[')
                {
                    s.push(current);
                } else {
                    if (s.empty()) {
                        return false;
                    } else {
                        char topOfStack = s.peek();
                        if (current == '}' && topOfStack == '{' || current == ')' && topOfStack == '(' || current == ']' && topOfStack == '[')
                            s.pop();
                        else // { [ ) } , second and third brackets do not match.
                            return false;
                    }
                }
            }
            return s.empty();
        }
    }


    private void run() {
        Scanner sc = new Scanner(System.in);
        int numTestCases;
        int currentTestCase = 0;
        ArrayList<Input> list = new ArrayList<>();
        numTestCases = sc.nextInt();
        sc.nextLine();

        while (currentTestCase < numTestCases) {
            int numBrackets = sc.nextInt();
            sc.nextLine();
            String expression = sc.next();
            sc.nextLine();
            Input input = new Input(numBrackets, expression);

            list.add(input);
            currentTestCase++;
        }

        list.forEach(input -> {
            if( input.checkValidity() ) System.out.println("Valid");
            else System.out.println("Invalid");
        });

    }
    public static void main(String[] args) {
        Brackets newBrackets = new Brackets();
        newBrackets.run();
    }
}
