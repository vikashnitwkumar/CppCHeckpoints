import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;



class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] primes = new boolean[right+1];
        Arrays.fill(primes, true);
        int prev = 0;
        int res = Integer.MAX_VALUE;
        int[] ret= new int[]{-1,-1};
        for(int i=2; i<=right; i++){
            if(primes[i]) {
                for(int j=2*i; j<=right; j+=i){
                    primes[j] = false;
                }
                if(i < left) continue;
                if(res > i-prev && prev!=0) {
                    res = i-prev;
                    ret = new int[]{prev, i};
                }
                prev = i;
                continue;
            }
            
        }
        return ret;
    }
}