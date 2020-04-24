package cn.zbq.lists.jinxuantop;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window

import java.util.*;

/**
 * 无重复字符的最长子串
 */
public class T03无重复字符的最长子串 {
    public static int lengthOfLongestSubstring3(String s) {
        Queue<Character> queue = new ArrayDeque<>();
        int q = 0;
        int r = 0;
        for (int i = 0; i < s.length(); ) {
            if (!queue.contains(s.charAt(i))) {
                queue.add(s.charAt(i));
                i++;
                r = Math.max(r, i - q);
            } else {
                queue.remove(s.charAt(q++));
            }
        }
        return r;
    }

    /**
     * 官方解法2
     * 时间复杂度：O(2n) = O(n)O(2n)=O(n)，在最糟糕的情况下，每个字符将被 ii 和 jj 访问两次。
     * <p>
     * 空间复杂度：O(min(m, n))O(min(m,n))，与之前的方法相同。滑动窗口法需要 O(k)O(k) 的空间，其中 kk 表示 Set 的大小。而 Set 的大小取决于字符串 nn 的大小以及字符集 / 字母 mm 的大小。
     * <p>
     */
    public static int lengthOfLongestSubstring(String s) {
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
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 当前起始位置
        int currentIndex = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        HashMap<Character, Integer> hashMap = new HashMap<>(length < 3 ? length + 1 : (int) ((float) length / 0.75F + 1.0F));

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

    public static void main(String[] args) {
//        long begin = System.currentTimeMillis();
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lengthOfLongestSubstring("bbbbbuipjikeqd"));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("t1111polkdf1"));
//        System.out.println(lengthOfLongestSubstring("t"));
//        System.out.println(lengthOfLongestSubstring("abcdefghijk"));
//        System.out.println(lengthOfLongestSubstring(""));
//        System.out.println(System.currentTimeMillis() - begin);
        System.out.println(lengthOfLongestSubstring3("qakjbmjonvcxwe"));
    }
}
