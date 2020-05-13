package 第03课数组链表跳表.实战题目;

/**
 * in-place 就地，原地
 * minimize 最小化
 */

/**
 * Given an array nums,
 * write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * Related Topics
 * Array
 * Two Pointers
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        /**
         * 这里我醉了交换，但是没有考虑顺序的问题
         */
//        for (int i = 0,j = nums.length - 1; i <= j ; i++) {
//            if (nums[i] == 0){
//                while (nums[j] == 0){
//                    j--;
//                }
//                if (nums[j] !=0){
//                    int a = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = a;
//                }
//            }
//        }
        /**
         * 学习第一遍
         * 从第一个数开始遍历，并确定一个指针指向第一个，碰到一个非0的数，就把他放在指针的位置，指针++
         * 循环到结束，则时候你知道指针一共指了几个数，我们就从这个下标开始往后填0就可以了
         */
        /*
        if (nums == null || nums.length == 0)
            return;
        int currentIndex = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != 0){
                nums[currentIndex++] = nums[i];
            }
        }
        for (int i = currentIndex; i <nums.length ; i++) {
            nums[i] = 0;
        }
         */
        /**
         * 第一遍学习，遍历法
         * 也是从第一个开始遍历，并确定一个指针指向第一个，我们碰到一个非0的数，就把他与指针做交换
         * 加入第一个数是非0，那么她就跟自己做了交换，以此类推，到了一个是0的数，指针就停下来了，
         * 但是循环没停下来他就继续往后面走，碰到非0的数就和指针交换，一次类推，其实就是一直把0往后移动的
         * 如果一直没有碰见就不移动，如果碰见了就会发生一直移动的情况
         */
//        if (nums == null || nums.length ==0) return;
//
//        int currentIndex = 0;
//        for (int i = 0; i < nums.length; i++) {
//            //如果发现非0，就和current发生交换极客
//            if (nums[i] != 0){
//                int temp = nums[i];
//                nums[i] = nums[currentIndex];
//                nums[currentIndex++] = temp;
//            }
//        }
        /**
         * 二刷
         */
        if (nums == null || nums.length ==0) return;

        int currentIndex = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != 0){
                int temp = nums[currentIndex];
                nums[currentIndex++] = nums[i];
                nums[i] = temp;
            }
        }

    }
}
