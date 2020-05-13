package 第03课数组链表跳表.实战题目;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * Related Topics
 * Dynamic Programming
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        /**
         * 这个太过笨了，所以就改成迭代吧
         */
//        if (n == 2) return 2;
//        if (n == 1) return 1;
//        return climbStairs(n-1) + climbStairs(n-2);

        /**
         * 迭代的方法
         */
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        if (n == 1){
            return f1;
        }
        if (n == 2){
            return f2;
        }
        if (n == 3){
            return f3;
        }
        for (int i = 4; i < n; i++) {
            f1 = f2 + f3;
            f2 = f3;
            f3 = f1;
        }
        return f1;
    }
}
