package cn.zbq.leet0633.sumofsquarenumbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * 633. 平方数之和测试
 *
 * @author zbq
 * @date 2020/11/13
 */
public class JudgeSquareSumTest {
    private final JudgeSquareSum judgeSquareSum = new JudgeSquareSum();

    @Test
    public void case1() {
        boolean result = judgeSquareSum.judgeSquareSum(5);
        Assert.assertTrue(result);
    }

    @Test
    public void case2() {
        boolean result = judgeSquareSum.judgeSquareSum(3);
        Assert.assertFalse(result);
    }

    @Test
    public void case3() {
        boolean result = judgeSquareSum.judgeSquareSum(4);
        Assert.assertTrue(result);
    }

    @Test
    public void case4() {
        boolean result = judgeSquareSum.judgeSquareSum(2);
        Assert.assertTrue(result);
    }

    @Test
    public void case5() {
        boolean result = judgeSquareSum.judgeSquareSum(1);
        Assert.assertTrue(result);
    }

    @Test
    public void case6() {
        boolean result = judgeSquareSum.judgeSquareSum(1000000);
        Assert.assertTrue(result);
    }

    @Test
    public void case7() {
        boolean result = judgeSquareSum.judgeSquareSum(10);
        Assert.assertTrue(result);
    }
}