import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * Solution 1: 递归 - dfs
 * count(left '(')= n && count( right ')')= n
 * 有效 -> count(right)<=count(left)
 */

public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<String>();
        generate(3,3,"", res);
        return res;

    }

    public void generate(int left, int right, String str, List<String> res) {
        if(left==0 && right==0) {
            res.add(str);
            return;
        }
        if(left>0) generate(left-1, right, str+"(", res);
        if(right>0 && left<=right) generate(left, right-1, str+")", res);
    }

}
