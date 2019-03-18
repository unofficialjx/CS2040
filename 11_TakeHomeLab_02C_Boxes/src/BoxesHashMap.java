/**
 * Name         :Keng Jun Xian
 * Matric. No   :A0167718R
 * PLab Acct.   :
 */

import java.util.*;

public class BoxesHashMap {

    Scanner sc = new Scanner(System.in);
    HashMap<Integer, HashSet<Integer>> catsMap = new HashMap<>();
    HashSet<Integer> colSet = new HashSet<>();

    private void run() {
        int numOperations = sc.nextInt();
        int numRows = sc.nextInt();
        int numCols = sc.nextInt();
        sc.nextLine();

        while (sc.hasNext()) {
            String operation = sc.next();
            int x = -1;
            int y = -1;
            switch (operation) {
                case "SIT":
                    x = sc.nextInt();
                    y = sc.nextInt();
                    sit(x,y);
                    break;
                case "BOX":
                    x = sc.nextInt();
                    y = sc.nextInt();
                    catInBox(x,y);
                    break;
                case "ROW":
                    x = sc.nextInt();
                    catInRow(x);
                    break;
                case "COL":
                    y = sc.nextInt();
                    catInCol(y);
                    break;
            }
            sc.nextLine();
        }
    }

    private void sit(int x, int y) {
        HashSet<Integer> setCorrespondingToRowX;
        if (catsMap.containsKey(x)) {
            // returns the value (the set which x is mapped to)
            setCorrespondingToRowX = catsMap.get(x);
        } else {
            setCorrespondingToRowX = new HashSet<>();
        }

        setCorrespondingToRowX.add(y);
        catsMap.put(x, setCorrespondingToRowX);
        colSet.add(y);

    }

    private void catInBox(int x, int y) {
        boolean catIsPresent;
        HashSet<Integer> setCorrespondingToRowX;

        if ( !catsMap.containsKey(x) ) {
            catIsPresent = false;
        } else {
            setCorrespondingToRowX = catsMap.get(x);
            if (setCorrespondingToRowX.contains(y)) catIsPresent = true;
            else catIsPresent = false;
        }

        if (catIsPresent) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
    }

    private void catInRow(int x) {
        boolean catIsPresent = catsMap.containsKey(x);
        if (catIsPresent) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
    }

    private void catInCol(int y) {
        // Looping through keys.
        /*
        for (HashSet<Integer> setCorrespondingToAParticularKey : catsMap.values()) {
            if (setCorrespondingToAParticularKey.contains(y)) {
                System.out.println("Y");
                return;
            }
        }
        System.out.println("N");
        */

        boolean catIsPresent = colSet.contains(y);
        if (catIsPresent) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
    }

    public static void main(String[] args) {
        BoxesHashMap newBoxes = new BoxesHashMap();
        newBoxes.run();
    }
}
