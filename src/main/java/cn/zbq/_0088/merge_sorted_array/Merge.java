package cn.zbq._0088.merge_sorted_array;

/**
 * 88. 合并两个有序数组
 *
 * @author zbq
 * @date 2020/11/10
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0) {
            return;
        }
        int pos = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[pos--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[pos--] = nums2[n--];
        }
    }
}
