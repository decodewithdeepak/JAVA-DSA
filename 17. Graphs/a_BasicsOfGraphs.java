// Graphs in One Shot - Apni Kaksha

// Graphs are a network of nodes connected by edges. They are used to represent connections between pairs of objects.

// Terminology -
// 1. Node (Vertex): Entity that contains a key or value.
// 2. Edge (Link): Connection between two nodes.
// 3. Adjacent Nodes: Nodes that are directly connected by an edge.
// 4. Path: Sequence of edges between two nodes forming a route from one node to another.
// 5. Circuit: Closed path that starts and ends at the same node and may revisit some  nodes.
// 6. Cycle: Closed path that starts and ends at the same node and does not revisit any node.
//       OR  Circuit that doesn’t revisit any nodes except for the starting/ending node.

// Applications of Graphs -
// 1. Social Networks
// 2. Google Maps
// 3. Network Routing
// 4. Recommendation Systems
// 5. Network Analysis
// 6. Computer Networks
// 7. Game Development
// 8. Delivery Networks

// Types of Graphs -
// 1. Directed Graphs (Digraphs): Graphs in which edges have a specific direction. (Uni-directional Edge)
// 2. Undirected Graphs: Graphs in which edges do not have a specific direction. (Un-directional or Bi-directional Edge)
// 3. Weighted Graphs: Graphs in which edges have weights or costs. (Weighted Edge)
// 4. Unweighted Graphs: Graphs in which edges do not have weights. (Un-weighted Edge)
// 5. Cyclic Graphs: Graphs that contain cycles.
// 6. Acyclic Graphs: Graphs that do not contain cycles.
// 7. Connected Graphs: Graphs in which there is a path between every pair of vertices.
// 8. Disconnected Graphs: Graphs in which there is no path between at least one pair of vertices.
// 9. Complete Graphs: Graphs in which there is an edge between every pair of vertices.
// 10. Bipartite Graphs: Graphs in which vertices can be divided into two disjoint sets such that there is no edge between vertices of the same set.

// Graph Representation -
// 1. Adjacency List: An array of lists is used. The size of the array is equal to the number of vertices. Let the array be an array[]. An entry array[i] represents the list of vertices adjacent to the ith vertex.
// 2. Adjacency Matrix: A 2D array of size V x V where V is the number of vertices in a graph. If there is an edge between vertices i and j, then adj[i][j] = 1, otherwise adj[i][j] = 0.
// 3. Edge List: A list of all the edges in the graph.
// 4. Incidence Matrix: A 2D array of size V x E where V is the number of vertices and E is the number of edges in a graph. If vertex i is incident on edge j, then inc[i][j] = 1, otherwise inc[i][j] = 0.

// Graph Traversal -
// 1. Breadth First Search (BFS): Traverses the graph level by level.
// 2. Depth First Search (DFS): Traverses the graph by going as deep as possible along each branch before backtracking.

public class a_BasicsOfGraphs {


}