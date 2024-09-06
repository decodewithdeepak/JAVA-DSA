// 1. Count Complete Tree Nodes - LeetCode #222 (https://leetcode.com/problems/count-complete-tree-nodes/)
// 2. Maximum Depth of Binary Tree - LeetCode #104 (https://leetcode.com/problems/maximum-depth-of-binary-tree/)
// 3. Balanced Binary Tree - LeetCode #110 (https://leetcode.com/problems/balanced-binary-tree/)
// 4. Invert Binary Tree - LeetCode #226 (https://leetcode.com/problems/invert-binary-tree/)
// 5. Same Tree - LeetCode #100 (https://leetcode.com/problems/same-tree/)
// 6. Symmetric Tree - LeetCode #101 (https://leetcode.com/problems/symmetric-tree/)
// 7. Sum of Left Leaves - LeetCode #404 (https://leetcode.com/problems/sum-of-left-leaves/)
// 8. Binary Tree Paths - LeetCode #257 (https://leetcode.com/problems/binary-tree-paths/)
// 9. Diameter of Binary Tree - LeetCode #543 (https://leetcode.com/problems/diameter-of-binary-tree/)
// 10. Lowest Common Ancestor of a Binary Tree - LeetCode #236 (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

import java.util.*;

public class e_BinaryTreeProblems {

    // Node class
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    // 1. Count Complete Tree Nodes - LeetCode #222
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left + right + 1;
    }

    // 2. Maximum Depth of Binary Tree - LeetCode #104
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    // 3. Balanced Binary Tree - LeetCode #110
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int lh = height(root.left);
        int rh = height(root.right);
        int d = Math.abs(lh - rh);

        if (d > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // 4. Invert Binary Tree - LeetCode #226
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    // 5. Same Tree - LeetCode #100
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false; // vvimp
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 6. Symmetric Tree - LeetCode #101
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        root.left  = invertTree(root.left);
        return isSameTree(root.left, root.right);
    }

    // 7. Sum of Left Leaves - LeetCode #404
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    // 8. Binary Tree Paths - LeetCode #257
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        binaryTreePaths(root, "", result);
        return result;
    }

    private static void binaryTreePaths(TreeNode root, String path, List<String> result) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            result.add(path + root.val);
            return;
        }

        binaryTreePaths(root.left, path + "->", result);
        binaryTreePaths(root.right, path + "->", result);
    }

    // 9. Diameter of Binary Tree - LeetCode #543
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(height(root.left) + height(root.right) + 2, Math.max(leftDiameter, rightDiameter));
    }

    // 10. Lowest Common Ancestor of a Binary Tree - LeetCode #236
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }



}
