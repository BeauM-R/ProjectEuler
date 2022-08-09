import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem_10 {


    public static void main(String[] args) {
        int limit = 2000000;


        List<Integer> primeList = sieveOfEratosthenes(limit);

        long total = 0;

        for (int x : primeList) {
            total += x;
        }
        System.out.println(total);

    }


    // Source : https://www.baeldung.com/java-generate-prime-numbers
    public static List<Integer> sieveOfEratosthenes(int n) {
        //creates an array of boolean filled with true
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        //searches intervals that are not multiples
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }


}
