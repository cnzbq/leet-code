package cn.zbq._0081.search_in_rotated_sorted_array_ii;

/**
 * 81. 搜索旋转排序数组 II
 *
 * @author zbq
 * @date 2020/11/18
 */
public class Search {
public boolean search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == target) {
            return true;
        }
        if (nums[mid] == nums[left]) {
            left++;
        } else if (nums[mid] > nums[right]) {
            // 左侧有序
            // 目标值在左侧
            if (nums[mid] > target && nums[left] <= target) {
                right = mid - 1;
            } else {
                // 目标值在右侧
                left = mid + 1;
            }
        } else {
            // 右侧有序
            // 目标值在右侧
            if (nums[mid] < target && nums[right] >= target) {
                left = mid + 1;
            } else {
                // 目标值在左侧
                right = mid - 1;
            }
        }
    }
    return false;
}
}
