public class Problem_3 {
    public static void main(String[] args) {

        long prime = 600851475143L;
        //int prime = 13195;

        boolean exit = false;

        int currentPrime = 2;

        while (exit == false){



            if (prime % currentPrime == 0) {
                prime = prime/currentPrime;
                System.out.println(currentPrime);
            }

            currentPrime++;

            while (!isPrime(currentPrime)){
                currentPrime++;
            }
            if (currentPrime > prime) {
                exit = true;
            }
        }


    }




    public static boolean isPrime(long possPrime) {
        for (long k = possPrime-1 ; k > 1; k--) {
            if (possPrime % k == 0) {
                return false;
            }
        }
        return true;
    }
}
