/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head==null) return null;
        
        
        int  cnt=1;
        
        ListNode gg= null;
        
        
        ListNode tmp = head;
        while(cnt<left){
            gg=  tmp;
            tmp = tmp.next;
            cnt++;
        }
        
        ListNode kk = tmp;
        ListNode prev = null;
        ListNode cur = tmp;
        ListNode next = null;
        
        
        while(cnt<=right){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            cnt++;
        }
        
         if(gg!=null){
            gg.next= prev;
        }
        else head=prev;
        
        kk.next= cur;
        return head;
        
        
    }
}
