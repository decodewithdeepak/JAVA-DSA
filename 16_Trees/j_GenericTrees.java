// Notes : https://drive.google.com/file/d/1-LVfOnMCrdbGifiRgpSDZbqW1Ein61ct/view

// Generic Trees (N-ary Trees) - Generic trees are trees where each node can have any number of children.

import java.util.*;

public class j_GenericTrees {

    // Node class of a generic tree
    public static class Node {
        int data;
        ArrayList<Node> child;

        Node (int data) {
            this.data = data;
            child = new ArrayList<>();
        }
    }

    // Display the generic tree
    public static void display(Node node) {
        System.out.print(node.data + " -> ");
        for (Node child : node.child) {
            System.out.print(child.data + ", ");
        }
        System.out.println(".");

        for (Node child : node.child) {
            display(child);
        }
    }

    // DFS Traversal of a generic tree
    // Preorder traversal - Root then child
    public static void preorder(Node node) {
        // base case not required as for loop will not run if there are no children
        System.out.print(node.data + " ");
        for (Node child : node.child) {
            preorder(child);
        }
    }

    // Postorder traversal - Child then root
    public static void postorder(Node node) {
        for (Node child : node.child) {
            postorder(child);
        }
        System.out.print(node.data + " ");
    }

    // Inorder traversal - Not possible in generic trees due to multiple children

    // BFS Traversal of a generic tree
    // Level order traversal - Level by level from left to right
    public static void levelOrder(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node temp = q.remove();
            System.out.print(temp.data + " ");
            for (Node child : temp.child) {
                q.add(child);
            }
        }
    }

    // Zigzag traversal - Level by level from left to right and right to left alternatively
    public static void zigzag(Node node) {    
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node temp = q.remove();
                level.add(temp.data);
                for (Node child : temp.child) q.add(child);
            }

            if (leftToRight) {
                for (int i = 0; i < level.size(); i++) {
                    System.out.print(level.get(i) + " ");
                }
            } 
            else {
                for (int i = level.size() - 1; i >= 0; i--) { // reverse order
                    System.out.print(level.get(i) + " ");
                }
            }

            leftToRight = !leftToRight;
        }
    }

    // Find the node with maximum value in a generic tree
    public static int findMax(Node node) {
        int max = node.data;
        for (Node child : node.child) {
            max = Math.max(max, findMax(child));
        }
        return max;
    }

    // Find the height of a generic tree
    public static int height(Node node) {
        int h = -1; // height of a tree with 0 nodes is -1
        for (Node child : node.child) {
            h = Math.max(h, height(child));
        }
        return h + 1;
    }

    // Find the size of a generic tree
    public static int size(Node node) {
        int s = 0;
        for (Node child : node.child) {
            s += size(child);
        }
        return s + 1;
    }

    // Convert a generic tree to a mirror image
    public static void mirror(Node node) {
        for (Node child : node.child) {
            mirror(child);
        }
        Collections.reverse(node.child);
    }

    public static void main(String[] args) {
        Node root = new Node(30); // root node
        root.child.add(new Node(5));
        root.child.add(new Node(11));
        root.child.add(new Node(63));

        root.child.get(0).child.add(new Node(1));
        root.child.get(0).child.add(new Node(4));
        root.child.get(0).child.add(new Node(8));

        root.child.get(1).child.add(new Node(6));
        root.child.get(1).child.add(new Node(7));
        root.child.get(1).child.add(new Node(15));

        root.child.get(2).child.add(new Node(31));
        root.child.get(2).child.add(new Node(55));
        root.child.get(2).child.add(new Node(65));

        //                 30
        //            /    |    \
        //         5       11       63  
        //       / | \    / | \    / | \
        //      1  4  8  6  7 15  31 55 65

        // Display the generic tree
        System.out.println("Generic Tree:");
        display(root);

        // Preorder Traversal of a generic tree
        System.out.println("\nPreorder traversal:");
        preorder(root);

        // Postorder Traversal of a generic tree
        System.out.println("\nPostorder traversal:");
        postorder(root);

        // Level order Traversal of a generic tree
        System.out.println("\nLevel order traversal:");
        levelOrder(root);

        // Zigzag Traversal of a generic tree
        System.out.println("\nZigzag traversal:");
        zigzag(root);

        // Find the node with maximum value in a generic tree
        System.out.println("\nMax value in the generic tree: " + findMax(root));

        // Find the height of a generic tree
        System.out.println("Height of the generic tree: " + height(root));

        // Find the size of a generic tree
        System.out.println("Size of the generic tree: " + size(root));

        // Convert a generic tree to a mirror image
        System.out.println("Mirror image of the generic tree:");
        mirror(root);
        levelOrder(root);

    }
    
}