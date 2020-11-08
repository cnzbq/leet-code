package cn.zbq.leet0435.nonoverlappingintervals;

import org.junit.Assert;
import org.junit.Test;

/**
 * 435. 无重叠区间测试
 *
 * @author zbq
 * @date 2020/11/8
 */
public class EraseOverlapIntervalsTest {
    private final EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();

    @Test
    public void case1() {
        int result = eraseOverlapIntervals.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
        Assert.assertEquals(1, result);
    }

    @Test
    public void case2() {
        int result = eraseOverlapIntervals.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}});
        Assert.assertEquals(2, result);
    }

    @Test
    public void case3() {
        int result = eraseOverlapIntervals.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}});
        Assert.assertEquals(0, result);
    }
}