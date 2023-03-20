package a3;

import java.util.*;

public class A3Q1 {
  static class Node {
    public int x, y, count, time;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public Node(int x, int y, int count, int time) {
      this.x = x;
      this.y = y;
      this.count = count;
      this.time = time;
    }
  }

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

  static Node getOffset(String dir) {
    switch (dir) {
      case "U":
        return new Node(-1, 0);
      case "D":
        return new Node(1, 0);
      case "L":
        return new Node(0, -1);
      case "R":
        return new Node(0, 1);
      default:
        return null;
    }
  }

  static Node getStartingPosition(int time, String[][] board) {
    for (int i = 0; i < board.length; ++i)
      for (int j = 0; j < board[0].length; ++j)
        if (board[i][j].equals("S")) return new Node(i, j, 0, time);
    return null;
  }

  public static int find_exit(int time, String[][] board) {
    int row = board.length, col = board[0].length;

    boolean[][] vis = new boolean[row][col];

    Queue<Node> q = new LinkedList<>();

    Node start = getStartingPosition(time, board);
    q.add(start);
    vis[start.x][start.y] = true;

    String[] directions = new String[] {"U", "D", "L", "R"};

    int ans = Integer.MAX_VALUE;

    while (!q.isEmpty()) {
      Node curr = q.remove();

      if (curr.x == row - 1 || curr.x == 0 || curr.y == col - 1 || curr.y == 0) ans = Math.min(ans, curr.count);

      for (int i = 0; i < 4; ++i) {
        Node offset = getOffset(directions[i]);

        int x = curr.x + offset.x, y = curr.y + offset.y;

        if (validMove(board, vis, row, col, x, y, directions[i]) && curr.time > 0) {
          q.add(new Node(x, y, curr.count + 1, curr.time - 1));
          vis[x][y] = true;
        }
      }
    }

    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
}
