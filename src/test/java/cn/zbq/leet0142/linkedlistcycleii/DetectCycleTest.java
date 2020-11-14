package cn.zbq.leet0142.linkedlistcycleii;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 142. 环形链表 II
 *
 * @author zbq
 * @date 2020/11/11
 */
public class DetectCycleTest {
    private final DetectCycle detectCycle = new DetectCycle();

    @Test
    public void case1() {
        DetectCycle.ListNode result = detectCycle.detectCycle(build(new int[]{3, 2, 0, -4}, 1));
        Assertions.assertEquals(2, result.val);
    }

    @Test
    public void case2() {
        DetectCycle.ListNode result = detectCycle.detectCycle(build(new int[]{1, 2}, 0));
        Assertions.assertEquals(1, result.val);
    }

    @Test
    public void case3() {
        DetectCycle.ListNode result = detectCycle.detectCycle(build(new int[]{1}, -1));
        Assertions.assertNull(result);
    }

    @Test
    public void case4() {
        DetectCycle.ListNode result = detectCycle.detectCycle(build(new int[]{1, 2}, -1));
        Assertions.assertNull(result);
    }

    private DetectCycle.ListNode build(int[] arr, int pos) {
        DetectCycle.ListNode listNode = new DetectCycle.ListNode(0);
        DetectCycle.ListNode temp = listNode;
        DetectCycle.ListNode cy = null;
        for (int i = 0; i < arr.length; i++) {
            temp.next = new DetectCycle.ListNode(arr[i]);
            temp = temp.next;
            if (i == pos) {
                cy = temp;
            }
        }
        temp.next = cy;

        return listNode.next;
    }
}