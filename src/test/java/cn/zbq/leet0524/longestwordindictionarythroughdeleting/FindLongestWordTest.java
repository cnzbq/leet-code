package cn.zbq.leet0524.longestwordindictionarythroughdeleting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 524. 通过删除字母匹配到字典里最长单词 测试
 *
 * @author zbq
 * @date 2020/11/15
 */
class FindLongestWordTest {
    private final FindLongestWord findLongestWord = new FindLongestWord();

    @Test
    void case1() {
        String result = findLongestWord.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea"));
        Assertions.assertEquals("apple", result);
    }

    @Test
    void case2() {
        String result = findLongestWord.findLongestWord("abpcplea", Arrays.asList("a", "b", "c"));
        Assertions.assertEquals("a", result);
    }

    @Test
    void case3() {
        String result = findLongestWord.findLongestWord("abpcplea", Arrays.asList("a", "bp", "c"));
        Assertions.assertEquals("bp", result);
    }

    @Test
    void case4() {
        String result = findLongestWord.findLongestWord("abpcplea", Arrays.asList("a", "cp", "bp"));
        Assertions.assertEquals("bp", result);
    }

    @Test
    void case5() {
        String result = findLongestWord.findLongestWord("", Arrays.asList("a", "cp", "bp"));
        Assertions.assertEquals("", result);
    }

    @Test
    void case6() {
        String result = findLongestWord.findLongestWord("zjekl", Arrays.asList("a", "cp", "bp"));
        Assertions.assertEquals("", result);
    }
}