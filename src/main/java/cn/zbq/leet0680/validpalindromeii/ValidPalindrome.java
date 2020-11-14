package cn.zbq.leet0680.validpalindromeii;

/**
 * 680. 验证回文字符串 Ⅱ
 *
 * @author zbq
 * @date 2020/11/14
 */
public class ValidPalindrome {
public boolean validPalindrome(String s) {
    char[] arr = s.toCharArray();
    int i = 0, j = arr.length - 1;
    return check(arr, i, j, false);
}

/**
 * @param arr  字符数组
 * @param i    起始位置
 * @param j    结束位置
 * @param flag 是否已经删除过一个元素的标志，true 删除过，false 未删除过
 * @return true or false
 */
private boolean check(char[] arr, int i, int j, boolean flag) {
    while (i <= j) {
        // 判断是否相等，相等继续遍历
        if (arr[i] == arr[j]) {
            i++;
            j--;
        } else if (i + 1 == j && !flag) {
            // 如果i+1之后等于j且未删除过元素，说明只要删除一个即可相等，eg：abca
            return true;
        } else if ((arr[i + 1] == arr[j] || arr[i] == arr[j - 1]) && !flag) {
            // 在当前没有删除元素的前提下，左侧删除一个或者右侧删除一个后字符串两边再次相等，继续遍历
            // 当左右都可以删除时没有可靠策略删除哪边是正确的，所以进行尝试
            return check(arr, ++i, j, true) || check(arr, --i, --j, true);
        } else {
            return false;
        }
    }

    return true;
}
}
