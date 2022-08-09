public class Problem_9 {




    public static void main(String[] args) {

        int target = 1000;
        int a, b, c = 0;

        for (int x = 1; x < target; x++) {
            for (int y = 1; y < target - x; y++) {
                a = x;
                b = y;
                c = target - x- y;


                if ((a < b) & (b < c)) {
                    if ((Math.pow(a, 2) + (Math.pow(b, 2))) == Math.pow(c, 2)) {
                        System.out.println(a + " " + b + " " + c);
                        System.out.println(a*b*c);
                    }
                }
            }


        }
    }




}
