import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Triangle_120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty()) return 0;
        int size = triangle.size();
        int first = triangle.get(0).get(0);
        if(size==1) return first;
        int[][] dp = new int[size][];
        dp[0] = new int[1];
        dp[0][0]=first;
        for(int i=1;i<size;i++) {
            dp[i] = new int[i+1];
            dp[i][0] = dp[i-1][0]+triangle.get(i).get(0);
            for(int j=1;j<i;j++) {
                dp[i][j] = min(dp[i-1][j-1], dp[i-1][j])+triangle.get(i).get(j);
            }
            dp[i][i] = dp[i-1][i-1]+triangle.get(i).get(i);
        }

        int min=dp[size-1][0];
        for(int i=1;i<size;i++) {
            if(min>dp[size-1][i]) {
                min = dp[size-1][i];
            }
        }
        return min;
    }

    private static int min(int a, int b) {
        if(a<b) return a;
        return b;
    }

    public static void main(String[] args) {
        Integer[][] list = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> nums = twoDArrayToList(list);
        int res = minimumTotal(nums);
        System.out.print(res);
    }

    private static  <T> List<List<T>> twoDArrayToList(T[][] twoDArray) {
        List<List<T>> lists = new ArrayList<List<T>>();
        for (T[] array : twoDArray) {
            lists.add(Arrays.asList(array));
        }
        return lists;
    }
}
