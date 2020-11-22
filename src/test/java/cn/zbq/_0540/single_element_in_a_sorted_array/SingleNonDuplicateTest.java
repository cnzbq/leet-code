package cn.zbq._0540.single_element_in_a_sorted_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 540. 有序数组中的单一元素测试
 *
 * @author zbq
 * @date 2020/11/20
 */
class SingleNonDuplicateTest {
    private final SingleNonDuplicate singleNonDuplicate = new SingleNonDuplicate();

    @Test
    void case1() {
        int result = singleNonDuplicate.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8});
        Assertions.assertEquals(2, result);
    }

    @Test
    void case2() {
        int result = singleNonDuplicate.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11});
        Assertions.assertEquals(10, result);
    }
}