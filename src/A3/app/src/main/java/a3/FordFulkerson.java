package a3;

import java.util.*;

public class FordFulkerson {
  public static boolean dfs(
      Integer curr, Integer dest, WGraph graph, Set<Integer> vis, ArrayList<Integer> path) {
    path.add(curr);
    vis.add(curr);

    if (curr.equals(dest)) return true;

    for (Edge edge : graph.getEdges())
      if (edge.nodes[0] == curr && !vis.contains(edge.nodes[1]) && edge.weight > 0)
        if (dfs(edge.nodes[1], dest, graph, vis, path)) return true;

    path.remove(path.size() - 1);

    return false;
  }

  public static ArrayList<Integer> pathDFS(Integer source, Integer destination, WGraph graph) {
    ArrayList<Integer> path = new ArrayList<>();
    return dfs(source, destination, graph, new HashSet<>(), path) ? path : new ArrayList<>();
  }

  public static String fordfulkerson(WGraph graph) {
    String answer = "";
    int maxFlow = 0;

    WGraph residualGraph = new WGraph(graph);

    for (Edge edge : graph.getEdges())
      residualGraph.addEdge(new Edge(edge.nodes[1], edge.nodes[0], 0));

    ArrayList<Integer> path = pathDFS(graph.getSource(), graph.getDestination(), residualGraph);

    while (!path.isEmpty()) {
      int curr = Integer.MAX_VALUE;

      for (int i = 0; i < path.size() - 1; i++) {
        Edge edge = residualGraph.getEdge(path.get(i), path.get(i + 1));
        if (edge != null) curr = Math.min(curr, edge.weight);
      }

      for (int i = 0; i < path.size() - 1; i++) {
        Edge edge = residualGraph.getEdge(path.get(i), path.get(i + 1));
        if (edge != null) {
          edge.weight -= curr;
          Edge reverseEdge = residualGraph.getEdge(path.get(i + 1), path.get(i));
          if (reverseEdge != null) reverseEdge.weight += curr;
          else residualGraph.addEdge(new Edge(path.get(i + 1), path.get(i), curr));
        }
      }

      maxFlow += curr;

      path = pathDFS(graph.getSource(), graph.getDestination(), residualGraph);
    }

    for (Edge edge : graph.getEdges()) {
      Edge reverseEdge = residualGraph.getEdge(edge.nodes[1], edge.nodes[0]);
      if (reverseEdge != null) graph.setEdge(edge.nodes[0], edge.nodes[1], reverseEdge.weight);
    }

    answer += maxFlow + "\n" + graph.toString();

    return answer;
  }
}
