package cn.zbq.lists.jinxuantop;
//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
//
// 示例1:
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true
//
// 示例 2:
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false
//
// 示例 3:
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false
//
// 示例 4:
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false
//
// 说明:
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
// Related Topics 哈希表

import java.util.HashMap;

public class T290单词规律 {

    static class Solution {
        /**
         * 1.将给定字符串按空格进行分割
         * 2.遍历分割好的字符串
         * 3.判断map中是否已经存在，存在获取其值，判断与当前的匹配字符是否一致
         * 4.不存在，判断字符map中当前字符是否已经存在，存在说明相同字符对应到了不同的字符串，直接返回false
         * 5. 字符map中不存在，向map中添加
         */
        public boolean wordPattern(String pattern, String str) {
            String[] s = str.split(" ");
            char[] chars = pattern.toCharArray();
            if (s.length != chars.length) {

                return false;
            }

            // 字符数组遍历索引位置
            int index = 0;
            // 单词map
            HashMap<String, Character> map = new HashMap<>();
            // 匹配字符map（可以使用set）
            HashMap<Character, Object> p = new HashMap<>();
            for (String s1 : s) {
                if (map.containsKey(s1)) {
                    Character obj = map.get(s1);
                    if (!obj.equals(chars[index])) {

                        return false;
                    }
                } else if (p.containsKey(chars[index])) {
                    // 匹配字符map中之前出现过，但是对应的单词不同，直接返false
                    return false;
                } else {
                    // 新出现的单词和匹配字符，添加到对应的map中
                    map.put(s1, chars[index]);
                    p.put(chars[index], null);
                }

                index++;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abba", "ddog cat cat fish"));
    }
}
