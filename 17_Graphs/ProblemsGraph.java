// Leetcode Problems

// 1. All Paths From Source to Target - LeetCode #797 (https://leetcode.com/problems/all-paths-from-source-to-target/)
// 2. Rotten Oranges - LeetCode #994 (https://leetcode.com/problems/rotting-oranges/)
// 3. Number of Islands - LeetCode #200 (https://leetcode.com/problems/number-of-islands/)
// 4. Course Schedule - LeetCode #207 (https://leetcode.com/problems/course-schedule/)
// 5. Find Eventual Safe States - LeetCode #802 (https://leetcode.com/problems/find-eventual-safe-states/)
// 6. Cheapest Flights Within K Stops - LeetCode #787 (https://leetcode.com/problems/cheapest-flights-within-k-stops/)
// 7. Remove Max Number of Edges to Keep Graph Fully Traversable - LeetCode #1579 (https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/)
// 8. Critical Connections in a Network - LeetCode #1192 (https://leetcode.com/problems/critical-connections-in-a-network/)

import java.util.*;

public class ProblemsGraph {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0); // Assuming 0 is the source node
        dfs(graph, 0, path, result);
        return result;
    }

    private static void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        if (node == graph.length - 1) { // Assuming the last node is the destination
            result.add(new ArrayList<>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfs(graph, nextNode, path, result);
            path.remove(path.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        // Test Case
        int[][] graph = {
                    {1, 2}, // 0 -> 1, 2
                    {3},    // 1 -> 3
                    {3},    // 2 -> 3
                    {}      // 3 -> none
                    };
        List<List<Integer>> result = allPathsSourceTarget(graph);
        System.out.println(result);
    }
}
