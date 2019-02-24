package leetcode;

import java.util.HashMap;

/**
 * Created by Stone on 2019/2/12.
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 *
 * @author Stone<Stone305585@live.com>
 */
public class LeetCode1 {

    private HashMap<Integer, Integer> numsMap = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {

        if (nums.length < 2) {
            return new int[2];
        }

        for (int i = 0; i < nums.length; i++) {
            if (!numsMap.containsKey(nums[i])) {
                numsMap.put(nums[i], i);
            }
        }

        int[] res= new int[2];

        for (int j = 0; j < nums.length; j++) {
            // 不能使用相同位置的数字
            if (numsMap.containsKey(target - nums[j]) && j != numsMap.get(target - nums[j])) {
                res[0] = j;
                res[1] = numsMap.get(target - nums[j]);
            }
        }

        return res;
    }
}
