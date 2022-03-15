import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *
 */
public class NQueues_51 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<List<String>>();
        int[] queues = new int[n];
        Arrays.fill(queues, -1);
        Set<Integer> cols = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backTrace(0, n, queues, result, cols, diagonals1, diagonals2);
        return result;
    }

    public static void backTrace(int row, int n, int[] queues, List<List<String>> result, Set<Integer> cols,
            Set<Integer> diagonals1,
            Set<Integer> diagonals2) {
        if(row == n) {
            result.add(generate(queues, n));
        }
        for(int i=0;i<n;i++) {
            if(cols.contains(i)) {
                continue;
            }
            if(diagonals1.contains(i-row)) {
                continue;
            }
            if(diagonals2.contains(i+row)) {
                continue;
            }
            cols.add(i);
            diagonals1.add(i-row);
            diagonals2.add(i+row);
            queues[row] = i;
            backTrace(row+1, n, queues, result, cols, diagonals1, diagonals2);
            cols.remove(i);
            diagonals1.remove(i-row);
            diagonals2.remove(i+row);
        }
    }

    public static List<String> generate(int[] queues, int n) {
        List<String> res = new LinkedList<String>();
        for(int i=0;i<n;i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queues[i]]='Q';
            res.add(new String(row));
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
        System.out.print(res);
    }
}
