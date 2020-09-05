

//**************************************************************************
//反转一个单链表。
//**************************************************************************



public class reverseList {

    public static void main(String[] args){


        //reverseList(head);

    }

    //如何反转一个单链表
    static ListNode reverseList(ListNode head) {

        //用双指针
        ListNode pre = null;    //
        ListNode curr = head;   //表尾指向表头
        while(curr != null)
        {
            // 需要创建一个临时变量
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        //返回的最后一个节点
        return pre;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}
