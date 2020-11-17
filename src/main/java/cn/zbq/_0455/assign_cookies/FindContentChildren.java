package cn.zbq._0455.assign_cookies;

import java.util.Arrays;

/**
 * 455. 分发饼干
 *
 * @author zbq
 * @date 2020/11/7
 */
public class FindContentChildren {
    /**
     * @param g 胃口值
     * @param s 尺寸
     * @return /
     */
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int i = 0, j = 0;
        int l1 = g.length;
        int l2 = s.length;
        // 对孩子胃口值进行排序
        Arrays.sort(g);
        // 对饼干尺寸进行排序
        Arrays.sort(s);

        while (i < l1) {
            // 寻找符合当前孩子胃口值的饼干
            while (j < l2 && s[j] < g[i]) {
                j++;
            }
            if (j < l2) {
                count++;
                j++;
            } else {
                break;
            }
            i++;
        }

        return count;
    }

    /**
     * 进一步优化
     *
     * @param g 胃口值
     * @param s 尺寸
     * @return /
     */
    public int findContentChildren2(int[] g, int[] s) {
        int i = 0, j = 0;
        int l1 = g.length;
        int l2 = s.length;
        // 对孩子胃口值进行排序
        Arrays.sort(g);
        // 对饼干尺寸进行排序
        Arrays.sort(s);

        // 饼干或者孩子都要小于给定的值
        while (i < l1 && j < l2) {
            // 判断当前的饼干大小是否符合当前孩子的胃口值
            if (s[j] >= g[i]) {
                // 符合，孩子数+1
                i++;
            }
            // 饼干数+1 不需要考虑是否符合（符合的话，当前饼干已分配，需要+1；不符合的话也需要+1判断下一块是否符合）
            j++;
        }

        return i;
    }
}
