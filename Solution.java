import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int diffSum =0;
        int diffSqrSum = 0;
        int itr = 1;
        for(int[] row : grid){
            for(int col : row){
                diffSum += col - itr;
                diffSqrSum += col*col - itr*itr;
                itr++;
            }
        }
        int summ = diffSqrSum/diffSum;
        int x = (summ + diffSum)/2; //repeated
        int y = summ - x; //missing
        return new int[]{x,y};
    }
}