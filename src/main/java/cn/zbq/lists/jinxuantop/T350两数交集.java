package cn.zbq.lists.jinxuantop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T350两数交集 {

    class Solution {

        /**
         * 1. 将长度较长的数组转化为map
         * 2. 遍历另外一个数组，判断map中是否出现
         * 3. 出现则加入结果list
         * 注意：需要动态维护map中key的出现频率，即value值
         */
        public int[] intersect(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            List<Integer> list = new ArrayList<>();
            if (len1 > len2) {
                HashMap<Integer, Integer> map = toHashMap(nums1, len1);
                search(nums2, list, map);
            } else {
                HashMap<Integer, Integer> map = toHashMap(nums2, len2);
                search(nums1, list, map);
            }
            return list.stream().mapToInt(Integer::valueOf).toArray();
        }

        /**
         * 将数组转化为map
         * 元素为map中的key，元素出现的次数为value
         */
        private HashMap<Integer, Integer> toHashMap(int[] num, int length) {
            int v = (int) (length / 0.75) + 1;
            HashMap<Integer, Integer> map = new HashMap<>(v);
            for (int i : num) {
                int count = 0;
                if (map.containsKey(i)) {
                    count = map.get(i);
                    count++;
                }
                map.put(i, count);
            }
            return map;
        }

        /**
         * 1. 从数组中查找在map中出现的元素
         * 2. 找到元素后添加到list中
         * 3. 从map中获取该元素对应的值，并将其减1
         * 4. 如果元素对应的值小于0，说明此元素在第一个数组中出现的次数已经使用完，从map中删除
         * 5. 如果大于0，则继续保存到map中，更新原值
         */
        private void search(int[] nums, List<Integer> list, HashMap<Integer, Integer> map) {
            for (int i : nums) {
                if (map.containsKey(i)) {
                    list.add(i);
                    Integer count = map.get(i);
                    if (--count < 0) {
                        map.remove(i);
                    } else {
                        map.put(i, count);
                    }
                }
            }
        }
    }
}
