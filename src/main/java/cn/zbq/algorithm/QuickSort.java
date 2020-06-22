package cn.zbq.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] a = {13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11};
        int[] b = {1, 9, 8, 9};
        quickSort(a, 0, a.length - 1);
        print(a);
    }

    public static void quickSort(int[] arr, int left, int right) {
        // 递归调用出口
        if (left >= right) {
            return;
        }

        // 以pivot为支点，两边进行排序
        int pivot = randomPartition(arr, left, right);
        // 循环递归调用
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    /**
     * 从大到小
     */
    private static int partition(int[] arr, int left, int right) {
        // 假设数组最后一个元素为支点，获取其值
        int pivotValue = arr[right];
        // l一直向前移动，r标志当前起始位置（未进行元素交换的位置）
        int l = left, r = left;

        // l一直递增，小于总长度
        while (l <= right - 1) {
            // 判断l当前对应元素是否大于分界值
            if (arr[l] > pivotValue) {
                // 大于分界值，进行元素值的交换（大于分界值的元素会向前移动）
                exchange(arr, l, r);
                // r当前位置的元素已经是排序后的（大于分界值的），将r位置右移，为下一次元素交换做准备
                r++;
            }

            // l继续右移，判断下一个元素值
            l++;
        }
        // 所有元素判断完成，当前r位置是分界点，将r处值放到原来假设的pivot处（即数组末尾）
        arr[right] = arr[r];
        arr[r] = pivotValue;
        return r;
    }

    /**
     * 从小到大
     */
    private static int partitionSmallToBig(int[] arr, int left, int right) {
        // 假设数组最后一个元素为支点，获取其值
        int pivotValue = arr[right];
        // l一直向前移动，r标志当前起始位置（未进行元素交换的位置）
        int l = left, r = left;

        // l一直递增，小于总长度
        while (l <= right - 1) {
            // 判断l当前对应元素是否大于分界值
            if (arr[l] < pivotValue) {
                // 大于分界值，进行元素值的交换（大于分界值的元素会向前移动）
                exchange(arr, l, r);
                // r当前位置的元素已经是排序后的（大于分界值的），将r位置右移，为下一次元素交换做准备
                r++;
            }

            // l继续右移，判断下一个元素值
            l++;
        }
        // 所有元素判断完成，当前r位置是分界点，将r处值放到原来假设的pivot处（即数组末尾）
        arr[right] = arr[r];
        arr[r] = pivotValue;
        return r;
    }

    /**
     * 随机获取pivot点
     * <p/>
     * 在划分数组之前从left - right范围内随机获取一个点的值与数组最后一位进行交换
     * 目的：避免当数组已经有序时时间复杂度退化为O(n^2)
     * 最佳实践：从left-right范围内随机获取3个数，取中间值
     */
    private static int randomPartition(int[] arr, int left, int right) {
        // 获取left - right范围内的随机数
        int i = new Random().nextInt(right) % (right - left + 1) + left;
        exchange(arr, i, right);
        return partition(arr, left, right);
    }

    /**
     * 对数组指定索引对应的值进行交换
     */
    private static void exchange(int[] arr, int sourceIndex, int targetIndex) {
        int temp = arr[targetIndex];
        arr[targetIndex] = arr[sourceIndex];
        arr[sourceIndex] = temp;
    }


    private static void print(int[] arg) {
        System.out.println(Arrays.toString(arg));
    }
}
