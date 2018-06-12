package offer1;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class test54 {
    public ListNode deleteDuplication(ListNode head) {

        ListNode h = head, pre = new ListNode(0);
        pre.next = h;
        ListNode post = null;

        while(h != null && (post = h.next) != null) {

            if(h.value != post.value) { // 如果不相等，pre、h、post就依次向后移动一位
                pre = h;
            }else { // 如果相等，
                while(post != null && h.value == post.value) { // post 不断向后移动
                    post = post.next;
                }
                if(pre.next == head) { // 如果是从头结点开始就一直重复
                    head = post; // 注意，如果从头结点就开始重复，需要修改head
                }
                pre.next = post;
            }
            h = post;
        }
        return head;
    }
}
