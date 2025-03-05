import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Solution {
    public long coloredCells(int n) {
        return 1+(long)2*n*(n-1);
    }
}

// 1 -> 1
// 2 -> 4 (2+2+ 0+ 0)
// 3 -> 8 ( 3+ 3+ 1+ 1)
// 4 -> 12 ( 4+ 4+ 2+ 2)