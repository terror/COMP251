package a3;

import java.util.*;

public class A3Q2 {
  static List<Integer> sort(ArrayList<ArrayList<int[]>> adj) {
    int n = adj.size();

    int[] deg = new int[n];

    for (List<int[]> nodes : adj) for (int[] node : nodes) deg[node[0]]++;

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < n; ++i) if (deg[i] == 0) queue.add(i);

    List<Integer> ret = new ArrayList<>();

    while (!queue.isEmpty()) {
      int v = queue.poll();
      ret.add(v);
      for (int[] node : adj.get(v)) if (--deg[node[0]] == 0) queue.add(node[0]);
    }

    return ret;
  }

  public static long[] num_pieces(long[] pieces, int[][] instructions) {
    int n = pieces.length;

    ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

    for (int i = 0; i < n; ++i) adj.add(new ArrayList<>());

    for (int[] i : instructions) adj.get(i[1]).add(new int[] {i[0], i[2]});

    for (int i : sort(adj)) for (int[] node : adj.get(i)) pieces[node[0]] += pieces[i] * node[1];

    return pieces;
  }
}
