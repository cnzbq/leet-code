package cn.zbq.leet0122.besttimetobuyandsellstockii;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author zbq
 * @date 2020/11/5
 */
public class MaxProfit {
    /**
     * 解法一
     *
     * @param prices /
     * @return /
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 一直向后遍历寻找，如果当前的值大于前一个的值，说明是一个盈利的点，累加每一个小的盈利点后就是一个整的盈利
            // 相当于从头开始，只要是上升就计算利润
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    /**
     * 解法二
     *
     * @param prices /
     * @return /
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        // 谷
        int valley;
        int i = 0;
        int size = prices.length - 1;
        while (i < size) {
            // 寻找当天价格比明天低的点作为谷
            while (i < size && prices[i] > prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            // 寻找当天价格高于明天的点作为峰
            while (i < size && prices[i] < prices[i + 1]) {
                i++;
            }
            // 计算峰与谷的差异
            maxProfit += prices[i] - valley;
        }

        return maxProfit;
    }
}
