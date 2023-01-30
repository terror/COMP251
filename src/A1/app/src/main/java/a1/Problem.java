package a1;

import java.util.*;

public class Problem {
  public static int elements(int[] sizes) {
    HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();

    int ans = 0, j = 0;

    for (int i = 0; i < sizes.length; ++i) {
      if (store.containsKey(sizes[i])) j = Math.max(j, store.get(sizes[i]) + 1);
      ans = Math.max(ans, i - j + 1);
      store.put(sizes[i], i);
    }

    return ans;
  }
}
