package cn.zbq.leet0167.twosumiiinputarrayissorted;

import java.util.HashMap;
import java.util.Map;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * @author zbq
 * @date 2020/11/9
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        if (length <= 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int result = target - numbers[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i + 1};
            }
            map.put(numbers[i], i + 1);
        }

        return new int[]{};
    }

    public int[] twoSum1(int[] numbers, int target) {
        int length = numbers.length;
        if (length <= 0) {
            return new int[]{};
        }

        for (int i = 0, j = length - 1; i < j; ) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[]{};
    }
}
