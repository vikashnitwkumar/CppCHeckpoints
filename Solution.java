import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int sr = 0;
        int sc = 0;
        int er = matrix.length - 1;
        int ec = matrix[0].length - 1;
        while (sr <= er && sc <= ec) {
            for (int c = sc; c <= ec; c++) {
                result.add(matrix[sr][c]);
            }
            sr++;
            for (int r = sr; r <= er; r++) {
                result.add(matrix[r][ec]);
            }
            ec--;
            if (sr <= er) {
                for (int c = ec; c >= sc; c--) {
                    result.add(matrix[er][c]);
                }
                er--;
            }
            if (sc <= ec) {
                for (int r = er; r >= sr; r--) {
                    result.add(matrix[r][sc]);
                }
                sc++;
            }
        }

        return result;
    }
}