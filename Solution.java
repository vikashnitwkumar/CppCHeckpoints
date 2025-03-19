import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
class Solution {
    void flipNextN(int[] nums, int i, int n) {
        for(int j = i; j < i + n; j++) {
            nums[j] = 1 - nums[j];
        }
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n-2; i++) {
            if(nums[i] == 0) {  
                flipNextN(nums, i, 3);
                count++;
               // System.out.println(i + " " +nums[i] + " " + nums[i+1] + " " + nums[i+2] + " " + count);
            }
        }
        if(nums[n-1] == 0 || nums[n-2] == 0 || nums[n-3] == 0) {
            return -1;
        }
        return count;
    }
}