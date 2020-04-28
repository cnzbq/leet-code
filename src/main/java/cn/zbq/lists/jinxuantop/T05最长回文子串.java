package cn.zbq.lists.jinxuantop;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划

/**
 * 最长回文子串
 */
public class T05最长回文子串 {
    /**
     * 暴力解法
     *
     * @param s /
     * @return /
     */
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int len = s.length();
        String result = "";

        // 倒着减少
        for (int i = len; i > 0; i--) {
            // 正向增加
            for (int j = 0; j < i; j++) {
                // 截取区间子串
                String s1 = s.substring(j, i);
                int count = 0;
                int length = s1.length();

                for (int k = 0; k < length / 2; k++) {
                    // 判断首位字母是否一致
                    // length - k - 1 利用向下取整，可以不用判断奇偶
                    if (s1.charAt(k) == s1.charAt(length - k - 1)) {
                        count++;
                    }
                }

                // 相同次数等于长度一半，说明是回文
                if (count == length / 2) {
                    // 比较既有串与新串哪个更长一些
                    result = result.length() < s1.length() ? s1 : result;
                }
            }
        }
        return result;
    }

    // 官方题解
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 长度为奇数
            int l1 = lookUpMaxLenRange(s, i, i);
            // 长度为偶数
            int l2 = lookUpMaxLenRange(s, i, i + 1);
            int l = Math.max(l1, l2);
            if (l > end - start) {
                // 计算起始和结束
                // 长度从1开始计算，但索引是从0开始，所以长度减去1，然后左右各一半
                // <--
                start = i - (l - 1) / 2;
                // 向下取整
                // -->
                end = i + l / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // 寻找最长范围
    private static int lookUpMaxLenRange(String s, int leftIndex, int rightIndex) {
        int left = leftIndex, right = rightIndex;
        // 从给定位置开始寻找，每次前外侧走一个单位
        // 左侧不能小于0，右侧不能大于字符串的长度，并且左右两侧字符要相等
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 左右不满足才会从循环中结束，此时会比符合条件的数据长度多1
        // fgaba
        // 01234
        // 满足条件时 right = 2，left=4，但从循环中结束时，right =1，left=5，此时符合条件的长度为3，left-right-1=3
        return right - left - 1;
    }
}
