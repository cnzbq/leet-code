package cn.zbq.leet0001.twosum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 两数之和测试
 *
 * @author zbq
 * @date 2020/11/2
 */
public class TwoSumTest {
    private TwoSum twoSum;

    @Before
    public void before() {
        this.twoSum = new TwoSum();
    }

    @Test
    public void case1() {
        int[] nums = new int[]{3, 2, 4};
        int[] result = twoSum.twoSum(nums, 6);
        Assert.assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void case2() {
        int[] nums = new int[]{3, 2, 4};
        int[] result = twoSum.twoSum(nums, 5);
        Assert.assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void case3() {
        int[] nums = new int[]{0, 8, 7, 3, 3, 4, 2};
        int[] result = twoSum.twoSum(nums, 11);
        Assert.assertArrayEquals(new int[]{1, 3}, result);
    }

    @Test
    public void case4() {
        int[] nums = new int[]{0, 1};
        int[] result = twoSum.twoSum(nums, 1);
        Assert.assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void case5() {
        int[] nums = new int[]{0, 3};
        int[] result = twoSum.twoSum(nums, 5);
        Assert.assertArrayEquals(new int[]{}, result);
    }
}