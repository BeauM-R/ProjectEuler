public class Problem_5 {


    public static void main(String[] args) {
        int target = 2520;
        int highestMultiple = 20;
        int test_value = highestMultiple;
        boolean divisibleByAll = true;
        boolean notFound = true;

        int i = 1;

        while (notFound) {

            test_value = highestMultiple * i;

            for (int x = highestMultiple; x > 1; x--) {
                //System.out.println(test_value % x);
                if (test_value % x != 0) {
                    divisibleByAll = false;
                }
            }

            if (divisibleByAll) {
                notFound = false;
            }

            divisibleByAll = true;

            i++;

        }

        System.out.println(test_value);

    }

}
