package cn.zbq.leet0633.sumofsquarenumbers;

import cn.zbq.leet0167.twosumiiinputarrayissorted.TwoSum;

/**
 * 633. 平方数之和
 * 思路同{@link TwoSum#twoSum1(int[], int)}
 *
 * @author zbq
 * @date 2020/11/13
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        // right 和 left 就好比两个指针
        int right = 0, left = (int) Math.sqrt(c);

        while (left >= right) {
            int sum = right * right + left * left;
            // 如果结果大于c，左侧就向右侧移动
            if (sum > c) {
                left--;
            } else if (sum < c) {
                // 结果小于c，右侧向左侧移动
                right++;
            } else {
                // 找到结果
                return true;
            }
        }
        return false;
    }
}
