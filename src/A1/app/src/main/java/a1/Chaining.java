package a1;

import java.io.*;
import java.util.*;

public class Chaining {
  public int m, A;
  int w, r;
  public ArrayList<ArrayList<Integer>> Table;

  protected Chaining(int w, int seed, int A) {
    this.w = w;
    this.r = (w - 1) / 2 + 1;
    this.m = power2(r);

    this.Table = new ArrayList<ArrayList<Integer>>(m);

    for (int i = 0; i < m; i++) Table.add(new ArrayList<Integer>());

    if (A == -1) this.A = generateRandom(power2(w - 1), power2(w), seed);
    else this.A = A;
  }

  public static int power2(int w) {
    return (int) Math.pow(2, w);
  }

  public static int generateRandom(int min, int max, int seed) {
    Random generator = new Random();
    if (seed >= 0) generator.setSeed(seed);
    return generator.nextInt(max - min - 1) + min + 1;
  }

  public int chain(int key) {
    return (((A * key) % power2(w)) >> (w - r));
  }

  public int insertKey(int key) {
    int hash = chain(key), ret = Table.get(hash).size();
    Table.get(hash).add(0, key);
    return ret;
  }

  public int insertKeyArray(int[] keyArray) {
    int collision = 0;
    for (int key : keyArray) collision += insertKey(key);
    return collision;
  }
}
