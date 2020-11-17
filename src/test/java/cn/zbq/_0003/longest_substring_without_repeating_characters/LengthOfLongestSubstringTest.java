package cn.zbq._0003.longest_substring_without_repeating_characters;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 无重复字符的最长子串测试
 *
 * @author zbq
 * @date 2020/11/3
 */
public class LengthOfLongestSubstringTest {
    private LengthOfLongestSubstring lengthOfLongestSubstring;

    @BeforeAll
    public void before() {
        this.lengthOfLongestSubstring = new LengthOfLongestSubstring();
    }

    @Test
    public void case1() {
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
        Assertions.assertEquals(3, result);
    }

    @Test
    public void case2() {
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void case3() {
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew");
        Assertions.assertEquals(3, result);
    }

    @Test
    public void case4() {
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("");
        Assertions.assertEquals(0, result);
    }

    @Test
    public void case5() {
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("abba");
        Assertions.assertEquals(2, result);
    }
}