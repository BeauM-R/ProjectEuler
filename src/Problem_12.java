public class Problem_12 {


    public static int getTriangle(int natNumber) {
        int accumulator = 0;

        for (int x = natNumber; x > 0; x--) {
            accumulator = accumulator + x;
        }


        return accumulator;
    }


    public static void listTriangle(int limit) {
        int triangleNumber = 1;

        for (int x = 1; x <= limit; x++) {
            triangleNumber = getTriangle(x);
            System.out.println(triangleNumber + " has " + getFactors(triangleNumber) + " factors: " + listFactors(triangleNumber));
        }
    }

    // get factors is modified from the following source.
    // https://github.com/nayuki/Project-Euler-solutions/blob/master/java/p012.java?ts=4
    // Instead of using brute force, it
    public static int getFactors(int n) {
        int count = 0;
        double end = Math.sqrt(n);
        for (int i = 1; i < end; i++) {
            if (n % i == 0)
                count += 2;
        }
        if (end * end == n)  // Perfect square
            count++;
        return count;
    }

    public static String listFactors(int input) {
        String output = "";
        for (int i = 1; i <= input; i++) {
            if (input % i == 0) {
                output = output + (i + " ");
            }
        }

        //System.out.println(output);
        return output;
    }

    public static int getDivisorsTriangle(int target) {

        boolean targetNotMet = true;
        int iterator = 0;
        int triangle;
        int triangleFactors;

        while (targetNotMet) {
            iterator++;

            triangle = getTriangle(iterator);
            triangleFactors = getFactors(triangle);


            if (triangleFactors > target) {
                System.out.println("Triangle " + iterator + " is " + triangle + " and has " + triangleFactors + " factors");
                targetNotMet = false;
            }



            System.out.println(triangle + " has " + getFactors(triangle) + " factors");
            System.out.println("these are: " + listFactors(triangle));
            System.out.println();

        }



        return 0;
    }


    public static void main(String[] args) {
        //listTriangle(10);

        //System.out.println(getTriangle(7));

        getDivisorsTriangle(10);


    }





}
