// Graph Traversal: Breadth First Search (BFS) - Indirect Level Order Traversal
// Go to immediate neighbors first
// BFS Algorithm uses Queue
// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph

import java.util.*;

public class b_BreadthFirstSearch {
    
    // Template for an edge with weight
    public static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Method to add an edge to the graph
    public static void addEdge(ArrayList<Edge>[] graph, int src, int dest) {
        graph[src].add(new Edge(src, dest));
        graph[dest].add(new Edge(dest, src)); // For undirected graph
    }

    // Method to create and initialize the graph
    public static ArrayList<Edge>[] createGraph(int V) {
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Example graph
        //      1
        //     / \
        //    2   3
        //     \ / \
        //      4   7
        //     / \ 
        //    5   6
        // BFS - 1 2 3 4 5 6 7

        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 4);
        addEdge(graph, 4, 5);
        addEdge(graph, 4, 6);
        addEdge(graph, 3, 7);

        return graph;
    }
    
    public static ArrayList<Edge>[] createGraph1(int V) {
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        /* 
        Example graph 
             1 ---- 3
            /       | \
           0        |  5 -- 6
            \       | /
             2 ---- 4
        BFS - 0 1 2 3 4 5 6 
        */

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 4);
        addEdge(graph, 3, 5);
        addEdge(graph, 4, 5);
        addEdge(graph, 5, 6);
        
        return graph;
    }

    // Method to perform BFS traversal
    public static void bfs(ArrayList<Edge>[] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int front = q.poll(); // remove the front element
            System.out.print(front + " ");
            for (Edge e : graph[front]) {
                if (!visited[e.dest]) {
                    q.add(e.dest);
                    visited[e.dest] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 8; // Number of vertices (index 0 is unused)
        ArrayList<Edge>[] graph = createGraph(V);
        System.out.println("BFS traversal of graph starting from node 1:");
        bfs(graph, 1);

        System.out.println();

        ArrayList<Edge>[] graph1 = createGraph1(7); // V = 7
        System.out.println("BFS traversal of graph1 starting from node 0:");
        bfs(graph1, 0);
    }
}
