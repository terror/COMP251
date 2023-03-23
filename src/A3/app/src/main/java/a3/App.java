package a3;

public class App {
  public static void printResult(long[] pieces, int[][] instructions) {
    long[] result = A3Q2.num_pieces(pieces, instructions);
    for (int i = 0; i < result.length; ++i) System.out.print(result[i] + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    printResult(
        new long[] {0, 0, 0, 0, 3},
        new int[][] {
          {0, 1, 3},
          {1, 4, 1},
          {2, 4, 1},
          {3, 4, 2}
        });
    printResult(
        new long[] {0, 0, 0, 0, 0, 3},
        new int[][] {
          {0, 3, 3},
          {1, 4, 3},
          {2, 5, 1},
          {3, 5, 1},
          {4, 5, 1}
        });
    printResult(
        new long[] {0, 0, 2, 2, 3, 1},
        new int[][] {
          {0, 3, 1},
          {1, 3, 2},
          {2, 4, 1},
          {3, 4, 3},
          {3, 5, 1}
        });
  }
}
