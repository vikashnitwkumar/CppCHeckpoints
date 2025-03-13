import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


class Solution {
    boolean helper(int[] nums, int[][] queries, int qn){
        int n = nums.length;
        int[] prefix = new int[n + 1];
       for (int i = 0; i <= qn; i++) {
            prefix[queries[i][0]] += queries[i][2];
            prefix[queries[i][1] + 1] -= queries[i][2];
       }
       int temp = 0;
       for (int i = 0; i < n; i++) {
           temp += prefix[i];
           if(temp <nums[i]) return false;
       }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {        
        int n = queries.length;
        int l = 0, r = n;
        int result = -2;
        int maxVal = Arrays.stream(nums).max().getAsInt();
        if(maxVal <= 0) return 0;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (helper(nums, queries, mid)) {
                result = mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return result+1;
    }
}