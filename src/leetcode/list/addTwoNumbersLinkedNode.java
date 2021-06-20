package leetcode.list;

public class addTwoNumbersLinkedNode {

    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode l3 = new ListNode();
        int carry = 0, sum;
        while ( l1 != null && l2 != null ) {
            sum = (l1.val + l2.val + carry)%10;
            carry = (l1.val + l2.val + carry)/10;
            head.next = new ListNode(sum);
            if ( l3.next == null)
                l3 = head.next;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while ( l1 != null ) {
            sum = (l1.val + carry)%10;
            carry = (l1.val + carry)/10;
            head.next = new ListNode(sum);
            head = head.next;
            l1 = l1.next;
        }
        while ( l2 != null ) {
            sum = (l2.val + carry)%10;
            carry = (l2.val + carry)/10;
            head.next = new ListNode(sum);
            head = head.next;
            l2 = l2.next;
        }
        if ( carry != 0 ) {
            head.next = new ListNode(carry);
        }
        return l3;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        ListNode listNode3 = addTwoNumbers(listNode1,listNode2);
        System.out.print("[ ");
        while (listNode3 != null) {
            System.out.print(listNode3.val + " ");
            listNode3 = listNode3.next;
        }
        System.out.print("]");
    }
}
