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
   * @return The smallest number of coins that sum to `amount`.
   */
  static int dp(int[] coins, int amount) {
    int[] table = new int[amount + 1];

    Arrays.fill(table, amount + 1);

    table[0] = 0;

    for (int i = 1; i <= amount; ++i)
      for (int j = 0; j < coins.length; ++j)
        if (coins[j] <= i) table[i] = Math.min(1 + table[i - coins[j]], table[i]);

    return table[amount] > amount ? -1 : table[amount];
  }

  /*
   * Continuously compare the greedy and dp solutions
   * on candidate inputs.
   *
   * @param denominations The coins we're dealing with.
   * @return The smallest counter-example if greedy doesn't work, otherwise -1.
   */
  public static int change(int[] denominations) {
    if (denominations.length == 0 || denominations.length == 1) return -1;

    int l = 0, r = (denominations[denominations.length - 1] + denominations[denominations.length - 2]) - 1;

    int ans = Integer.MAX_VALUE;

    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (greedy(denominations, mid) != dp(denominations, mid)) {
        ans = Math.min(ans, mid);
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
}
