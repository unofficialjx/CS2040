import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTrees;
        int[] treesArray;

        numTrees = sc.nextInt();
        treesArray = new int[numTrees];
        sc.nextLine();

        for (int i = 0; i < numTrees; i++) {
            treesArray[i] = sc.nextInt();
        }

        System.out.println(numSwings(treesArray));

    }

    private static int numSwings(int[] treesArray) {
        Stack<Integer> stack = new Stack<>();
        int pairs = 0;

        for (int i = 0; i < treesArray.length; i++) {
            int treeHeight = treesArray[i];
            if (stack.isEmpty()) {
                stack.push(treeHeight);
            } else {
                while (!stack.isEmpty() && treeHeight > stack.peek()) {
                    stack.pop();
                    pairs++;
                }

                if (stack.isEmpty()) {
                    stack.push(treeHeight);
                } else if (treeHeight == stack.peek()) {
                    pairs++;
                } else {
                    stack.push(treeHeight);
                    pairs++;
                }
            }
        }
        return pairs;
    }
}

