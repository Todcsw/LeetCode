package two_pointers.easy.A0141linked_list_cycle;

import java.util.HashSet;

/**
 * @Auther: 行路
 * @Email: 1759864302@qq.com
 * @Date: Created on 2021/3/29 20:02 星期一
 * @Description: 141.环形链表
 * @version: 1.0
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public static void main(String[] args) {

        ListNode head=new ListNode(3);
        ListNode head1=new ListNode(2);
        ListNode head2=new ListNode(0);
        ListNode head3=new ListNode(-4);
        head.next=head1;
        head1.next=head2;
        head2.next=head3;
        head3.next=head2;

        boolean b = hasCycle(head);
        System.out.println(b);




    }

    /**
     * 解法一,一次遍历
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> set=new HashSet<ListNode>();
        while(head!=null){
            if(!set.add(head)){
                return true;
            }
            head=head.next;
        }
        return false;
    }


    public static boolean hasCycle1(ListNode head) {
        int n = 0;
        while(head!=null)
        {
            head = head.next;
            n++;
            if(n > 10000)
                return true;
        }
        return false;
    }


    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}


