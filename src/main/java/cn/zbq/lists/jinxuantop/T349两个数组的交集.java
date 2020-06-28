package cn.zbq.lists.jinxuantop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class T349两个数组的交集 {
    class Solution {

        /**
         * 思路；
         * 1. 利用一个set完成一个数组的去重操作
         * 2. 遍历另外一个数组，并重set中判断是否包含该元素
         * 3. 如果包含该元素，将该元素添加到结果list中，并从set中移除该元素
         */
        public int[] intersection(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            // 指定list大小
            List<Integer> list = new ArrayList<>(Math.min(len1, len2));
            // 利用一个set去重
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < len1; i++) {
                set.add(nums1[i]);
            }

            // 遍历另外一个数组
            for (int i = 0; i < len2; i++) {
                if (set.contains(nums2[i])) {
                    // 如果包含指定的元素，添加到list中，并将其从set移除
                    // 之所以移除是因为在当前数组中可能包含重复元素，不移除的话下次判断时会被再次加入的list
                    list.add(nums2[i]);
                    set.remove(nums2[i]);
                }
            }

            // 将list转为数组
            return list.stream().mapToInt(Integer::valueOf).toArray();

        }
    }
}
