package a3;

import java.util.*;

public class A3Q2 {
  static class Node {
    public int piece, quantity;

    public Node(int piece, int quantity) {
      this.piece = piece;
      this.quantity = quantity;
    }
  }

  static List<Integer> sort(ArrayList<ArrayList<Node>> adj) {
    int n = adj.size();

    int[] deg = new int[n];

    for (List<Node> nodes : adj) for (Node node : nodes) deg[node.piece]++;

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < n; ++i) if (deg[i] == 0) queue.add(i);

    List<Integer> ret = new ArrayList<>();

    while (!queue.isEmpty()) {
      int v = queue.poll();
      ret.add(v);
      for (Node node : adj.get(v)) if (--deg[node.piece] == 0) queue.add(node.piece);
    }

    return ret;
  }

  public static long[] num_pieces(long[] pieces, int[][] instructions) {
    int n = pieces.length;

    ArrayList<ArrayList<Node>> adj = new ArrayList<>();

    for (int i = 0; i < n; ++i) adj.add(new ArrayList<>());

    for (int[] i : instructions) adj.get(i[1]).add(new Node(i[0], i[2]));

    for (int i : sort(adj))
      for (Node node : adj.get(i)) pieces[node.piece] += pieces[i] * node.quantity;

    return pieces;
  }
}
