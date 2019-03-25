import java.util.*;

public class Main {

    static Queue<Integer> queueOfPrimes = new ArrayDeque<>();
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int input = sc.nextInt();
        sc.nextLine();

        addAllPrimesToQueue(input);

        primeFactorization(input, 2, "", count);

    }

    static void addAllPrimesToQueue(int n) {
        int i = 0;
        int num = 0;

        for (i = 1; i <= n; i++) {
            int counter = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {
                queueOfPrimes.offer(i);
            }
        }
    }

    static void primeFactorization(int n, int primeDivisor, String currentString, int count) {
        if (n / primeDivisor == 1 && n % primeDivisor == 0) {
            count++;
            if (count == 1)  System.out.println(currentString + primeDivisor);
            else System.out.println(currentString + primeDivisor + "^" + count);
        } else {
            if (n % primeDivisor == 0) {
                n = n / primeDivisor;
                count++;
                primeFactorization(n, primeDivisor, currentString, count);
            } else {
                int newPrimeDivisor = queueOfPrimes.poll();
                int countForPreviousDivisor = count;
                count = 0;
                if (countForPreviousDivisor == 0) {
                    primeFactorization(n, newPrimeDivisor, currentString, countForPreviousDivisor);
                } else {
                    if (countForPreviousDivisor == 1)  primeFactorization(n, newPrimeDivisor, currentString + primeDivisor + " * ", count);
                    else primeFactorization(n, newPrimeDivisor, currentString + primeDivisor + "^" + countForPreviousDivisor + " * ", count);
                }
           }
        }
    }


}
