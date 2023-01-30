package a1;

import java.io.*;
import java.util.*;

public class OpenAddressing {
  public int m, A;
  int w, r;
  public int[] Table;

  protected OpenAddressing(int w, int seed, int A) {
    this.w = w;
    this.r = (w - 1) / 2 + 1;
    this.m = power2(r);

    if (A == -1) this.A = generateRandom(power2(w - 1), power2(w), seed);
    else this.A = A;

    this.Table = new int[m];

    for (int i = 0; i < m; i++) Table[i] = -1;
  }

  public static int power2(int w) {
    return (int) Math.pow(2, w);
  }

  public static int generateRandom(int min, int max, int seed) {
    Random generator = new Random();
    if (seed >= 0) generator.setSeed(seed);
    return generator.nextInt(max - min - 1) + min + 1;
  }

  private int probe(int key) {
    return ((A * key) % power2(w) >> (w - r));
  }

  public int probe(int key, int i) {
    return (probe(key) + i) % power2(r);
  }

  public int insertKey(int key) {
    int probe = 0, curr = probe(key, probe++);
    while (Table[curr] != -1) curr = probe(key, probe++);
    Table[curr] = key;
    return probe;
  }

  public int insertKeyArray(int[] keyArray) {
    int collision = 0;
    for (int key : keyArray) collision += insertKey(key);
    return collision;
  }

  public int removeKey(int key) {
    int probe = 0, curr = probe(key, probe++), first = curr;

    while (Table[curr] != key) {
      curr = probe(key, probe++);
      if (curr == first) return 0;
    }

    Table[curr] = -1;

    return probe;
  }
}
