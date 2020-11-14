package cn.zbq.leet0001.twosum;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 两数之和测试
 *
 * @author zbq
 * @date 2020/11/2
 */
public class TwoSumTest {
    private TwoSum twoSum;

    @BeforeAll
    public void before() {
        this.twoSum = new TwoSum();
    }

    @Test
    public void case1() {
        int[] nums = new int[]{3, 2, 4};
        int[] result = twoSum.twoSum(nums, 6);
        Assertions.assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void case2() {
        int[] nums = new int[]{3, 2, 4};
        int[] result = twoSum.twoSum(nums, 5);
        Assertions.assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void case3() {
        int[] nums = new int[]{0, 8, 7, 3, 3, 4, 2};
        int[] result = twoSum.twoSum(nums, 11);
        Assertions.assertArrayEquals(new int[]{1, 3}, result);
    }

    @Test
    public void case4() {
        int[] nums = new int[]{0, 1};
        int[] result = twoSum.twoSum(nums, 1);
        Assertions.assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void case5() {
        int[] nums = new int[]{0, 3};
        int[] result = twoSum.twoSum(nums, 5);
        Assertions.assertArrayEquals(new int[]{}, result);
    }
}