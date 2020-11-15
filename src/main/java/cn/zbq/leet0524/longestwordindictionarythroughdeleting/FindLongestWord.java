package cn.zbq.leet0524.longestwordindictionarythroughdeleting;

import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 *
 * @author zbq
 * @date 2020/11/15
 */
public class FindLongestWord {
/**
 * 判断subStr 是否是 Str 的子串
 *
 * @param str    字符串
 * @param subStr 子串
 * @return true or false
 */
private boolean isSubString(String str, String subStr) {
    char[] strCharArr = str.toCharArray();
    char[] subCharArr = subStr.toCharArray();
    int j = 0;
    for (int i = 0; i < str.length() && j < subStr.length(); i++) {
        // 一直向前，判断str是否包含subStr中的每一个字符
        if (strCharArr[i] == subCharArr[j]) {
            ++j;
        }
    }
    // 如果都包含的话 j == subStr.length() 成立
    return j == subStr.length();
}


public String findLongestWord(String s, List<String> d) {
    if (s == null || s.length() < 1 || d.size() < 1) {
        return "";
    }
    String maxStr = "";
    // 循环给定的字典
    for (String s1 : d) {
        // 判断其是否为子串
        if (isSubString(s, s1)) {
            int s1Len = s1.length();
            int maxStrLen = maxStr.length();
            // 判断长度及字典序
            if (s1Len > maxStrLen || (s1Len == maxStrLen && s1.compareTo(maxStr) < 0)) {
                maxStr = s1;
            }
        }
    }

    return maxStr;
}
}
