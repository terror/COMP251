package a1;

import java.io.*;
import java.util.*;

public class DisjointSets {
  private int[] par, rank;

  DisjointSets(int n) {
    if (n > 0) {
      par = new int[n];
      rank = new int[n];
      for (int i = 0; i < this.par.length; i++) par[i] = i;
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
    if (find(i) == find(j)) return 0;

    int a = find(i), b = find(j);

    return 1;
  }

  public static void main(String[] args) {
    DisjointSets myset = new DisjointSets(6);

    System.out.println(myset);
    System.out.println("-> Union 2 and 3");

    myset.union(2, 3);

    System.out.println(myset);
    System.out.println("-> Union 2 and 3");

    myset.union(2, 3);

    System.out.println(myset);
    System.out.println("-> Union 2 and 1");

    myset.union(2, 1);

    System.out.println(myset);
    System.out.println("-> Union 4 and 5");

    myset.union(4, 5);

    System.out.println(myset);
    System.out.println("-> Union 3 and 1");

    myset.union(3, 1);

    System.out.println(myset);
    System.out.println("-> Union 2 and 4");

    myset.union(2, 4);

    System.out.println(myset);
  }
}
