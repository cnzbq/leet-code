package cn.zbq.leet0121.besttimetobuyandsellstock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 121. 买卖股票的最佳时机测试
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
        int result = maxProfit.maxProfit2(new int[]{7, 1, 5, 3, 6, 4});
        Assert.assertEquals(5, result);
    }

    @Test
    public void case2() {
        int result = maxProfit.maxProfit2(new int[]{7, 6, 4, 3, 1});
        Assert.assertEquals(0, result);
    }

    @Test
    public void case3() {
        int result = maxProfit.maxProfit2(new int[]{});
        Assert.assertEquals(0, result);
    }

    @Test
    public void case4() {
        int result = maxProfit.maxProfit2(new int[]{1, 2});
        Assert.assertEquals(1, result);
    }

    @Test
    public void case5() {
        int result = maxProfit.maxProfit2(new int[]{3, 3});
        Assert.assertEquals(0, result);
    }
}