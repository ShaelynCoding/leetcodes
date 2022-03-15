public class WordSearch_79 {
    public static boolean exist(char[][] board, String word) {
        if(board.length==0 || word=="") return false;
        int[][] visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]==word.charAt(0)) {
                    if(found(board, i, j, word, 0, visited))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean found(char[][] board, int row, int col, String word, int index, int[][] visited) {


        if(row<0 || row>=board.length || col<0 || col>= board[0].length || visited[row][col]==1 ||
                board[row][col]!=word.charAt(index)) {
            return false;
        }
        if(board[row][col]==word.charAt(index) && index==word.length()-1) {
            return true;
        }
        int[][] directions =  {{-1,0},{1,0},{0,1},{0,-1}};
        visited[row][col]=1;
        for (int[] direction : directions) {
            if(found(board, row+direction[0], col+direction[1], word, index+1, visited)) {
                return true;
            }
        }
        visited[row][col]=0;
        return false;
    }

    public static void main(String[] args) {
        char[][] test = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        boolean res3 = exist(test, "AAB");
        System.out.println(res3);
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        boolean res = exist(board, "ABCCED");
//        System.out.println(res);

        boolean res1 = exist(board, "SEE");
        System.out.println(res1);

//        boolean res2 = exist(board, "ABCS");
//        System.out.println(res2);

    }
}
