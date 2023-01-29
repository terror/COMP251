import java.io.*;
import java.util.*;

public class DisjointSets {
  private int[] par;
  private int[] rank;

  DisjointSets(int n) {
    if (n > 0) {
      par = new int[n];
      rank = new int[n];
      for (int i = 0; i < this.par.length; i++) {
        par[i] = i;
      }
    }
  }

  public String toString() {
    int pari, countsets = 0;

    String output = "";

    String[] setstrings = new String[this.par.length];

    for (int i = 0; i < this.par.length; i++) {
      pari = find(i);
      if (setstrings[pari] == null) {
        setstrings[pari] = String.valueOf(i);
        countsets += 1;
      } else {
        setstrings[pari] += "," + i;
      }
    }

    output = countsets + " set(s):\n";

    for (int i = 0; i < this.par.length; i++) {
      if (setstrings[i] != null) {
        output += i + " : " + setstrings[i] + "\n";
      }
    }

    return output;
  }

  public int find(int i) {
    return 0;
  }

  public int union(int i, int j) {
    return 0;
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
