package cn.zbq.leet0069.sqrtx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 69. x 的平方根测试
 *
 * @author zbq
 * @date 2020/11/16
 */
class MySqrtTest {
    private final MySqrt mySqrt = new MySqrt();

    @Test
    void case1() {
        int result = mySqrt.mySqrt(4);
        Assertions.assertEquals(2, result);
    }

    @Test
    void case2() {
        int result = mySqrt.mySqrt(8);
        Assertions.assertEquals(2, result);
    }

    @Test
    void case3() {
        int result = mySqrt.mySqrt(2147395599);
        Assertions.assertEquals(46339, result);
    }
}