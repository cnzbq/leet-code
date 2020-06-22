package cn.zbq.lists.jinxuantop;

import java.util.HashMap;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表
public class T242有效的字母异位词 {

    /**
     * 解题思路：先统计一个字符串中每个字符出现的个数，然后再遍历另一个字符串字符时递减
     */
    class Solution {
        public boolean isAnagram(String s, String t) {

            if (s.length() != t.length()) {
                return false;
            }

            char[] s1 = s.toCharArray();
            char[] t1 = t.toCharArray();

            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                Integer count = hashMap.getOrDefault(s1[i], 0);
                hashMap.put(s1[i], ++count);
            }

            for (int i = 0; i < t.length(); i++) {
                Integer count = hashMap.getOrDefault(t1[i], 0);
                if (count <= 0) {
                    return false;
                }
                hashMap.put(t1[i], --count);
            }

            return true;
        }
    }
}
