package 第03课数组链表跳表.实战题目;

/**
 * non-negative 非负数
 * represent 代表
 * coordinate /kəʊˈɔːdɪneɪt/ 坐标
 * vertical 垂直的
 * endpoint 终点
 * x-axis x轴
 * slant 偏见、倾斜
 * above 超过
 * related 有关系的
 * topic 主题
 */

import java.util.Map;

/**
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line
 * i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container,
 * such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Related Topics
 * Array
 * Two Pointers
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        /**
         * 第一种就是使用暴力破解的方法，第一个指针指在第一个棒子上，第二个指针指在第一个棒子位置+1的棒子
         * 上，然后移动第二个棒子，如果第二个棒子移动完了，那么第一个棒子像后面移动一个，第二个棒子还是放在
         * 后面一个的位置上面， 以此循环，并且每次比较大小，最后面可以确定出其中最大的那个区间
         */

//        int maxArea = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int area = (j-i)* Math.min(height[i],height[j]);
//                maxArea = Math.max(area,maxArea);
//            }
//
//        }
//        return maxArea;

        /**
         * 第二种方法是俩侧夹逼法：
         *      一个指针指向第一个柱子，第二个指针指向第倒数第一个柱子。因为这样的宽度是最宽的所以在这种情况下
         *      如果你想要增大面积，那么你可能要把他们向中间移动，将宽度转换成长度，弥补中间的空缺，所以为了提高效率。
         *      我们就移动俩根柱子较小的那一个，这样就可以不停的移动了，最后2个指针相遇，可以从中查出最大的面积
         */

        int maxArea = 0;
        for (int i = 0 , j = height.length-1 ; i < j; ) {
            //太简洁了这个代码，我醉了
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            //因为，上面的j可能-1 或者i+1了
            maxArea = Math.max((j - i + 1)* minHeight,maxArea);
        }

        return maxArea;
    }
}
