//Given n non-negative integers a1, a2, ..., an , where each represents a point 
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis for
//ms a container, such that the container contains the most water. 
//
// Note: You may not slant the container and n is at least 2. 
//
// 
//
// 
//
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In thi
//s case, the max area of water (blue section) the container can contain is 49. 
//
// 
//
// Example: 
//
// 
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49 Related Topics Array Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
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
//leetcode submit region end(Prohibit modification and deletion)
