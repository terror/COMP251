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

  static void dfs(int v, long quantity, ArrayList<ArrayList<Node>> adj, long[] pieces, boolean vis[]) {
    vis[v] = true;

    for (Node n : adj.get(v)) {
      if (!vis[n.piece]) {
        pieces[n.piece] += quantity * n.quantity;
        dfs(n.piece, quantity * n.quantity, adj, pieces, vis);
      }
    }
  }

  public static long[] num_pieces(long[] pieces, int[][] instructions) {
    int n = pieces.length;

    ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();

    for (int i = 0; i < n; ++i) adj.add(new ArrayList<Node>());

    for (int[] i : instructions)
      adj.get(i[1]).add(new Node(i[0], i[2]));

    for (int i = 0; i < n; ++i)
      if (pieces[i] != 0) dfs(i, pieces[i], adj, pieces, new boolean[n]);

    return pieces;
  }
}
