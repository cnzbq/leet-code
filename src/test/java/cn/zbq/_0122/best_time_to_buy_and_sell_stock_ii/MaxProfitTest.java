package cn.zbq._0122.best_time_to_buy_and_sell_stock_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 122. 买卖股票的最佳时机 II 测试
 *
 * @author zbq
 * @date 2020/11/6
 */
public class MaxProfitTest {
    private MaxProfit maxProfit;

    @BeforeAll
    public void before() {
        maxProfit = new MaxProfit();
    }

    @Test
    public void case1() {
        int max = maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        Assertions.assertEquals(7, max);
    }

    @Test
    public void case2() {
        int max = maxProfit.maxProfit(new int[]{1, 2, 3, 4, 5});
        Assertions.assertEquals(4, max);
    }

    @Test
    public void case3() {
        int max = maxProfit.maxProfit(new int[]{7, 6, 4, 3, 1});
        Assertions.assertEquals(0, max);
    }

    @Test
    public void case4() {
        int max = maxProfit.maxProfit(new int[]{});
        Assertions.assertEquals(0, max);
    }

    @Test
    public void case5() {
        int max = maxProfit.maxProfit(new int[]{1, 2, 10, 11, 12, 15});
        Assertions.assertEquals(14, max);
    }

    @Test
    public void case6() {
        int max = maxProfit.maxProfit2(new int[]{3, 3});
        Assertions.assertEquals(0, max);
    }
}