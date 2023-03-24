package a3;

import java.util.*;

public class A3Q1 {
  static boolean validMove(
      String[][] board, boolean[][] vis, int row, int col, int x, int y, String direction) {
    if (x < 0 || x >= row || y < 0 || y >= col || vis[x][y]) return false;

    if (board[x][y].equals("1")) return false;

    if (board[x][y].equals("0")) return true;

    if ((board[x][y].equals("U") && !direction.equals("D"))
        || (board[x][y].equals("L") && !direction.equals("R"))
        || (board[x][y].equals("R") && !direction.equals("L"))
        || (board[x][y].equals("D") && !direction.equals("U"))) return false;

    return true;
  }

  static int[] getOffset(String dir) {
    switch (dir) {
      case "U":
        return new int[] {-1, 0};
      case "D":
        return new int[] {1, 0};
      case "L":
        return new int[] {0, -1};
      case "R":
        return new int[] {0, 1};
      default:
        return new int[] {};
    }
  }

  static int[] getStartingPosition(int time, String[][] board) {
    for (int i = 0; i < board.length; ++i)
      for (int j = 0; j < board[0].length; ++j)
        if (board[i][j].equals("S")) return new int[] {i, j, 0, time};
    return new int[] {};
  }

  public static int find_exit(int time, String[][] board) {
    int row = board.length, col = board[0].length;

    boolean[][] vis = new boolean[row][col];

    Queue<int[]> q = new LinkedList<>();

    int[] start = getStartingPosition(time, board);
    q.add(start);
    vis[start[0]][start[1]] = true;

    String[] directions = new String[] {"U", "D", "L", "R"};

    int ans = Integer.MAX_VALUE;

    while (!q.isEmpty()) {
      int[] curr = q.remove();

      if (curr[0] == row - 1 || curr[0] == 0 || curr[1] == col - 1 || curr[1] == 0)
        ans = Math.min(ans, curr[2]);

      for (int i = 0; i < 4; ++i) {
        int[] offset = getOffset(directions[i]);

        int x = curr[0] + offset[0], y = curr[1] + offset[1];

        if (validMove(board, vis, row, col, x, y, directions[i]) && curr[3] > 0) {
          q.add(new int[] {x, y, curr[2] + 1, curr[3] - 1});
          vis[x][y] = true;
        }
      }
    }

    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
}
