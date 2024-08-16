// Adjacency List Representation of a graph
// An adjacency list represents a graph as an array or list of lists. Each list corresponds to a node in the graph and contains a list of its neighboring nodes.

import java.util.ArrayList;

public class b_AdjacencyListRepresentation {
    
    // Template for an edge
    public static class Edge { 
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    // Method to add an edge to the graph
    public static void addEdge(ArrayList<Edge>[] graph, int src, int dest, int weight) {
        graph[src].add(new Edge(src, dest, weight));
        graph[dest].add(new Edge(dest, src, weight)); // For undirected graph
    }

    // Method to print the graph
    public static void printGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (Edge edge : graph[i]) {
                System.out.print("(" + edge.src + ", " + edge.dest + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
  
        // Store the graph as an adjacency list

        //  0   3
        //   \ / \
        //    2---1

        // 0 -> (0, 2, weight)
        // 1 -> (1, 2, weight), (1, 3, weight)
        // 2 -> (2, 0, weight), (2, 1, weight), (2, 3, weight)
        // 3 -> (3, 1, weight), (3, 2, weight)

        int V = 4; // Number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Initialize adjacency lists for each vertex
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges with weights
        addEdge(graph, 0, 2, 10);
        addEdge(graph, 2, 3, 20);
        addEdge(graph, 2, 1, 30);
        addEdge(graph, 3, 1, 40);

        // Print the graph
        printGraph(graph);
    }
}
