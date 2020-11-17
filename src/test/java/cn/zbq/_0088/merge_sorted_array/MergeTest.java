package cn.zbq._0088.merge_sorted_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 88. 合并两个有序数组测试
 *
 * @author zbq
 * @date 2020/11/10
 */
public class MergeTest {
    //    private ByteArrayOutputStream outputStream;
    private Merge merge;

    @BeforeEach
    public void setUp() {
        // outputStream = new ByteArrayOutputStream();
        merge = new Merge();
        // System.setOut(new PrintStream(outputStream));
    }

//    @AfterEach
//    public void tearDown() {
//        System.setOut(System.out);
//    }

    @Test
    public void case1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        merge.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    public void case2() {
        int[] nums1 = {1, 2, 0, 0, 0};
        merge.merge(nums1, 2, new int[]{2, 5, 6}, 3);
        Assertions.assertArrayEquals(new int[]{1, 2, 2, 5, 6}, nums1);
    }

    @Test
    public void case3() {
        int[] nums1 = {};
        merge.merge(nums1, 0, new int[]{}, 0);
        Assertions.assertArrayEquals(new int[]{}, nums1);
    }

    @Test
    public void case4() {
        int[] nums1 = {9, 0};
        merge.merge(nums1, 1, new int[]{1}, 1);
        Assertions.assertArrayEquals(new int[]{1, 9}, nums1);
    }
}