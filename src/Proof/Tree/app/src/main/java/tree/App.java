package tree;

import java.util.*;
import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class App {
  static double runInsertion(int n) {
    Tree tree = new Tree();

    for (int i = 0; i < n; ++i) tree.insert(i);

    double start = System.nanoTime();
    tree.insert(n);
    double end = System.nanoTime();

    return (end - start) / 1000;
  }

  public static void main(String[] args) {
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
}
