/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 * 分治 => 快速幂乘
 * Solution 1: while 暴力求解
 * Solution 2: 递归
 */
public class MyPow_50 {
    public double myPow(double x, int n) {
        if(n<0) return 1/pow(x, -n);
        else return pow(x, n);
    }

    public double pow(double x, int n) {
        if(n==0) return 1.0;
        double y = pow(x, n/2);
        if(n%2==0) return y*y;
        else return y*y*x;
    }
}
