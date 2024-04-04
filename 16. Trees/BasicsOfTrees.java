// Notes : https://drive.google.com/file/d/14jWtFutt2WGUkHxC5_5vCUVGiutZ5fMn/view

// Basics of Trees
// 1. Trees are non-linear hierarchical data structures.
// 2. Trees are used to represent the nodes connected by edges.
// 3. Trees are mainly used to maintain hierarchical data like structure of a file system.
// 4. Traversing in a tree is done by Depth First Traversal (DFS) and Breadth First Traversal (BFS).
// 5. It has no loop (cycle) and no circuit. Also it has no self loop.

// Terminology
// 1. Node: Entity that contains a key or value and pointers to its child nodes.
// 2. Edge: Link between two nodes.
// 3. Root: Topmost node of a tree.

// 4. Child node: Node below a given node connected by its edge.
// 5. Parent node: Node connected by its edge above a given node.
// 6. Sibling node: Nodes with the same parent.
// 7. Leaf node: Nodes that do not have any child node.
// 8. Internal node: Nodes that have at least one child node, i.e., non-leaf nodes and non-root nodes.
// 9. Ancestor node: A node that is on the path from the root to the node.
// 10. Descendant node: A node that is on the path from the node to a leaf.

// 11. Level of a node: Number of edges on the path from the root to the node.
// 12. Level of a tree: Maximum level of any node in the tree.
// 13. Height of a node: Number of edges on the longest path from the node to a leaf.
// 14. Height(Depth) of a tree: Maximum height of any node in the tree.
// 15. Degree of a node: Number of sub-trees of a node.
// 16. Degree of a tree: Maximum degree of any node in the tree.

// 17. Sub-tree: A tree T2 is a sub-tree of T1 if T2 is a tree and all nodes of T2 are also present in T1.
// 18. Forest: A collection of disjoint trees.

// Diagram of a Tree
//         1 <-- Root
//       / | \
//      2  3  4
//     / \    / \
//    5   6  7   8
//       / \
//      9  10 <-- Leaf Node

// Types of Trees -
// 1. Generic (N-ary) Tree: A tree in which a node can have any number of children.
// 2. Binary Tree: A tree in which a node can have at most two children.
// 3. Binary Search Tree (BST): A binary tree in which for each node, all elements in the left sub-tree are less than the node and all elements in the right sub-tree are greater than the node.
// 4. AVL Tree: A self-balancing binary search tree in which the heights of the two child subtrees of any node differ by at most one.
// 5. Red-Black Tree: A self-balancing binary search tree in which each node has an extra bit for denoting the color of the node.
// 6. B-Tree: A self-balancing tree in which each node can have more than two children.
// 7. B+ Tree: A self-balancing tree in which each node can have more than two children and all keys are present in the leaf nodes.


public class BasicsOfTrees {

    public static void main(String[] args) {
        System.out.println("Basics of Trees");
    }
}
