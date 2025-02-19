import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;


class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int l = 0;
        Arrays.sort(intervals, (int[] a, int[]b)-> a[0]-b[0]);
        for(int i=1; i<n; i++){
            if(intervals[l][1] < intervals[i][0]){
                intervals[++l] = intervals[i];
            }
            else{
                intervals[l][1] = Math.max(intervals[i][1], intervals[l][1]);
            }
        }
        int[][] result = new int[l+1][2];
        for(int i=0; i<=l; i++){
            result[i] = intervals[i];
        }
        return result;
    }
}