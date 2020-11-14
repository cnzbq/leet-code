package cn.zbq.leet0167.twosumiiinputarrayissorted;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 167. 两数之和 II - 输入有序数组测试
 *
 * @author zbq
 * @date 2020/11/9
 */
public class TwoSumTest {
    private final TwoSum twoSum = new TwoSum();

    @Test
    public void case1() {
        int[] result = twoSum.twoSum1(new int[]{2, 7, 11, 15}, 9);
        Assertions.assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void case2() {
        int[] result = twoSum.twoSum1(new int[]{}, 9);
        Assertions.assertArrayEquals(new int[]{}, result);
    }

    @Test
    public void case3() {
        int[] result = twoSum.twoSum1(new int[]{1, 2, 3, 4}, 9);
        Assertions.assertArrayEquals(new int[]{}, result);
    }
}