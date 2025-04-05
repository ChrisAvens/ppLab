# Codelab: Flattening a Linked List of Binary Trees

## Overview

You are given a linked list where every node holds the root of an integer binary tree. Your task is to implement the method `flatten` that returns a single binary tree built from all the integer values in the trees—with duplicates removed. The new tree must be constructed in level order, meaning that nodes are created by depth from left to right.

**Key Points:**
- **Extract Values:** Traverse each binary tree (using any traversal order) to collect integer values.
- **Remove Duplicates:** Only unique values should be included.
- **Build by Levels:** Insert nodes into the new tree in level order (breadth-first), so the first value becomes the root, the next two become its children, and so on.
- **Do Not Modify Original Trees:** The original trees must remain unchanged.
---
## Data Structures

### Linked List Node
```java
    class ListNode {
        public TreeNode data;
        public ListNode next;
        
        ListNode(TreeNode data, ListNode next) {
            this.data = data;
            this.next = next;
        }
        
        ListNode(TreeNode data) {
            this(data, null);
        }
    }
```
---
### Binary Tree Node
```java
    class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int value;
        
        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        
        TreeNode(int value) {
            this(value, null, null);
        }
    }
```
---
## Problem Statement

Implement the method `flatten` in the `Solution` class:
```java
    public class Solution {
        public static TreeNode flatten(ListNode head) {
            // Your implementation here.
            return null;
        }
    }
```
The method should:
1. Traverse the linked list.
2. Extract all integer values from each binary tree.
3. Eliminate duplicates.
4. Build a new binary tree using level order insertion from the unique values.
---
## Exercise 01 (package)
Should contain a `Solution` class written with convetional Java data structures.
## Exercise 02 (package)
Contains a `Solution` class working with IntStream.
```java
 public static TreeNode flatten(ListNode head) {
        return arrayToTree(elements(head).distinct().sorted().toArray(), 0);
    }
```
---
## Exercise 03(optional)
In the class `TreeNode` implement a method:
```java
public static void printTree(TreeNode root) {
    //TODO: implement
}   

```
that prints a tree as follows,
```
   1   
 /    \ 
 2    3 
/  \  /  
4  5  6  
```
or uses the Parentheses notation.
## Notation for Representing Structures

- **Binary Trees:** Parentheses notation.
    - Example: a tree with root `2`, left child `1`, and right child `3` is `2 (1,3)`.
    - If a child is missing, you can represent it with an empty space: `1 (,2)` indicates a tree with root `1` and only a right child `2`.

- **Linked Lists:** Use bracket notation.
    - Example: a linked list containing three trees is `[Tree1, Tree2, Tree3]`.
---
## Extended Test Cases

Below there are several test cases.
```java
package Lab05;
import Lab05.Ex02.Solution;
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

        // Method to test the flatten function
        public static void testFlatten(ListNode input, TreeNode expected) {
            TreeNode result = Solution.flatten(input);
            TreeNode.printTree(result);
            //System.out.println("Test passed.");
            System.out.println("Resulting Tree:");
            TreeNode.printTree(result);
            System.out.println("Expected Tree:");
            TreeNode.printTree(expected);
            assertTrue("The flattened tree does not match the expected tree.", isSameTree(result, expected));

        }
}

public class SolutionTest {
    // Helpers.testFlatten(input_list_head, expected_tree_root)

    @Test
    public void nullList() {
        Helpers.testFlatten(null, null);
    }

    @Test
    public void exampleList() {
        TreeNode t1 = new TreeNode(1, null, new TreeNode(2));
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, new TreeNode(4), new TreeNode(2));
        TreeNode t4 = new TreeNode(6, null, new TreeNode(5));

        ListNode head = new ListNode(t1, new ListNode(t2, new ListNode(t3, new ListNode(t4))));
        TreeNode expected = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        Helpers.testFlatten(head, expected);
    }
    @Test
    public void secondExample() {
        ListNode head = new ListNode(new TreeNode(91,
    new TreeNode(28,
        new TreeNode(11,
        new TreeNode(-8,
           new TreeNode(-9, null, null),
           new TreeNode(-4, null, null)
         ),
        // right child of 11 holds 14 with a duplicate as its left child
        new TreeNode(14, new TreeNode(14, null, null), null)
      ),
       new TreeNode(32,
        new TreeNode(8, null, new TreeNode(-5, null, null)),
        new TreeNode(16, null, null)
      )
     ),
    new TreeNode(84,
       new TreeNode(41,
        new TreeNode(30, new TreeNode(86, null, null), null),
        new TreeNode(43,
          new TreeNode(27, new TreeNode(7, null, null), new TreeNode(26, null, null)),
          null
         )
      ),
       new TreeNode(96,
        new TreeNode(90,
          new TreeNode(87, null, null),
           new TreeNode(93, null, null)
         ),
        new TreeNode(99,
          new TreeNode(56,
             new TreeNode(55, new TreeNode(35, null, null), new TreeNode(52, null, null)),
            new TreeNode(57, new TreeNode(22, null, null), new TreeNode(60, null, null))
          ),
           new TreeNode(3,
             new TreeNode(-2, null, null),
             new TreeNode(19,
               new TreeNode(61, new TreeNode(70, null, null), null),
               new TreeNode(66, new TreeNode(73, null, null), new TreeNode(79, null, null))
             )
            )
           )
          )
      )
     )
);
        TreeNode expected =
                new TreeNode(-9,
                        // Left subtree of -9
                        new TreeNode(-8,
                                // Left subtree of -8
                                new TreeNode(-4,
                                        // Left subtree of -4
                                        new TreeNode(8,
                                                // Left subtree of 8
                                                new TreeNode(28,
                                                        // Left subtree of 28
                                                        new TreeNode(84, null, null),
                                                        // Right subtree of 28
                                                        new TreeNode(86, null, null)
                                                ),
                                                // Right subtree of 8
                                                new TreeNode(30,
                                                        // Left subtree of 30
                                                        new TreeNode(87, null, null),
                                                        // Right subtree of 30
                                                        new TreeNode(90, null, null)
                                                )
                                        ),
                                        // Right subtree of -4
                                        new TreeNode(11,
                                                // Left subtree of 11
                                                new TreeNode(32,
                                                        // Left subtree of 32
                                                        new TreeNode(91, null, null),
                                                        // Right subtree of 32
                                                        new TreeNode(93, null, null)
                                                ),
                                                // Right subtree of 11
                                                new TreeNode(35,
                                                        // Left subtree of 35
                                                        new TreeNode(96, null, null),
                                                        // Right subtree of 35
                                                        new TreeNode(99, null, null)
                                                )
                                        )
                                ),
                                // Right subtree of -8
                                new TreeNode(-2,
                                        // Left subtree of -2
                                        new TreeNode(14,
                                                // Left subtree of 14
                                                new TreeNode(41, null, null),
                                                // Right subtree of 14
                                                new TreeNode(43, null, null)
                                        ),
                                        // Right subtree of -2
                                        new TreeNode(16,
                                                // Left subtree of 16
                                                new TreeNode(52, null, null),
                                                // Right subtree of 16
                                                new TreeNode(55, null, null)
                                        )
                                )
                        ),
                        // Right subtree of -9
                        new TreeNode(-5,
                                // Left subtree of -5
                                new TreeNode(3,
                                        // Left subtree of 3
                                        new TreeNode(19,
                                                // Left subtree of 19
                                                new TreeNode(56, null, null),
                                                // Right subtree of 19
                                                new TreeNode(57, null, null)
                                        ),
                                        // Right subtree of 3
                                        new TreeNode(22,
                                                // Left subtree of 22
                                                new TreeNode(60, null, null),
                                                // Right subtree of 22
                                                new TreeNode(61, null, null)
                                        )
                                ),
                                // Right subtree of -5
                                new TreeNode(7,
                                        // Left subtree of 7
                                        new TreeNode(26,
                                                // Left subtree of 26
                                                new TreeNode(66, null, null),
                                                // Right subtree of 26
                                                new TreeNode(70, null, null)
                                        ),
                                        // Right subtree of 7
                                        new TreeNode(27,
                                                // Left subtree of 27
                                                new TreeNode(73, null, null),
                                                // Right subtree of 27
                                                new TreeNode(79, null, null)
                                        )
                                )
                        )
                );
        Helpers.testFlatten(head, expected);
    }
    @Test
    public void singleTree() {
        TreeNode t1 = new TreeNode(7, new TreeNode(3), new TreeNode(9));
        //TreeNode.printTree(t1);
        ListNode head = new ListNode(t1);
        //TreeNode.printTree(t1);
        TreeNode expected = new TreeNode(3,new TreeNode(7),new TreeNode(9));
        Helpers.testFlatten(head, expected);
        //TreeNode.printTree(expected);
    }
    @Test
    public void overlappingValues() {
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

```


## Hints

- **Duplicates:** Use a `Set` (like `HashSet`) to automatically remove duplicate values. For an IntStream we can use .distinct().sorted() methods.
- **Edge Cases:** Be sure to handle cases where the linked list is `null` or contains `null` trees.

## Conclusion

Your goal is to implement the `flatten` method so that:
- It extracts all unique integer values from a linked list of binary trees.
- It constructs a new binary tree using level order insertion of the sorted (without duplicates) of the nodes of all trees in the given list.

Use the provided test cases to verify your solution. Enjoy coding and good luck!