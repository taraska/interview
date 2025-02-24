package us.ivannikov.algo.graph.binaryTreeIsBalanced;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*
Top-Down Approach:

Checks balance at each node by comparing heights of left and right subtrees

Recursively checks if both subtrees are balanced

Simple but inefficient due to repeated height calculations

Bottom-Up Approach:

Combines height calculation with balance checking

Uses -1 as a sentinel value to indicate imbalance

More efficient as it avoids recalculating heights
* */
public class BalancedBinaryTree {

    //O(n)
    public boolean isBalancedBottomUpApproach(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Check left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is unbalanced
        }

        // Check right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is unbalanced
        }

        // Check current node's balance
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is unbalanced
        }

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    //O(n^2)
    // Main method to check if tree is balanced
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        // Check height difference at current node
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // Recursively check left and right subtrees
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // Helper method to calculate tree height
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        /*
        O(n²) in worst case (unbalanced tree) because for each node, we calculate its height which requires traversing its subtree
        * */
        BalancedBinaryTree checker = new BalancedBinaryTree();
        System.out.println("Is balanced: " + checker.isBalanced(root)); // true

        boolean balancedBottomUpApproachYes = checker.isBalancedBottomUpApproach(root);
        System.out.println("is balanced: " + balancedBottomUpApproachYes); // true

        // Make it unbalanced
        root.left.left.left = new TreeNode(6);
        System.out.println("Is balanced: " + checker.isBalanced(root)); // false

        boolean balancedBottomUpApproach = checker.isBalancedBottomUpApproach(root);
        System.out.println("is balanced: " + balancedBottomUpApproach); // false

    }
}