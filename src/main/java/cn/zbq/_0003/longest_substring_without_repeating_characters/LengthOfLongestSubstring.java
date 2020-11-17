package cn.zbq._0003.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * @author zbq
 * @date 2020/11/3
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;
        int currentLen = 0;
        // 上一次移除的位置
        int oldIndex = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            // map中国包含当前字符且 该字符的索引在上一次移除字符索引之后（在有效的滑动窗口之内）
            if (map.containsKey(temp) && map.get(temp) > oldIndex) {
                maxLen = Math.max(maxLen, currentLen);
                int j = map.get(temp);
                currentLen = i - j - 1;
                oldIndex = j;
            }
            map.put(temp, i);
            currentLen++;
        }
        maxLen = Math.max(maxLen, currentLen);
        return maxLen;
    }

    public int lengthOfLongestSubstring3(String s) {
        // 当前起始位置
        int currentIndex = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        // length < 3 ? length + 1 : (int) ((float) length / 0.75F + 1.0F)
        HashMap<Character, Integer> hashMap = new HashMap<>();

        // 默认长度为0
        int len = 0;
        for (int i = 0; i < length; i++) {

            char key = chars[i];
            if (hashMap.containsKey(key)) {
                Integer oldIndex = hashMap.remove(key);
                // 重复值的序列值大于当前起始位置值
                if (oldIndex > currentIndex) {
                    currentIndex = oldIndex;
                }
            }

            int index = i + 1;
            hashMap.put(key, index);
            len = Math.max(len, index - currentIndex);
        }

        return len;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                // 注意：这里j没有增加，当移除i处的字母后，再次判断是否存在重复，如果存在继续移除
                // （相当于从前到后一直在寻找重复的那个字母，巧妙的控制了顺序，实现了队列先进先出的效果）
                // q w e r e（待添加）
                // 第一次：移除q，w e r e（待添加）
                // 第二次：移除w，e r e（待添加）
                // 第三次：移除e，r e（待添加）
                // 第四次： 添加e，r e
                // s.charAt(i++)  这里相当于从第一个字符开始移除，直到set中不在包含即将添加的字符
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
