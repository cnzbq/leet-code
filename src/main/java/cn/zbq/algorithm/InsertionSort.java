package cn.zbq.algorithm;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{31, 41, 59, 26, 41, 58};
        insertSort(arr);
        print(arr);
    }

    /**
     * 插入排序
     * <p/>
     * 思路：从数组中的第二个元素开始，假设该元素就是当前要插入的元素，
     * 依次与当前元素位置之前的元素逐一进行比较，直到找到比当前元素小或者大的元素为止
     */
    public static void insertSort(int[] A) {
        // 第一个元素无需比较，从第二个开始
        // 全程都是在模拟数组中的数据是一个个插入的
        for (int i = 1; i < A.length; i++) {
            // 假设i处对应的值为当前插入的值，通过变量保存该值
            int key = A[i];
            // 获取插入位置前一个位置的索引
            int k = i - 1;
            while (k >= 0 && A[k] > key) {
                // 将k的值向右移动一位
                A[k + 1] = A[k];
                // k自减，为下次判断做准备
                k--;
            }
            // 跳出循环后，k+1的位置正好是需要插入key的位置
            A[k + 1] = key;
        }
    }

    private static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
