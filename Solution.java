import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n!=0){
            if(n%3==2){
                return false;
            }
            n=n/3;
        }
        return true;
    }
}