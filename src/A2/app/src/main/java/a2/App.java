package a2;

/*
 * 3
 * 1 0
 * 1 0 8
 * 5 6 3 4
 * 9 3 2 1 9
 */

public class App {
  public static void main(String[] args) {
    System.out.println(
        A2_Q1.game_recursion(
            new int[][] {
              {0, -1, -1},
              {1, 2, -1},
              {3, 4, 5},
            }));
    System.out.println(
        A2_Q1.game_recursion(
            new int[][] {
              {3, -1, -1, -1, -1},
              {1, 6, -1, -1, -1},
              {1, 7, 8, -1, -1},
              {5, 0, 3, 4, -1},
              {9, 3, 2, 1, 9}
            }));
    System.out.println(
        A2_Q1.game_recursion(
            new int[][] {
              {0, -1, -1, -1, -1},
              {1, 1, -1, -1, -1},
              {1, 1, 1, -1, -1},
              {1, 1, 1, 1, -1},
              {1, 1, 1, 1, 1}
            }));
    System.out.println(
        A2_Q1.game_recursion(
            new int[][] {
              {1, -1, -1, -1, -1},
              {1, 1, -1, -1, -1},
              {1, 1, 1, -1, -1},
              {1, 1, 1, 1, -1},
              {1, 1, 0, 100, 1}
            }));
    System.out.println(
        A2_Q1.game_recursion(
            new int[][] {
              {55, -1, -1, -1, -1},
              {99, 24, -1, -1, -1},
              {77, 93, 19, -1, -1},
              {27, 26, 5, 53, -1},
              {9, 90, 48, 44, 0}
            }));
    System.out.println(
        A2_Q1.game_recursion(
            new int[][] {
              {56, -1, -1, -1, -1},
              {12, 56, -1, -1, -1},
              {56, 16, 51, -1, -1},
              {34, 56, 56, 0, -1},
              {56, 22, 56, 43, 56}
            }));
  }
}
