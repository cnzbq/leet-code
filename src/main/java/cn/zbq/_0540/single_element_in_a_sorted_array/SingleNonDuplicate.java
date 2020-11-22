package cn.zbq._0540.single_element_in_a_sorted_array;

/**
 * 540. 有序数组中的单一元素
 *
 * @author zbq
 * @date 2020/11/20
 */
public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 二分求中点
            int mid = left + ((right - left) >> 1);
            // 判断左侧元素是否是偶数
            boolean flag = (right - mid) % 2 == 0;
            // 判断相同的元素是否在中点的左侧
            if (nums[mid] == nums[mid + 1]) {
                if (flag) {
                    // 如果左侧是偶数，在去掉相同元素之后，左侧即为奇数，唯一元素也就在左侧
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else
                // 判断相同的元素是否在中点的右侧
                if (nums[mid] == nums[mid - 1]) {
                    if (flag) {
                        // 如果左侧是偶数，说明唯一元素在右侧
                        right = mid - 2;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    // 找到唯一的元素
                    return nums[mid];
                }
        }

        return nums[left];
    }
}
