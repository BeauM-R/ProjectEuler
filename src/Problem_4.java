public class Problem_4 {

    public static void main(String[] args) {

        int startNum = 100;
        int endNum = 1000;
        String output = "";
        int halfway = 0;
        String left, right = "";
        boolean match = true;

        int largest = 0;

        for (int x = startNum; x < endNum; x++) {
            for (int y = startNum; y < endNum; y++) {
                output = Integer.toString(x * y);

                if (output.length()%2 == 0) {
                    halfway = output.length()/2;
                    //System.out.println(output + " " + output.substring(0, halfway) + " " + output.substring(halfway));
                    left = output.substring(0, halfway);
                    right = output.substring(halfway);;

                }
                else {
                    halfway = output.length()/2 + 1;
                    //System.out.println(output + " " + output.substring(0, halfway-1) + " " + output.substring(halfway));
                    left = output.substring(0, halfway-1);
                    right = output.substring(halfway);
                }



                match = true;
                for (int z = 0; z < left.length(); z++) {
                    if (left.charAt(z) == right.charAt(right.length()-1-z)){

                    } else {
                        match = false;
                    }
                }

                if (match) {
                    System.out.println(output);
                    if (Integer.valueOf(output) > largest) {
                        largest = Integer.valueOf(output);
                    }
                }
                //System.out.println(match);



            }
        }
        System.out.println("The largest number is " + largest);
    }
    //public static boolean isPal


}
