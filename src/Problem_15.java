public class Problem_15 {


    public static void main(String[] args) {
        //System.out.println(getGridMoves(1));
        //System.out.println();

        //String[] allMoves = getGridMoves(2);
        System.out.println("Solutions: " + getGridMoves(2));

        //System.out.println(generateBinaries(getGridMoves(2)));
    }



    public static int getGridMoves(int gridWidth) {

        gridWidth = gridWidth + gridWidth;
        int noOfMoves = ((int) Math.pow(2,gridWidth));

        int count = 0;

        //String[] moves = new String[noOfMoves];

        for (int x = 0; x < noOfMoves; x++) {

            String out = Integer.toBinaryString(x);
            out = String.format("%" + gridWidth + "s", Integer.toBinaryString(x)).replaceAll(" ","0");

            //moves[x] = out;

            //System.out.println(out);

            if (calcBalance(out)) {
                count++;
            }



        }

        return count;
    }

    public static boolean calcBalance(String testBinary) {
        int zeroCount, oneCount;
        zeroCount = testBinary.replace("1","").length();
        oneCount = testBinary.replace("0","").length();

        if (oneCount == zeroCount) {
            return true;
        } else {
            return false;
        }

    }

    public static int countBalanced(String[] allBinaries) {
        int count = 0;
        String zeroCount = "";
        String oneCount = "";
        for (String x : allBinaries) {
            zeroCount = x.replace("1", "");
            oneCount = x.replace("0", "");
            //System.out.println(x + " " + zeroCount.length() + " " + " " + oneCount.length());
            if ((zeroCount.length() == oneCount.length()) & (zeroCount.length() != 0)){
                count++;
                System.out.println(x);
            }
        }

        return count;
    }


}
