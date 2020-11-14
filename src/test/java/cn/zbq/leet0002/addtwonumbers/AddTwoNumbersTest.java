package cn.zbq.leet0002.addtwonumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 两数相加测试
 *
 * @author zbq
 * @date 2020/11/3
 */
public class AddTwoNumbersTest {
    private AddTwoNumbers addTwoNumbers;

    @BeforeAll
    public void before() {
        addTwoNumbers = new AddTwoNumbers();
    }

    @Test
    public void case1() {
        AddTwoNumbers.ListNode listNode1 = build(new int[]{});
        AddTwoNumbers.ListNode listNode2 = build(new int[]{});
        AddTwoNumbers.ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        Assertions.assertArrayEquals(new int[]{}, toArr(listNode));
    }

    @Test
    public void case2() {
        AddTwoNumbers.ListNode listNode1 = build(new int[]{1});
        AddTwoNumbers.ListNode listNode2 = build(new int[]{1});
        AddTwoNumbers.ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        Assertions.assertArrayEquals(new int[]{2}, toArr(listNode));
    }

    @Test
    public void case3() {
        AddTwoNumbers.ListNode listNode1 = build(new int[]{1, 2, 3, 4});
        AddTwoNumbers.ListNode listNode2 = build(new int[]{1, 2, 3, 4});
        AddTwoNumbers.ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        Assertions.assertArrayEquals(new int[]{2, 4, 6, 8}, toArr(listNode));
    }

    @Test
    public void case4() {
        AddTwoNumbers.ListNode listNode1 = build(new int[]{1, 2, 3, 4, 5});
        AddTwoNumbers.ListNode listNode2 = build(new int[]{1, 2, 3, 4, 5});
        AddTwoNumbers.ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        Assertions.assertArrayEquals(new int[]{2, 4, 6, 8, 0, 1}, toArr(listNode));
    }

    @Test
    public void case5() {
        AddTwoNumbers.ListNode listNode1 = build(new int[]{1});
        AddTwoNumbers.ListNode listNode2 = build(new int[]{9, 9, 9, 9, 9});
        AddTwoNumbers.ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 1}, toArr(listNode));
    }

    @Test
    public void case6() {
        AddTwoNumbers.ListNode listNode1 = build(new int[]{9, 9, 9, 9, 9});
        AddTwoNumbers.ListNode listNode2 = build(new int[]{1});
        AddTwoNumbers.ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 1}, toArr(listNode));
    }

    @Test
    public void case7() {
        AddTwoNumbers.ListNode listNode1 = build(new int[]{2, 4, 3});
        AddTwoNumbers.ListNode listNode2 = build(new int[]{5, 6, 4});
        AddTwoNumbers.ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        Assertions.assertArrayEquals(new int[]{7, 0, 8}, toArr(listNode));
    }

    @Test
    public void case8() {
        AddTwoNumbers.ListNode listNode1 = build(new int[]{1, 8, 3});
        AddTwoNumbers.ListNode listNode2 = build(new int[]{7, 1});
        AddTwoNumbers.ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        Assertions.assertArrayEquals(new int[]{8, 9, 3}, toArr(listNode));
    }

    private AddTwoNumbers.ListNode build(int[] arr) {
        AddTwoNumbers.ListNode listNode = new AddTwoNumbers.ListNode();
        AddTwoNumbers.ListNode temp = listNode;
        for (int i : arr) {
            temp.next = new AddTwoNumbers.ListNode(i);
            temp = temp.next;
        }

        return listNode.next;
    }

    private int[] toArr(AddTwoNumbers.ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}