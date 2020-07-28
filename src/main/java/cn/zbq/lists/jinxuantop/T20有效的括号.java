//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串
// 👍 1725 👎 0

package cn.zbq.lists.jinxuantop;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zbq
 * @date 2020/7/28
 */
public class T20有效的括号 {
    //  '('，')'，'{'，'}'，'['，']'

    static class Solution {
//        private static final Map<Character, Object> map = new HashMap<>(16);
//
//        static {
//            map.put('(', null);
//            map.put('{', null);
//            map.put('[', null);
//        }

        public static void main(String[] args) {
            String str1 = "()";
            String str2 = "()[]{}";
            String str3 = "(]";
            String str4 = "([)]";
            String str5 = "{[]}";

            Solution solution = new Solution();
            System.out.println(solution.isValid(str1));
            System.out.println(solution.isValid(str2));
            System.out.println(solution.isValid(str3));
            System.out.println(solution.isValid(str4));
            System.out.println(solution.isValid(str5));
        }

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();

            int len = s.length();
            // 如果不是偶数，直接返回false
            if ((len & 1) != 0) {
                return false;
            }
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (isLeft(c)) {
                    stack.push(c);
                } else if (stack.isEmpty() || getLeft(c) != stack.pop()) {
                    return false;
                }
            }
            return stack.isEmpty();
        }

        /**
         * 判断是否为左括号
         *
         * @param c /
         * @return /
         */
        public boolean isLeft(char c) {
            return c == '(' || c == '{' || c == '[';
            // 最早想到通过map方式快速查找，鉴于本题给定字符有限，直接判断亦可
            //  return map.containsKey(c);
        }

        /**
         * 获取右括号对应的左括号
         * <p/>
         * 官方解答中给了一个很好的思路，可以将判断和获取通过一个map解决，但是在判断是否包含某个值的时候使用for循环遍历，效率较差
         *
         * @param c /
         * @return /
         */
        public char getLeft(char c) {
            switch (c) {
                case ')':
                    return '(';
                case '}':
                    return '{';
                case ']':
                    return '[';
                default:
                    return ' ';
            }
        }
    }
}
