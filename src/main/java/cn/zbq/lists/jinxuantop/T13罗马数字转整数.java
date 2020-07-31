package cn.zbq.lists.jinxuantop;
//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
//
// 示例 1:
//
// 输入: "III"
//输出: 3
//
// 示例 2:
//
// 输入: "IV"
//输出: 4
//
// 示例 3:
//
// 输入: "IX"
//输出: 9
//
// 示例 4:
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
//
//
// 示例 5:
//
// 输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4.
// Related Topics 数学 字符串
// 👍 972 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @author zbq
 * @date 2020/7/31
 */
public class T13罗马数字转整数 {

    static class Solution {
        public static void main(String[] args) {

            Solution solution = new Solution();
            System.out.println(solution.romanToInt("MCMXCIV"));
            System.out.println(solution.romanToInt("LVIII"));
            System.out.println(solution.romanToInt("IX"));
            System.out.println(solution.romanToInt("IV"));
            System.out.println(solution.romanToInt("III"));
            System.out.println(solution.romanToInt("MMCCCXIXI"));//2322
            System.out.println(solution.romanToInt("IM"));
            System.out.println(solution.romanToInt2("IM"));
        }

        class Node {
            private final int value;
            private final int index;

            public Node(int index, int value) {
                this.index = index;
                this.value = value;
            }

            public int getValue() {
                return value;
            }

            public int getIndex() {
                return index;
            }
        }

        private final Map<Character, Node> map = new HashMap<>();
        private final Map<Character, Integer> map1 = new HashMap<>();

        {
            map.put('I', new Node(0, 1));
            map.put('V', new Node(1, 5));
            map.put('X', new Node(2, 10));
            map.put('L', new Node(3, 50));
            map.put('C', new Node(4, 100));
            map.put('D', new Node(5, 500));
            map.put('M', new Node(6, 1000));

            map1.put('I', 1);
            map1.put('V', 5);
            map1.put('X', 10);
            map1.put('L', 50);
            map1.put('C', 100);
            map1.put('D', 500);
            map1.put('M', 1000);
        }

        /**
         * 从map中获取对应字母代表的node，然后需要特别判断与前一个node的关系，
         * 前一个node的index大于当前的，可以直接相加，前一个小于当前，需要用当前的减去前一个后进行结果的累加
         *
         * @param s /
         * @return /
         */
        public int romanToInt(String s) {
            Node temp = null;
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                Node node = map.get(c);
                if (temp == null) {
                    temp = node;
                } else {
                    // 当前符号代表的值大于上一个符合代表的值
                    if (node.index - temp.index > 0) {
                        result += node.value - temp.value;
                        temp = null;
                    } else if (node.index - temp.index == 0) {
                        result += node.value + temp.value;
                        temp = null;
                    } else {
                        // 前一个符号所代表的值大于当前符号代表的值
                        result += temp.value;
                        temp = node;
                    }
                }
            }
            if (temp != null) {
                result += temp.value;
            }
            return result;
        }

        /**
         * 每个字符对应的值本身已经代表了字母的顺序（即值的大小）
         *
         * @param s /
         * @return /
         */
        public int romanToInt2(String s) {
            int sum = 0;
            int preNum = getValue(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                int num = getValue(s.charAt(i));
                // 前一个字母的值大于等于当前值，直接加
                if (preNum >= num) {
                    sum += preNum;
                } else {
                    // 前一个字母的值小于当前值，从总和中减去
                    sum -= preNum;
                }
                preNum = num;
            }
            return sum + preNum;
        }

        /**
         * 元素个数很有限，switch case 效率更高
         *
         * @param c /
         * @return /
         */
        public int getValue(char c) {
            switch (c) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return 0;
            }
        }

    }
}
