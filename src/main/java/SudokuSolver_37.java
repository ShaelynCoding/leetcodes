public class SudokuSolver_37 {
    public static void solveSudoku(char[][] board) {

        int len = board.length;
        int[][] rowUsed = new int[9][10];
        int[][] colUsed = new int[9][10];
        int[][] blockUsed = new int[9][10];
        //初始化
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                if(board[i][j]!='.') {
                    int cur = board[i][j]-'0';
                    rowUsed[i][cur]=1;
                    colUsed[j][cur]=1;
                    blockUsed[(i/3)*3+j/3][cur]=1;
                }
            }
        }
        dfs(0,0,rowUsed, colUsed, blockUsed, board);

    }
    public static boolean dfs(int row, int col, int[][] rowUsed, int[][] colUsed, int[][] blockUsed, char[][] board) {
        int len = board.length;

        if(col==len) {
            col=0;
            row++;
            if(row==len) {
                return true;
            }
        }



        if(board[row][col]=='.') {
            for(int i=1;i<10;i++) {
                if (rowUsed[row][i] == 1) {
                    continue;
                }
                if (colUsed[col][i] == 1) {
                    continue;
                }
                if (blockUsed[(row / 3) * 3 + col / 3][i] == 1) {
                    continue;
                }

                rowUsed[row][i] = 1;
                colUsed[col][i] = 1;
                blockUsed[(row / 3) * 3 + col / 3][i] = 1;
                board[row][col] = (char) ('0' + i);
                if(dfs(row, col + 1, rowUsed, colUsed, blockUsed, board)) return true;
                rowUsed[row][i] = 0;
                colUsed[col][i] = 0;
                blockUsed[(row / 3) * 3 + col / 3][i] = 0;
                board[row][col] = '.';
            }
        } else {
            return dfs(row, col+1, rowUsed, colUsed, blockUsed, board);
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        solveSudoku(board);
        int len = board.length;
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

}
