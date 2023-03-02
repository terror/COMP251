package a2;

import java.util.*;

public class A2_Q4 {
  /*
   * Merge subroutine for the modified merge-sort algorithm.
   *
   * @param arr The array to modify.
   * @param l Left pointer.
   * @param m Mid pointer.
   * @param r Right pointer.
   * @return The number of swaps for this merge.
   */
  static double merge(int arr[], int l, int m, int r) {
    double count = 0;

    int[] left = new int[m - l + 1], right = new int[r - m];

    for (int i = 0; i < left.length; ++i) left[i] = arr[i + l];
    for (int i = 0; i < right.length; ++i) right[i] = arr[i + m + 1];

    int i = 0, j = 0, k = l;

    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) arr[k++] = left[i++];
      else {
        arr[k++] = right[j++];
        count += (m + 1) - (l + i);
      }
    }

    while (i < left.length) arr[k++] = left[i++];
    while (j < right.length) arr[k++] = right[j++];

    return count;
  }

  /*
   * Main entrypoint for the modified merge-sort algorithm.
   *
   * @param arr The array to sort.
   * @return The number of swaps needed to sort.
   */
  static double sort(int arr[], int l, int r) {
    double count = 0;
    if (l < r)
      count +=
          sort(arr, l, (l + r) / 2) + sort(arr, (l + r) / 2 + 1, r) + merge(arr, l, (l + r) / 2, r);
    return count;
  }

  /*
   * Calls the modified merge-sort algorithm.
   *
   * @param passengers The passengers to sort.
   * @return The number of swaps needed to sort.
   */
  public static double swaps(int[] passengers) {
    return sort(passengers, 0, passengers.length - 1);
  }
}
