package Lab05;

public class ListNode {
    public TreeNode data;
    public ListNode next;

    public ListNode(TreeNode data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(TreeNode data) {
        this(data, null);
    }
}