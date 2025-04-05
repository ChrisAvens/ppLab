package Lab05;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int value;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value) {
        this(value, null, null);
    }
}