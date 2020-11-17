package cn.zbq._0680.valid_palindrome_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Dingwq
 * @date 2020/11/14
 */
public class ValidPalindromeTest {
    private ValidPalindrome validPalindrome = new ValidPalindrome();

    @Test
    public void case1() {
        boolean result = validPalindrome.validPalindrome("aba");
        Assertions.assertTrue(result);
    }

    @Test
    public void case2() {
        boolean result = validPalindrome.validPalindrome("abca");
        Assertions.assertTrue(result);
    }

    @Test
    public void case3() {
        boolean result = validPalindrome.validPalindrome("caba");
        Assertions.assertTrue(result);
    }

    @Test
    public void case4() {
        boolean result = validPalindrome.validPalindrome("abad");
        Assertions.assertTrue(result);
    }

    @Test
    public void case5() {
        boolean result = validPalindrome.validPalindrome("abcde");
        Assertions.assertFalse(result);
    }

    @Test
    public void case6() {
        boolean result = validPalindrome.validPalindrome("abade");
        Assertions.assertFalse(result);
    }

    @Test
    public void case7() {
        boolean result = validPalindrome.validPalindrome("ababa");
        Assertions.assertTrue(result);
    }

    @Test
    public void case8() {
        boolean result = validPalindrome.validPalindrome("abacba");
        Assertions.assertTrue(result);
    }

    @Test
    public void case9() {
        boolean result = validPalindrome.validPalindrome("dnmabacba");
        Assertions.assertFalse(result);
    }

    @Test
    public void case10() {
        boolean result = validPalindrome.validPalindrome("a");
        Assertions.assertTrue(result);
    }

    @Test
    public void case11() {
        boolean result = validPalindrome.validPalindrome("eeccccbebaeeabebccceea");
        Assertions.assertFalse(result);
    }

    @Test
    public void case12() {
        boolean result = validPalindrome.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
        Assertions.assertTrue(result);
    }
}