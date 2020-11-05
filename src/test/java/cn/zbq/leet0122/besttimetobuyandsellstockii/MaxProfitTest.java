package cn.zbq.leet0122.besttimetobuyandsellstockii;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 122. 买卖股票的最佳时机 II 测试
 *
 * @author zbq
 * @date 2020/11/6
 */
public class MaxProfitTest {
    private MaxProfit maxProfit;

    @Before
    public void before() {
        maxProfit = new MaxProfit();
    }

    @Test
    public void case1() {
        int max = maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        Assert.assertEquals(7, max);
    }

    @Test
    public void case2() {
        int max = maxProfit.maxProfit(new int[]{1, 2, 3, 4, 5});
        Assert.assertEquals(4, max);
    }

    @Test
    public void case3() {
        int max = maxProfit.maxProfit(new int[]{7, 6, 4, 3, 1});
        Assert.assertEquals(0, max);
    }

    @Test
    public void case4() {
        int max = maxProfit.maxProfit(new int[]{});
        Assert.assertEquals(0, max);
    }

    @Test
    public void case5() {
        int max = maxProfit.maxProfit(new int[]{1, 2, 10, 11, 12, 15});
        Assert.assertEquals(14, max);
    }
}