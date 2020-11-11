package cn.zbq.leet0142.linkedlistcycleii;

/**
 * 142. 环形链表 II
 *
 * @author zbq
 * @date 2020/11/11
 */
public class DetectCycle {
    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode detectCycle(ListNode head) {
        // 快慢指针赋初值
        ListNode slow = head, fast = head;
        // 判空，并完成一次快指针的前进
        while (fast != null && (fast = fast.next) != null) {
            // 快指针再前进一步，同时慢指针也前进一步
            fast = fast.next;
            slow = slow.next;

            // 判断快慢指针是否到达同一位置
            if (fast == slow) {
                // 将快指针重新指向列表头
                fast = head;
                // 再次遍历查找快慢指针相同的位置
                for (; slow != fast; slow = slow.next, fast = fast.next) {
                }
                // 找到位置，返回（此时即为入环第一个节点）
                return slow;
            }
        }

        return null;
    }

}
