package cn.zbq._0002.add_two_numbers;

/**
 * 两数相加
 *
 * @author zbq
 * @date 2020/11/3
 */
public class AddTwoNumbers {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 新的结果列表
        ListNode l = new ListNode();
        // 定义一个指针，指向结果列表
        ListNode temp = l;
        // 标记是否需要进位
        boolean flag = false;
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
            if (flag) {
                flag = false;
                sum++;
            }
            if (sum > 9) {
                flag = true;
                sum = sum % 10;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
        }
        // 遍历完成后，继续判断当前进位标识的状态
        if (flag) {
            temp.next = new ListNode(1);
        }
        return l.next;
    }
}
