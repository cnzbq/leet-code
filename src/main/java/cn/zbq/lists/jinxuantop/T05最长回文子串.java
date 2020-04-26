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
}
