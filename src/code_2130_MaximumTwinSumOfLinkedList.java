
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;
        ListNode temp =fast.next;
        fast.next = null;

        slow = fast;
        fast = temp;
        temp = temp.next;


        while(fast!= null){
            fast.next = slow;

            slow = fast;
            fast = temp;
            if (temp == null){
                continue;
            }else {
                temp = temp.next;
            }

        }

        fast =slow;
        int max=0;
        slow = head;

        while(slow!=null){
            max = max >= (slow.val + fast.val) ? max : (slow.val + fast.val);
            slow = slow.next;
            fast = fast.next;

        }
        return max;
    }
}

public class code_2130_MaximumTwinSumOfLinkedList {
    public static void main(String[] args) {
        ListNode node0;
        ListNode node1;
        ListNode node2;
        ListNode node3;
        ListNode node4;
        ListNode node5;
        node5 = new ListNode(5,null);
        node4 = new ListNode(4,node5);
        node3 = new ListNode(3,node4);
        node2 = new ListNode(2,node3);
        node1 = new ListNode(1,node2);
        node0 = new ListNode(0,node1);

        ListNode cur = node0;

        ListNode listNode = new ListNode();
        int max = listNode.pairSum(cur);

        System.out.println(max);



    }


}