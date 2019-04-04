/*
 * Name       :Keng Jun Xian
 * Matric No. :A0167718R
 * Plab Acct. :
 */
import java.util.*;


public class Transmission {
    TreeSet<Long> catsSetSleeping = new TreeSet<>();
    Scanner sc = new Scanner(System.in);

    private void run() {
        long numCats = sc.nextLong();
        int numEvents = sc.nextInt();
        sc.nextLine();

        while (sc.hasNext()) {
            String event = sc.next();
            switch (event) {
                case "TRANSMIT":
                    long x = sc.nextLong();
                    long y = sc.nextLong();
                    transmit(x, y);
                    break;
                case "SLEEP":
                    sleep(sc.nextLong());
                    break;
                case "WAKE":
                    wake(sc.nextLong());
                    break;
            }
            sc.nextLine();
        }
    }

    public void sleep(long x) {
        catsSetSleeping.add(x);
    }
    public void wake(long x) {
        catsSetSleeping.remove(x);
    }


    public void transmit(long x, long y) {
        Long floorY = catsSetSleeping.floor(y);
        if (catsSetSleeping.isEmpty() || floorY == null || floorY < x) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Transmission newTransmission = new Transmission();
        newTransmission.run();
    }
}
