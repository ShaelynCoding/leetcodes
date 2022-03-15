import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ValidSudoku_36 {

    public static boolean isValidSudoku(char[][] board) {
        int len = board.length;
        Set<Character> rows = new HashSet<Character>();
        Set<Character> cols = new HashSet<Character>();
        for (int i = 0; i < len; i++) {
            rows.clear();
            cols.clear();
            for (int j = 0; j < len; j++) {
                char curRow = board[i][j];
                char curCol = board[j][i];
                //check row
                if (curRow != '.') {
                    if (rows.contains(curRow)) {
                        return false;
                    } else {
                        rows.add(curRow);
                    }
                }

                //check cols
                if (curCol != '.') {
                    if (cols.contains(curCol)) {
                        return false;
                    } else {
                        cols.add(curCol);
                    }
                }
            }
        }

        for (int i = 0; i + 2 < len; i += 3) {
            for (int j = 0; j + 2 < len; j += 3) {
                Set<Character> block = new HashSet<Character>();
                for (int k = 0; k < 3; k++) {
                    for (int g = 0; g < 3; g++) {
                        int rowNum = i + k;
                        int colNum = j + g;
                        Character cur = board[rowNum][colNum];
                        if (cur == '.') {
                            continue;
                        }
                        if (block.contains(cur)) {
                            return false;
                        } else {
                            cols.add(cur);
                        }
                    }
                }
            }
        }
        return true;
    }



    //一次遍历
    public static boolean isValidSudokuOnce(char[][] board) {

        int len = board.length;
        //第一维度：第n行 第二维度：数字1-9
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] blocks = new int[9][10];;
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                if(board[i][j]!='.') {
                    int cur = board[i][j]-'0';

                    if(rows[i][cur]==1) {
                        return false;
                    }
                    if(cols[cur][j]==1) {
                        return false;
                    }
                    if(blocks[(i/3)*3+j/3][cur]==1) {
                        return false;
                    }
                    rows[i][cur]=1;
                    cols[cur][j]=1;
                    blocks[(i/3)*3+j/3][cur]=1;

                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        char[][] board = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.', '.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};

        isValidSudoku(board);
    }


}
