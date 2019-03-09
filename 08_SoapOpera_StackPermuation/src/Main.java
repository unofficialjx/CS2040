import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	Stack<Integer> input = new Stack<Integer>();
	Stack<Integer> inProgressStack = new Stack<Integer>();

	input.push(6);
	input.push(5);
	input.push(4);
	input.push(3);
	input.push(2);
	input.push(1);

	inProgressStack.push(1);
        inProgressStack.push(2);
        inProgressStack.push(3);
        inProgressStack.push(4);
        inProgressStack.push(5);
        inProgressStack.push(6);

        System.out.println(canPermute(input, inProgressStack));



    }

    public static boolean canPermute(Stack<Integer> input, Stack<Integer> inProgressStack) {
        Stack<Integer> mainStack = new Stack<Integer>();

        while ( !input.empty() ) {
            if (mainStack.empty()) {
                mainStack.push(input.pop());
                System.out.println("S" );
            } else if (mainStack.peek().equals(inProgressStack.peek())) {
                int x = mainStack.pop();
                inProgressStack.pop();
                System.out.println("X");
            } else {
                mainStack.push(input.pop());
                System.out.println("S");
            }
        }



        while ( !inProgressStack.empty() && !mainStack.empty() ) {
            if ( !inProgressStack.peek().equals(mainStack.peek()) ) {
                return false;
            } else {
                inProgressStack.pop();
                mainStack.pop();
                System.out.println("X");
            }
        }

        return true;


    }
}
