import java.util.LinkedList;
import java.util.Queue;
import jdk.internal.util.xml.impl.Pair;


public class NumberOfIslands_200 {
    public int numIslands_dfs(char[][] grid) {
        int len = grid.length;
        if (len == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int[] direction : directions) {
            dfs(grid, row + direction[0], col + direction[1]);
        }
        grid[row][col] = '1';
    }

    public int numIslands_bfs(char[][] grid) {
        int len = grid.length;
        if (len == 0)
            return 0;
        int count = 0;
        int colNum = grid[0].length;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<Integer> visited = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < colNum; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j]='0';
                    ++count;
                    visited.add(i*colNum+j);
                    while (!visited.isEmpty()) {
                        Integer index = visited.peek();
                        int row = index / colNum;
                        int col = index % colNum;
                        for(int[] direction : directions) {
                            int neighborRow = row+direction[0];
                            int neighborCol = col+direction[1];
                            if(neighborRow>=0 && neighborRow<len && neighborCol>=0 && neighborRow<colNum && grid[neighborRow][neighborCol]=='1') {
                                visited.add(neighborRow*colNum+neighborCol);
                                grid[neighborRow][neighborCol]='0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
