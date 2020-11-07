package cn.zbq.leet0135.candy;

import java.util.Arrays;

/**
 * 135. 分发糖果
 *
 * @author zbq
 * @date 2020/11/7
 */
public class Candy {

    public int candy(int[] ratings) {
        int length = ratings.length;
        // 孩子拥有的糖果数组
        int[] arr = new int[length];
        // 默认每个人先发一颗糖果，但是为了减少一次数组的遍历，最后直接加数组的长度即可
        //Arrays.fill(arr, 1);
        int sum = 0;
        // 从左向右遍历
        for (int i = 1; i < length; i++) {
            // 当右边孩子评分高于左边孩子时，右边孩子糖果数=左边孩子糖果数+1
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        // 从右向左遍历
        for (int i = ratings.length - 1; i > 0; i--) {
            // 当右边孩子评分低于左边孩子 && 右边孩子糖果数大于等于左边孩子糖果数时，左边孩子糖果数=右边孩子糖果数+1
            if (ratings[i] < ratings[i - 1] && arr[i] >= arr[i - 1]) {
                arr[i - 1] = arr[i] + 1;
            }
            // 这里已经是最后一轮修改糖果数，已经修改过的可以直接累加，减少最后求和再次遍历糖果数组
            sum += arr[i];
        }

        // 因为最后累加时，arr[0]是累加不到的，这里需要加上
        // length 初始化时按每人1颗糖果计算，但未进行实际赋值，这里需要进行补偿
        return sum + arr[0] + length;
    }


    public int count(int n) {
        return (n * (n + 1)) / 2;
    }

    public int candy4(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int old_slope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int new_slope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
            if ((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (new_slope > 0)
                up++;
            if (new_slope < 0)
                down++;
            if (new_slope == 0)
                candies++;

            old_slope = new_slope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }
}
