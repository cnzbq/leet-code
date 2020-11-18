package cn.zbq._0034.find_first_and_last_position_of_element_in_sorted_array;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author zbq
 * @date 2020/11/17
 */
public class SearchRange {
    public int[] searchRange1(int[] nums, int target) {
        int[] result = {-1, -1};
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (result[0] == -1) {
                    if (nums[l] == target) {
                        result[0] = l;
                    } else {
                        l++;
                    }
                }
                if (result[1] == -1) {
                    if (nums[r] == target) {
                        result[1] = r;
                    } else {
                        r--;
                    }
                }
                if (result[0] != -1 && result[1] != -1) {
                    break;
                }

            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }

        return result;
    }

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[]{-1, -1};
        int length = nums.length;
        result[0] = findFirst(nums, target, length);
        result[1] = findLast(nums, target, length);

        return result;
    }

    private int findLast(int[] nums, int target, int length) {
        int right;
        int left;

        left = 0;
        right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 只要找到右侧边界不是大于目标值，即是最后一个
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right > -1 && nums[right] == target) {
            return right;
        }
        return -1;
    }

    private int findFirst(int[] nums, int target, int length) {
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 只要中点的值大于等于目标值，右侧的边界就缩小，最后在临界点右侧的边界会跑到左侧边界的左边
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left < length && nums[left] == target) {
            return left;
        }

        return -1;
    }
}
