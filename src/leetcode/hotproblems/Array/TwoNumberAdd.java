package leetcode.hotproblems.Array;


class ListNode {
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

public class TwoNumberAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        // 进位标记
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = (x + y + carry) % 10;
            carry = sum / 10;


        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNodeOne = new ListNode();
        listNodeOne.val = 2;
        listNodeOne.next.val = 4;
        listNodeOne.next.next.val = 3;
        ListNode listNodeTwo = new ListNode();
        listNodeTwo.val = 5;
        listNodeTwo.next.val = 6;
        listNodeTwo.next.next.val = 4;
    }
}
