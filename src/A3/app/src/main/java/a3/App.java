package a3;

import java.io.File;

public class App {
  public static void main(String[] args) {
    if (args.length == 0) System.out.println("Must pass in file");
    else {
      String file = args[0];
      System.out.println(file);
      File f = new File(file);
      WGraph g = new WGraph(file);
      System.out.println(FordFulkerson.fordfulkerson(g));
    }
  }
}
