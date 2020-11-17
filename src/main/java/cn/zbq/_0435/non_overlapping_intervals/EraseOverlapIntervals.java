package cn.zbq._0435.non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 *
 * @author zbq
 * @date 2020/11/8
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 移除掉的区间个数
        int count = 0;
        // 上一个区间的指针（索引值）
        int preIndex = 0;
        // 按照区间尾进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        for (int i = 1; i < intervals.length; i++) {
            // 情况1：区间之间不存在任何交集
            if (intervals[i][0] >= intervals[preIndex][1]) {
                // 指针向后移动即可
                preIndex = i;
            }
            // 情况2：上一个区间是当前区间的真子集
//            else if (intervals[i][0] > intervals[preIndex][0]) {
//                // 移除当前区间
//                count++;
//            }
            // 情况3：当前区间尾在前一个区间尾之后
            else {
                count++;
            }
        }

        return count;
    }
}
