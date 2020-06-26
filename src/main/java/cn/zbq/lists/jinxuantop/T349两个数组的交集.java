package cn.zbq.lists.jinxuantop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class T349两个数组的交集 {
    class Solution {

        public int[] intersection(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            List<Integer> list = new ArrayList<>(Math.min(len1, len2));
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < len1; i++) {
                set.add(nums1[i]);
            }

            for (int i = 0; i < len2; i++) {
                if (set.contains(nums2[i])) {
                    list.add(nums2[i]);
                    set.remove(nums2[i]);
                }
            }

            return list.stream().mapToInt(Integer::valueOf).toArray();

        }
    }
}
