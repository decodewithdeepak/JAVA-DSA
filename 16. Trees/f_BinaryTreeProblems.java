// 1. Construct Binary Tree from Preorder and Inorder Traversal - LeetCode #105 (https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
// 2. Construct Binary Tree from Inorder and Postorder Traversal - LeetCode #106 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
// 3. Construct Binary Tree from Preorder and Postorder Traversal - LeetCode #889 (https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/)
// 4. Construct Complete Binary Tree from Level Order Traversal - GFG (https://www.geeksforgeeks.org/construct-complete-binary-tree-given-array/)

// 5. Flatten Binary Tree to Linked List - LeetCode #114 (https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
// 6. Amount of Time for Binary Tree to Be Infected - LeetCode #2385 (https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/)

// 7. Path Sum - LeetCode #112 (https://leetcode.com/problems/path-sum/)
// 8. Path Sum II - LeetCode #113 (https://leetcode.com/problems/path-sum-ii/)
// 9. Path Sum III - LeetCode #437 (https://leetcode.com/problems/path-sum-iii/)

// 10. Binary Tree Maximum Path Sum - LeetCode #124 (https://leetcode.com/problems/binary-tree-maximum-path-sum/)

import java.util.*;

public class f_BinaryTreeProblems {

    // Node class
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    // Inorder Traversal
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    // 1. Construct Binary Tree from Preorder and Inorder Traversal - LeetCode #105
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }

        root.left = buildTree(preorder, inorder, preStart + 1, inStart, inIndex - 1);
        root.right = buildTree(preorder, inorder, preStart + inIndex - inStart + 1, inIndex + 1, inEnd);

        return root;
    }

    // 2. Construct Binary Tree from Inorder and Postorder Traversal - LeetCode #106
    public static TreeNode buildTreeIP(int[] inorder, int[] postorder) {
        return buildTreeIP(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeIP(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
        if (postEnd < 0 || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }

        root.left = buildTreeIP(inorder, postorder, postEnd - (inEnd - inIndex) - 1, inStart, inIndex - 1);
        root.right = buildTreeIP(inorder, postorder, postEnd - 1, inIndex + 1, inEnd);

        return root;
    }

    // 3. Construct Binary Tree from Preorder and Postorder Traversal - LeetCode #889
    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    private static TreeNode constructFromPrePost(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd) return null;

        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) return root;

        int postIndex = postStart;
        for (int i = postStart; i < postEnd; i++) {
            if (post[i] == pre[preStart + 1]) {
                postIndex = i;
            }
        }

        int len = postIndex - postStart + 1;
        root.left = constructFromPrePost(pre, post, preStart + 1, preStart + len, postStart, postIndex);
        root.right = constructFromPrePost(pre, post, preStart + len + 1, preEnd, postIndex + 1, postEnd - 1);

        return root;
    }

    // 4. Construct Complete Binary Tree from Level Order Traversal - GFG
    public static TreeNode constructCompleteBinaryTree(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i < arr.length; i++) {
            TreeNode parent = q.peek();
            TreeNode child = new TreeNode(arr[i]);

            if (parent.left == null) {
                parent.left = child;
            } else {
                parent.right = child;
                q.poll();
            }

            q.add(child);
        }

        return root;
    }


    // 5. Flatten Binary Tree to Linked List - LeetCode #114
    public static void flatten(TreeNode root) { // O(n) space - recursive
        if (root == null) return;

        TreeNode left = root.left; // left subtree
        TreeNode right = root.right; // right subtree

        flatten(left);
        flatten(right);

        root.left = null; // left is null
        root.right = left; // left is now right

        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }

        temp.right = right;
    }

    // Another Method : Morris Traversal
    public static void flattenMorris(TreeNode root) { // O(1) space - Morris Traversal
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode pre = current.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }

    // 6. Amount of Time for Binary Tree to Be Infected - LeetCode #2385
    public int amountOfTime(TreeNode root, int start) {
        TreeNode node = getNode(root, start);
        Map<TreeNode, TreeNode> p = new HashMap<>(); // parent map => key: child, value: parent
        preorder(root, p);

        // BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        Map <TreeNode, Integer> v = new HashMap<>(); // visited map => key: node, value: level
        v.put(node, 0);
        while (!q.isEmpty()) {
            TreeNode temp = q.peek();
            int level = v.get(temp);
            if(temp.left != null && !v.containsKey(temp.left)) {
                q.add(temp.left);
                v.put(temp.left, level + 1);
            }
            if(temp.right != null && !v.containsKey(temp.right)) {
                q.add(temp.right);
                v.put(temp.right, level + 1);
            }
            if(p.containsKey(temp) && !v.containsKey(p.get(temp))) {
                q.add(p.get(temp));
                v.put(p.get(temp), level + 1);
            }
            q.remove();
        }

        int max = 0;
        for (int level : v.values()) {
            max = Math.max(max, level);
        }

        return max;

    }

    private TreeNode getNode(TreeNode root, int start) {
        if (root == null) return null;
        if (root.val == start) return root;

        TreeNode left = getNode(root.left, start);
        TreeNode right = getNode(root.right, start);

        return left != null ? left : right; // if left is not null return left else return right
    }

    private void preorder(TreeNode root, Map<TreeNode, TreeNode> p) {
        if (root == null) return;

        if (root.left != null) p.put(root.left, root);
        if (root.right != null) p.put(root.right, root);

        preorder(root.left, p);
        preorder(root.right, p);
    }

}
