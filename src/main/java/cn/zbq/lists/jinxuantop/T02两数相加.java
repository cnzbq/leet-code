package cn.zbq.lists.jinxuantop;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学

/**
 * 两数相加
 */
public class T02两数相加 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode constructorNode(int... a) {
        ListNode listNode = null;
        ListNode nearNode = null;
        for (int i : a) {
            if (nearNode == null) {
                nearNode = new ListNode(i);
                listNode = nearNode;
            } else {
                nearNode.next = new ListNode(i);
                nearNode = nearNode.next;
            }
        }
        return listNode;
    }

    private static String nodeToString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }

    /**
     * 通过一个变量标志是否进位
     * 每次计算判断是否需要进位
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;
        ListNode listNode = new ListNode(0);
        ListNode nearNode = listNode;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // 上一级进位处理
            if (flag) {
                sum++;
            }

            // 本级进位处理
            flag = sum > 9;
            int result = sum % 10;
            nearNode.next = new ListNode(result);
            nearNode = nearNode.next;
        }

        if (flag) {
            nearNode.next = new ListNode(1);
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        final ListNode listNode1 = constructorNode(9, 4);
        final ListNode listNode2 = constructorNode(1);
        final ListNode node = addTwoNumbers(listNode1, listNode2);
        System.out.println(nodeToString(node));
    }
}
