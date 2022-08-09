import java.math.BigInteger;

public class Problem_15_recursion {

    public static void main(String[] args) {

        int gridSize = 5;
        int startX = 0;
        int startY = 0;
        int finishX = gridSize;
        int finishY = gridSize;

        System.out.println("Solutions: " + recursiveDive(0,startX,startY,finishX,finishY));
    }


    public static int recursiveDive(int score, int currentX, int currentY, int goalX, int goalY) {
        //System.out.println(currentX + " " +currentY);
        //end condition
        if ((currentX == goalX) & (currentY == goalY)) {
            //System.out.println("found it");
            return score+1;
        }
        if (currentX < goalX) {
            score = recursiveDive(score, currentX+1, currentY, goalX, goalY);
        }
        if (currentY < goalY) {
            score = recursiveDive(score, currentX, currentY+1,goalX,goalY);
        }
        return score;
    }
}