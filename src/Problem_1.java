
public class Problem_1 {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        int accumulator = 0;

        for (int i = 1; i <1000; i++) {
            if ((i % 3) == 0 || (i % 5) == 0) {
                //System.out.println(i);
                accumulator += i;
            }
        }
        System.out.println(accumulator);

    }
}
