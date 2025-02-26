import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;



class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxs = 0;
        int mins = 0;
        int tempmax = 0;
        int tempmin = 0;
        for(int i = 0; i < nums.length; i++){
            tempmax += nums[i];
            tempmin += nums[i];
            maxs = Math.max(maxs, tempmax);
            mins = Math.min(mins, tempmin);
            tempmax = Math.max(0, tempmax);
            tempmin = Math.min(0, tempmin);
        }
        return Math.max(maxs, -mins);
    }
}