import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class WordSearch2_212 {
    // words多的时候超时
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<String>();
        for(String word : words) {
            if(exist(board, word)) {
                res.add(word);
            }
        }
        return res;
    }

    public static boolean exist(char[][] board, String word) {
        if(board.length==0 || word=="") return false;
        int[][] visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]==word.charAt(0)) {
                    visited[i][j]=1;
                    if(found(board, i, j, word, 0, visited))
                        return true;
                    visited[i][j]=0;
                }
            }
        }
        return false;
    }

    private static boolean found(char[][] board, int row, int col, String word, int index, int[][] visited) {
        if(board[row][col]==word.charAt(index) && index==word.length()-1) {
            return true;
        }
        if(board[row][col]!=word.charAt(index)) {
            return false;
        }
        //上 i-1，j
        if(row-1>=0 && visited[row-1][col]==0 ) {
            visited[row-1][col]=1;
            if(found(board, row-1, col, word, index+1, visited)) {
                return true;
            }
            visited[row-1][col]=0;
        }


        //下 i+1，j
        if(row+1<board.length && visited[row+1][col]==0) {
            visited[row+1][col]=1;
            if(found(board, row+1, col, word, index+1, visited)) {
                return true;
            }
            visited[row+1][col]=0;
        }

        //左 i, j-1

        if(col-1>=0 && visited[row][col-1]==0) {
            visited[row][col-1]=1;
            if(found(board, row, col-1, word, index+1, visited)) {
                return true;
            }
            visited[row][col-1]=0;
        }

        //右 i，j+1
        if(col+1<board[0].length && visited[row][col+1]==0) {
            visited[row][col+1]=1;
            if(found(board, row, col+1, word, index+1, visited)) {
                return true;
            }
            visited[row][col+1]=0;
        }
        return false;
    }


    //回溯+字典树
    public List<String> findWords_2(char[][] board, String[] words) {
        Set<String> res = new HashSet<String>();
        TrieNode root = buildTrie(words);
        int[][] visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                backTracer(board, "", res, i, j, visited, root);
            }
        }
        return new ArrayList<String>(res);
    }

    public void backTracer(char[][] board, String str, Set<String> res, int row, int col, int[][] visited,
            TrieNode node) {
        if(row<0 || row>=board.length || col<0 || col >=board[0].length || visited[row][col]==1 || node.children[board[row][col]-'a']==null)
            return;
        str+=board[row][col];
        if(node.children[board[row][col]-'a'].isWord) {
            res.add(str);
        }
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        visited[row][col]=1;
        for(int[] direction: directions) {

            backTracer(board, str, res, row+direction[0], col+direction[1], visited,
                    node.children[board[row][col]-'a']);

        }

        visited[row][col]=0;
        str = str.substring(0, str.length()-1);
    }

    public class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word:words) {
            TrieNode node = root;
            for(int i=0;i<word.length();i++) {
                Integer index = word.charAt(i) -'a';
                if(node.children[index]==null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isWord = true;
        }
        return root;
    }
}
