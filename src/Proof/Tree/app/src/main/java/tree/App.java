package tree;

import java.util.*;
import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class App {
  /*
   * Run insertion on a tree with a given number of nodes.
   *
   * @param n The number of nodes the tree should have.
   * @return The amount of time an insertion took.
   */
  static double runInsertion(int n) {
    Tree tree = new Tree();

    for (int i = 0; i < n; ++i) tree.insert(i);

    double start = System.nanoTime();
    tree.insert(n);
    double end = System.nanoTime();

    return (end - start) / 1000;
  }

  /*
   * Plot the insertion time chart.
   */
  static void plotChart() {
    int samples = 100;

    double[] x = new double[samples];
    double[] y = new double[samples];

    int n = 10;

    for (int i = 0; i < samples; ++i) {
      System.out.println("Current iteration: " + i);
      y[i] = runInsertion(n);
      x[i] = n;
      n += 1;
    }

    XYChart chart =
        QuickChart.getChart(
            "Red-Black tree insertion time",
            "Number of nodes",
            "Execution Time (us)",
            "Insertion time",
            x,
            y);

    double[] y2 = new double[samples];

    for (int i = 0; i < samples; ++i) y2[i] = Math.log(x[i]) / 10;

    chart.addSeries("log(n) / 10", x, y2).setMarker(SeriesMarkers.NONE);

    new SwingWrapper<>(chart).displayChart();
  }

  /*
   * Compute the height of a tree after inserting
   * a certain amount of nodes.
   *
   * @param n The number of nodes to insert.
   * @return The height of the tree after insertion.
   */
  static int computeHeight(int n) {
    Tree tree = new Tree();
    for (int i = 0; i < n; ++i) tree.insert(i);
    return tree.height();
  }

  /*
   * Compare the height of the tree with 2 * log(n + 1) for
   * some sample test cases.
   */
  public static void main(String[] args) {
    int[] cases = new int[] {1, 10, 100000, 1000000};

    for (int i = 0; i < cases.length; ++i) {
      System.out.println("Number of nodes: " + cases[i]);
      System.out.println("Height: " + computeHeight(cases[i]));
      System.out.println("2 * log(n + 1): " + 2 * Math.log(cases[i] + 1));
      System.out.println();
    }
  }
}
