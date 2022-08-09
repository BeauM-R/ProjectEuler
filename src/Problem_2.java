public class Problem_2 {
    public static void main(String[] args) {
        int num_1 = 1;
        int num_2 = 2;
        int num_3 = 3;
        int accumulator = 2;
        System.out.println(num_1);
        System.out.println(num_2);
        while (num_3 < 4000000) {
            if (num_3 % 2 == 0){
                accumulator += num_3;
            }
            //System.out.println(num_3);
            num_1 = num_2;
            num_2 = num_3;
            num_3 = num_1 + num_2;
        }
        System.out.println(accumulator);

    }
}
