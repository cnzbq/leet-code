package cn.zbq._0154.find_minimum_in_rotated_sorted_array_ii;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 *
 * @author zbq
 * @date 2020/11/19
 */
public class FindMin {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int pivot = low + ((high - low) >> 1);
            if (nums[pivot] > nums[high]) {
                // 中间值大于右侧的，说明最小值在右侧,并且当前值肯定不是最小值，所以可以直接中间点+1
                low = pivot + 1;
            } else if (nums[pivot] < nums[high]) {
                // 中间值小于右侧的，说明最小值在左侧
                high = pivot;
            } else {
                // 如果是重复元素，无法判断，右侧向左侧收敛
                high--;
            }
        }

        return nums[low];
    }
}
