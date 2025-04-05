package Lab05.Ex02;

import Lab05.ListNode;
import Lab05.TreeNode;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public static TreeNode flatten(ListNode head) {
        return arrayToTree(elements(head).distinct().sorted().toArray(), 0);
    }

    // Helper method to extract all values from trees in the linked list and convert to IntStream
    private static IntStream elements(ListNode head) {
        if (head == null) {
            return IntStream.empty();
        }

        // Create a stream builder to collect all values
        IntStream.Builder builder = IntStream.builder();

        // Traverse the linked list
        ListNode current = head;
        while (current != null) {
            if (current.data != null) {
                // Add all values from current tree to the stream
                addTreeValuesToStream(current.data, builder);
            }
            current = current.next;
        }

        return builder.build();
    }

    // DFS to add all values from a tree to the stream builder
    private static void addTreeValuesToStream(TreeNode node, IntStream.Builder builder) {
        if (node == null) {
            return;
        }

        // Add current node's value
        builder.add(node.value);

        // Recursively process left and right subtrees
        addTreeValuesToStream(node.left, builder);
        addTreeValuesToStream(node.right, builder);
    }

    // Build tree from sorted array using level order approach (recursive)
    private static TreeNode arrayToTree(int[] values, int index) {
        if (values.length == 0 || index >= values.length) {
            return null;
        }

        // Create current node
        TreeNode node = new TreeNode(values[index]);

        // Calculate indices for children in level order
        int leftIdx = 2 * index + 1;
        int rightIdx = 2 * index + 2;

        // Recursively build left and right subtrees
        if (leftIdx < values.length) {
            node.left = arrayToTree(values, leftIdx);
        }

        if (rightIdx < values.length) {
            node.right = arrayToTree(values, rightIdx);
        }

        return node;
    }
}