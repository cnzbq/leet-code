package cn.zbq.leet0069.sqrtx;

/**
 * 69. x 的平方根
 *
 * @author zbq
 * @date 2020/11/16
 */
public class MySqrt {

    public int mySqrt(int x) {
        // 判断是否为0
        if (x == 0) {
            return 0;
        }
        // 左边界，有边界，结果
        int l = 1, r = x, res = -1;

        // 左边界要小于等于右边界
        while (l <= r) {
            // 求中间值
            int mid = l + (r - l) / 2;
            if ((long) mid * mid > x) {
                r = mid - 1;
            } else {
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }
}
