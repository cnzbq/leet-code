package cn.zbq._0076.minimum_window_substring;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 *
 * @author zbq
 * @date 2020/11/12
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        // 两个字符串的长度，并且s要大于等于t
        int lenS = s.length();
        int lenT = t.length();
        if (lenS == 0 || lenT == 0 || lenT > lenS) {
            return "";
        }

        // 将字符串转为字符数组
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        // 遍历t中字符出现的频率
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (char c : charArrayT) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        // 最小子串的起始位置
        int begin = 0;
        // 最小子串的长度，初始为一个达不到的大值即可
        int min = lenS + 1;
        // 标记左右两个指针的位置
        int left = 0, right = 0;
        // 标记左右两个指针的区间是否满足t中字符出现的频率
        int distances = 0;

        // 遍历s
        for (char c : charArrayS) {
            // 右侧指针向前移动
            right++;
            // 如果不是t中的字符则直接进行下次遍历
            if (!mapT.containsKey(c)) {
                continue;
            }

            // 是t中的字符，如果频率大于0，distances+1，表示当前已满足该字符的一个频度
            Integer count = mapT.get(c);
            if (count > 0) {
                distances++;
            }
            // 这里只要有t中的字符出现，就在其频率上减少1
            mapT.put(c, count - 1);

            // 当字符出现的频率等于t的长度时，说明两个指针间的字符串已出现t中所有字符
            while (distances == lenT) {
                // 判断当前字符串的长度
                if (right - left < min) {
                    min = right - left;
                    // 最小子串时维护起始位置
                    begin = left;
                }

                char c1 = charArrayS[left];
                // 判断左指针处字符是否是t中的字符
                if (mapT.containsKey(c1)) {
                    // 如果值为0，说明当前串已到达满足t中所有字符的临界值
                    if (mapT.get(c1) == 0) {
                        distances--;
                    }
                    // 这里只要出现t中的字符直接加，超出频度部分与上面直接减可以相互抵消
                    mapT.put(c1, mapT.get(c1) + 1);
                }
                // 左指针继续向前移动
                left++;
            }
        }

        // 最小值为初始值时说明未找到
        if (min == lenS + 1) {
            return "";
        }

        return s.substring(begin, begin + min);
    }
}
