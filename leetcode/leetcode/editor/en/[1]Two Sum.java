//Given an array of integers, return indices of the two numbers such that they a
//dd up to a specific target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
// Related Topics Array Hash Table


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static int[] twoSum(int[] nums, int target) {
        /**
         * 1、使用hashmap进行索引就行了,把每一个值和它对应的下标都放进去，然后用target减去每一个数
         *    看看答案的索引有没有，有的话就返回就行了
         * 2、使用双指针，但没这个快就不用了
         */
        Map<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //这样会把重复的用了，因为如果当前的是3，而且其中就有一个3
            //那么它通过这个不但把现在的3返回了，还把数组中的3从hash中找出来了
            //如果没有3就把这个3存进去
            if (indexMap.containsKey(target-nums[i])){
                //如果有这个数的话，把这个数的下标取出来
                return new int[]{i,indexMap.get(target-nums[i])};
            }
            indexMap.put(nums[i],i);
        }
        return new int[]{};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
