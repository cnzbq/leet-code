package cn.zbq._0081.search_in_rotated_sorted_array_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 81. 搜索旋转排序数组 II 测试
 *
 * @author zbq
 * @date 2020/11/18
 */
class SearchTest {
    private final Search search = new Search();

    @Test
    void case1() {
        boolean result = this.search.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0);
        Assertions.assertTrue(result);
    }

    @Test
    void case2() {
        boolean result = this.search.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3);
        Assertions.assertFalse(result);
    }

    @Test
    void case3() {
        boolean result = this.search.search(new int[]{3,1,1}, 3);
        Assertions.assertTrue(result);
    }
}