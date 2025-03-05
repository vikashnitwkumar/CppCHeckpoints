import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Solution {
    public long coloredCells(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = 4*i -4;
        }
        
        long res = 0;
        for(int i = 1; i <= n; i++){
            res += dp[i];
        }
        return res;
    }
}

// 1 -> 1
// 2 -> 4 (2+2+ 0+ 0)
// 3 -> 8 ( 3+ 3+ 1+ 1)
// 4 -> 12 ( 4+ 4+ 2+ 2)