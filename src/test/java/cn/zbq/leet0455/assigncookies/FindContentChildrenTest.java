package cn.zbq.leet0455.assigncookies;

import org.junit.Assert;
import org.junit.Test;

/**
 * 455. 分发饼干测试
 *
 * @author zbq
 * @date 2020/11/7
 */
public class FindContentChildrenTest {
    private final FindContentChildren findContentChildren = new FindContentChildren();

    @Test
    public void case1() {
        int result = findContentChildren.findContentChildren2(new int[]{1, 2, 3}, new int[]{1, 1});
        Assert.assertEquals(1, result);
    }

    @Test
    public void case2() {
        int result = findContentChildren.findContentChildren2(new int[]{1, 2}, new int[]{1, 2, 3});
        Assert.assertEquals(2, result);
    }
}