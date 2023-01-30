package a1;

import java.io.*;
import java.util.*;

public class DisjointSets {
  private int[] par, rank;

  DisjointSets(int n) {
    if (n > 0) {
      par = new int[n];
      rank = new int[n];

      for (int i = 0; i < n; i++) {
        par[i] = i;
        rank[i] = 0;
      }
    }
  }

  public String toString() {
    int count = 0;

    String output = "";

    String[] strings = new String[this.par.length];

    for (int i = 0; i < this.par.length; i++) {
      int curr = find(i);

      if (strings[curr] == null) {
        strings[curr] = String.valueOf(i);
        count += 1;
      } else strings[curr] += "," + i;
    }

    output = count + " set(s):\n";

    for (int i = 0; i < this.par.length; i++)
      if (strings[i] != null) output += i + " : " + strings[i] + "\n";

    return output;
  }

  public int find(int i) {
    if (par[i] == i) return i;
    return par[i] = find(par[i]);
  }

  public int union(int i, int j) {
    int a = find(i), b = find(j);

    if (a == b) return a;

    if (rank[a] > rank[b]) {
      int t = b;
      b = a;
      a = t;
    }

    par[a] = b;

    if (rank[a] == rank[b]) ++rank[b];

    return b;
  }
}
