import java.math.BigInteger;

public class Problem_14_Broken {
    public static void main(String[] args) {

        long longestSequence = new Problem_14_Broken().run(1000000);
        System.out.println(longestSequence +  " generates the longest sequence of: " + sequence(BigInteger.valueOf(longestSequence), true));
    }



    public long run(long limit) {
        long currentBest = 0;
        for (long x = 1; x <= limit ; x++) {
            //System.out.println(sequence(x));
            if (sequence(BigInteger.valueOf(x), false) > currentBest) {
                currentBest = x;
            }

        }

        return currentBest;
    }


    public static long sequence(BigInteger start, boolean display) {
        long counter = 1;
        while (start.intValue() > 1) {
            if (display)
                System.out.print(start + " ");
            if (start.mod(BigInteger.TWO) == BigInteger.ZERO) {
                start = start.divide(BigInteger.TWO);
            } else {
                start = ((start.multiply(BigInteger.valueOf(3))).add(BigInteger.ONE));
            }
            counter++;
        }
        if (display)
            System.out.println(start);
        return counter;
    }

}
