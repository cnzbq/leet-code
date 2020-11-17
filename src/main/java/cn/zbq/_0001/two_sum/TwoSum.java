package cn.zbq._0001.two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author zbq
 * @date 2020/11/2
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
