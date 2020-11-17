package cn.zbq._0121.best_time_to_buy_and_sell_stock;

/**
 * 121. 买卖股票的最佳时机
 *
 * @author zbq
 * @date 2020/11/6
 */
public class MaxProfit {
    /**
     * 解法一：峰谷法
     *
     * @param prices /
     * @return /
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        // 谷，这里代表整个价格数组中最低的价格
        int valley = Integer.MAX_VALUE;
        int size = prices.length - 1;
        int i = 0;

        while (i < size) {
            // 寻找一个谷
            while (i < size && prices[i] >= prices[i + 1]) {
                i++;
            }
            if (i <= size) {
                // 判断当前的谷与上一次的谷哪个更小一些，取值小者
                valley = Math.min(prices[i], valley);
            }

            // 寻找一个峰
            while (i < size && prices[i] <= prices[i + 1]) {
                i++;
            }
            if (i <= size) {
                // 判断当前峰到谷的差值与上一次峰到谷的差值哪个更大一些，取值大者
                maxProfit = Math.max(maxProfit, prices[i] - valley);
            }
        }

        return maxProfit;
    }

    /**
     * 解法二：
     *
     * @param prices /
     * @return /
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int currentMin = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            // 当前价格比上一次价格高 且 上一次的价格小于当前最低价格
            if (prices[i] > prices[i - 1] && prices[i - 1] < currentMin) {
                currentMin = prices[i - 1];
                maxProfit = Math.max(prices[i] - currentMin, maxProfit);
            } else if (prices[i] > currentMin) {
                // 当前价格大于最低价格
                maxProfit = Math.max(prices[i] - currentMin, maxProfit);
            }
        }

        return maxProfit;
    }

    /**
     * 解法三：
     * 与解法二同理，只是进一步优化
     *
     * @param prices /
     * @return /
     */
    public int maxProfit3(int[] prices) {
        int maxProfit = 0;
        // 当前最小值
        int currentMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // 寻找最小值
            if (prices[i] < currentMin) {
                currentMin = prices[i];
            } else {
                // 判断当前值与最小值的差值与上一次收益的大小
                maxProfit = Math.max(prices[i] - currentMin, maxProfit);
            }
        }

        return maxProfit;
    }
}
