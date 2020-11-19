package cn.zbq._0154.find_minimum_in_rotated_sorted_array_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 154. 寻找旋转排序数组中的最小值 II 测试
 *
 * @author zbq
 * @date 2020/11/19
 */
class FindMinTest {
    private final FindMin findMin = new FindMin();

    @Test
    void case1() {
        int result = findMin.findMin(new int[]{1, 3, 5});
        Assertions.assertEquals(1, result);
    }

    @Test
    void case2() {
        int result = findMin.findMin(new int[]{2, 2, 2, 0, 1});
        Assertions.assertEquals(0, result);
    }

    @Test
    void case3() {
        int result = findMin.findMin(new int[]{10, 2, 10, 10, 10, 10});
        Assertions.assertEquals(2, result);
    }

    @Test
    void case4() {
        int result = findMin.findMin(new int[]{2, 3, 1});
        Assertions.assertEquals(1, result);
    }

    @Test
    void case5() {
        int result = findMin.findMin(new int[]{1, 1});
        Assertions.assertEquals(1, result);
    }

    @Test
    void case6() {
        int result = findMin.findMin(new int[]{5, 1, 2, 3, 4});
        Assertions.assertEquals(1, result);
    }

    @Test
    void case7() {
        int result = findMin.findMin(new int[]{1, 2, 3});
        Assertions.assertEquals(1, result);
    }

    @Test
    void case8() {
        int result = findMin.findMin(new int[]{1});
        Assertions.assertEquals(1, result);
    }

    @Test
    void case9() {
        int result = findMin.findMin(new int[]{1, 2});
        Assertions.assertEquals(1, result);
    }

    @Test
    void case10() {
        int result = findMin.findMin(new int[]{2, 1});
        Assertions.assertEquals(1, result);
    }

    @Test
    void case11() {
        int result = findMin.findMin(new int[]{3, 4, 5, 1, 2});
        Assertions.assertEquals(1, result);
    }

    @Test
    void case12() {
        int result = findMin.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        Assertions.assertEquals(0, result);
    }
}