package Lab05;

import Lab05.Ex01.Solution;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

class Helpers{
    // Method to compare two binary trees
    public static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.value != b.value) return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    // Method to test the flatten function - using the lab's original code
    public static void testFlatten(ListNode input, TreeNode expected) {
        TreeNode result = Solution.flatten(input);
        System.out.println("Test executed.");

        // Print tree structure as string representation for better visualization
        System.out.println("Resulting Tree Structure: " + treeToString(result));
        System.out.println("Expected Tree Structure: " + treeToString(expected));

        assertTrue("The flattened tree does not match the expected tree.", isSameTree(result, expected));
    }

    // Helper method to convert tree to string representation
    private static String treeToString(TreeNode node) {
        if (node == null) return "null";
        return node.value + " (" + treeToString(node.left) + ", " + treeToString(node.right) + ")";
    }
}

public class SolutionTest {
    // Following the lab's test cases exactly

    @Test
    public void nullList() {
        System.out.println("\n--- Testing Null List ---");
        Helpers.testFlatten(null, null);
    }

    @Test
    public void exampleList() {
        System.out.println("\n--- Testing Example List ---");
        TreeNode t1 = new TreeNode(1, null, new TreeNode(2));
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, new TreeNode(4), new TreeNode(2));
        TreeNode t4 = new TreeNode(6, null, new TreeNode(5));

        ListNode head = new ListNode(t1, new ListNode(t2, new ListNode(t3, new ListNode(t4))));
        TreeNode expected = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        Helpers.testFlatten(head, expected);
    }

    @Test
    public void singleTree() {
        System.out.println("\n--- Testing Single Tree ---");
        TreeNode t1 = new TreeNode(7, new TreeNode(3), new TreeNode(9));
        ListNode head = new ListNode(t1);
        TreeNode expected = new TreeNode(3, new TreeNode(7), new TreeNode(9));
        Helpers.testFlatten(head, expected);
    }

    @Test
    public void overlappingValues() {
        System.out.println("\n--- Testing Overlapping Values ---");
        TreeNode t1 = new TreeNode(10, new TreeNode(5), new TreeNode(15));
        TreeNode t2 = new TreeNode(20, new TreeNode(10), null);
        TreeNode t3 = new TreeNode(25, null, new TreeNode(5));

        ListNode head = new ListNode(t1, new ListNode(t2, new ListNode(t3)));
        // Expected unique sorted values: [5, 10, 15, 20, 25]
        TreeNode expected = new TreeNode(5,
                new TreeNode(10,
                        new TreeNode(20),
                        new TreeNode(25)),
                new TreeNode(15));
        Helpers.testFlatten(head, expected);
    }
}