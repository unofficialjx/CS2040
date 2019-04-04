import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class ClassPhotoTreeMap {

    private void run() {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, LinkedList<String>> studentTree = new TreeMap<>();

        LinkedList<String> height0List = new LinkedList<>();
        height0List.add("Rar");
        studentTree.put(0, height0List);

        int N = sc.nextInt();
        sc.nextLine();

        while (sc.hasNext()) {
            String name = sc.next();
            int height = sc.nextInt();

            if ( !studentTree.containsKey(height)) {
                studentTree.put(height, new LinkedList<>());
                studentTree.get(height).addFirst(name);
            } else {
                studentTree.get(height).addFirst(name);
            }

            int previousHeight = studentTree.lowerKey(height);

            String studentToLeft = studentTree.get(previousHeight).getLast();
            System.out.println(studentToLeft);
        }

        boolean isFirstOutput = true;
        for (LinkedList<String> sameHeightsList : studentTree.values()) {
            for(String name : sameHeightsList) {
                if (isFirstOutput) {
                    System.out.print(name);
                    isFirstOutput = false;
                } else System.out.print(" " + name);
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        ClassPhotoTreeMap newClassphoto = new ClassPhotoTreeMap();
        newClassphoto.run();
    }
}
