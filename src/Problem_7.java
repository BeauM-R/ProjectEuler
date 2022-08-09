public class Problem_7 {

    public static void main(String[] args) {
        //System.out.println(isPrime(2));
        int numberedPrime = 10001;

        boolean endCond = true;
        int counter = 0;
        int testNumber = 1;

        while (endCond) {
            testNumber++;


            if (isPrime(testNumber)) {
                counter++;
                System.out.println(testNumber);
            }


            if (counter == numberedPrime) {
                endCond = false;
            }

        }
        System.out.println("The " + counter + " prime is " + testNumber + " " + isPrime(testNumber));

    }

    public static boolean isPrime (int input) {

        for (int x = 2; x < input; x++) {
            if (input % x == 0) {
                return false;
            }
        }

        return true;
    }





}
