package cn.zbq.leet0003.lengthoflongestsubstring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 无重复字符的最长子串测试
 *
 * @author zbq
 * @date 2020/11/3
 */
public class LengthOfLongestSubstringTest {
    private LengthOfLongestSubstring lengthOfLongestSubstring;

    @Before
    public void before() {
        this.lengthOfLongestSubstring = new LengthOfLongestSubstring();
    }

    @Test
    public void case1() {
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
        Assert.assertEquals(3, result);
    }

    @Test
    public void case2() {
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb");
        Assert.assertEquals(1, result);
    }

    @Test
    public void case3() {
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew");
        Assert.assertEquals(3, result);
    }

    @Test
    public void case4() {
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("");
        Assert.assertEquals(0, result);
    }

    @Test
    public void case5() {
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("abba");
        Assert.assertEquals(2, result);
    }
}