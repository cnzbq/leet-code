package cn.zbq.leet0076.minimumwindowsubstring;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 76. 最小覆盖子串测试
 *
 * @author zbq
 * @date 2020/11/12
 */
public class MinWindowTest {
    private final MinWindow minWindow = new MinWindow();

    @Test
    public void case1() {
        String result = minWindow.minWindow("ADOBECODEBANC", "ABC");
        Assertions.assertEquals("BANC", result);
    }

    @Test
    public void case2() {
        String result = minWindow.minWindow("a", "a");
        Assertions.assertEquals("a", result);
    }

    @Test
    public void case3() {
        String result = minWindow.minWindow("abcdadwq", "cdd");
        Assertions.assertEquals("cdad", result);
    }
}