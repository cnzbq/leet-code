package cn.zbq._0633.sum_of_square_numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertTrue(result);
    }

    @Test
    public void case2() {
        boolean result = judgeSquareSum.judgeSquareSum(3);
        Assertions.assertFalse(result);
    }

    @Test
    public void case3() {
        boolean result = judgeSquareSum.judgeSquareSum(4);
        Assertions.assertTrue(result);
    }

    @Test
    public void case4() {
        boolean result = judgeSquareSum.judgeSquareSum(2);
        Assertions.assertTrue(result);
    }

    @Test
    public void case5() {
        boolean result = judgeSquareSum.judgeSquareSum(1);
        Assertions.assertTrue(result);
    }

    @Test
    public void case6() {
        boolean result = judgeSquareSum.judgeSquareSum(1000000);
        Assertions.assertTrue(result);
    }

    @Test
    public void case7() {
        boolean result = judgeSquareSum.judgeSquareSum(10);
        Assertions.assertTrue(result);
    }
}