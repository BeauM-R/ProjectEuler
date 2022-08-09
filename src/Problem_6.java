public class Problem_6 {

    public static int numbers = 100;

    public static void main(String[] args) {
        System.out.println(sumOfSquares());
        System.out.println(squareOfSum());
        System.out.println(squareOfSum() - sumOfSquares());

    }


    public static int sumOfSquares() {
        int accumulator = 0;

        for (int x = numbers; x > 0; x--){
            accumulator = accumulator + (x * x);
        }
        return accumulator;
    }


    public static int squareOfSum() {
        int accumulator = 0;

        for (int x = numbers; x > 0; x--){
            accumulator += x;
        }
        accumulator = (accumulator * accumulator);

        return accumulator;
    }


}
