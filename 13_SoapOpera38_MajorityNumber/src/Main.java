import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, Integer> map = new HashMap<>();

        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                int numOccurrences = map.get(n);
                map.put(n, numOccurrences + 1);
            }
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if ((Integer) pair.getValue() > size / 2) {
                System.out.println("Majority number: " + pair.getKey());
            }
        }
    }

}
