import java.math.BigInteger;

public class Problem_16 {

    public static void main(String[] args) {
        String out = String.valueOf(Math.pow(2,1000));

        System.out.println(power(2,1000));
        BigInteger test = power(2,15);
        System.out.println(sumOfDigits(test));

        //System.out.println(out);

    }

    public static int sumOfDigits(BigInteger input) {
        String stringThing = String.valueOf(input);
        System.out.println(stringThing);
        int accumulator = 0;
        for (int x = 0; x < stringThing.length(); x++){
            accumulator += Integer.valueOf(stringThing.charAt(x));

        }

        return accumulator;
    }


    public static BigInteger power(int a, int b){
        BigInteger accumulator = BigInteger.ONE;
        for (int x = 0; x < b; x++) {
            accumulator = accumulator.multiply(BigInteger.valueOf(a));
        }
        return accumulator;
    }


}
