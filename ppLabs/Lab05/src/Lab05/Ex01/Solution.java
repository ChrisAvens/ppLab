package Lab05.Ex01;

import Lab05.ListNode;
import Lab05.TreeNode;
import java.util.*;

public class Solution {
    public static TreeNode flatten(ListNode head) {
        if (head == null) {
            return null;
        }

        // Extract all values from the trees in the linked list
        Set<Integer> uniqueValues = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if (current.data != null) {
                // Collect values from current tree
                collectValues(current.data, uniqueValues);
            }
            current = current.next;
        }

        // Convert set to sorted list
        List<Integer> sortedValues = new ArrayList<>(uniqueValues);
        Collections.sort(sortedValues);

        // Now build the tree in level order
        if (sortedValues.isEmpty()) {
            return null;
        }

        return buildTreeLevelOrder(sortedValues);
    }

    // DFS to collect all values from a tree
    private static void collectValues(TreeNode root, Set<Integer> values) {
        if (root == null) {
            return;
        }

        // Add current node's value
        values.add(root.value);

        // Recursively process left and right subtrees
        collectValues(root.left, values);
        collectValues(root.right, values);
    }

    // Build a new tree using level order traversal
    private static TreeNode buildTreeLevelOrder(List<Integer> values) {
        if (values.isEmpty()) {
            return null;
        }

        // Create the root node with the first value
        TreeNode root = new TreeNode(values.get(0));

        // Use a queue for level order insertion
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // Start from the second value

        while (i < values.size() && !queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Add left child
            if (i < values.size()) {
                current.left = new TreeNode(values.get(i++));
                queue.add(current.left);
            }

            // Add right child
            if (i < values.size()) {
                current.right = new TreeNode(values.get(i++));
                queue.add(current.right);
            }
        }

        return root;
    }
}