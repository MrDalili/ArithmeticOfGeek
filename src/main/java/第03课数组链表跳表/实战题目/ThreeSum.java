package 第03课数组链表跳表.实战题目;

/**
 * triplets 三胞胎
 * duplicate 重复的，复制品
 */

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * Related Topics
 * Array
 * Two Pointers
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] a = new int[]{-2,0,0,2,2};
        threeSum(a);
        System.out.println(a);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        //1、暴力
        //2、n²的解法，用hash表
        //3、双指针左右下标往中间推荐
        /**
         * 首先需要对
         * 第一层循环存放所有的target，然后在这层循环里面，从target+1与length-1的位置开始遍历，
         * 如果左边与右边的相加的和是大于target的，那么就右边的向左边移动
         * 如果左边与右边的相加的和是小于target的，那么左边的向右边移动
         * 如果相同的话，把这三个数放到放在一个新的list中，之后将左边的下标与右边的下标+1，-1继续遍历
         * 当左边下表与右边下标相遇，就退出这个循环，target+1
         * 如果当target=length-2，就退出循环
         */
        Arrays.sort(nums);
        List<List<Integer>> answerList = new ArrayList<>();
        for (int targetIndex = 0; targetIndex < nums.length-2; targetIndex++) {
            //在这里需要加一个小动作，就看看前面一个数是不是和当前这个数相同如果相同的话，我就直接跳过
            if (targetIndex > 0 && nums[targetIndex] == nums[targetIndex-1])
                continue;
            int target = -nums[targetIndex];
            int leftPoint = targetIndex + 1;
            int rightPoint = nums.length-1;

            while (leftPoint < rightPoint){
                if (nums[leftPoint] + nums[rightPoint] == target){
                    answerList.add(Arrays.asList(nums[targetIndex],nums[leftPoint],nums[rightPoint]));
                    leftPoint++;
                    rightPoint--;
                    //这里要判断一下，我左边指针的右边一个是不是跟他一样，一个while循环需要
                    while (leftPoint < rightPoint && nums[leftPoint] == nums[leftPoint-1]) leftPoint++;
                    while (leftPoint < rightPoint && nums[rightPoint] == nums[rightPoint+1]) rightPoint--;
                    continue;
                } else if ( nums[leftPoint] + nums[rightPoint] > target){
                    rightPoint--;
                    continue;
                } else {
                    leftPoint++;
                    continue;
                }
            }
        }
        return answerList;
    }
}
