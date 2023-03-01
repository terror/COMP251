package a2;

import java.util.*;

public class A2_Q2 {
  /*
   * Greedy implementation of the coin-change problem
   * solution.
   *
   * => Always pick the largest coin possible.
   *
   * @param coins The coin denominations.
   * @param amount The amount to sum to.
   * @return The smallest number of coins that sum to `amount`.
   */
  static int greedy(int[] coins, int amount) {
    int ans = 0;

    for (int i = coins.length - 1; i >= 0; --i) {
      int can = amount / coins[i];
      amount -= coins[i] * can;
      ans += can;
    }

    return amount != 0 ? -1 : ans;
  }

  /*
   * Dynamic programming implementation of the coin-change
   * problem solution (bottom-up).
   *
   * @param coins The coin denominations.
   * @param amount The amount to sum to.
   * @return The memoized table.
   */
  static int[] dp(int[] coins, int amount) {
    int[] table = new int[amount + 1];

    Arrays.fill(table, Integer.MAX_VALUE);

    table[0] = 0;

    for (int i = 1; i <= amount; ++i)
      for (int j = 0; j < coins.length; ++j)
        if (coins[j] <= i) table[i] = Math.min(1 + table[i - coins[j]], table[i]);

    return table;
  }

  /*
   * Continuously compare the greedy and dp solutions
   * on candidate inputs.
   *
   * @param denominations The coins we're dealing with.
   * @return The smallest counter-example if greedy doesn't work, otherwise -1.
   */
  public static int change(int[] denominations) {
    int amount = denominations[denominations.length - 1] + denominations[denominations.length - 2];

    int[] table = dp(denominations, amount - 1);

    for (int i = denominations[0]; i < amount; ++i)
      if ((table[i] > i ? -1 : table[i]) != greedy(denominations, i)) return i;

    return -1;
  }
}
