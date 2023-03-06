package a2;

import java.util.*;

class Move {
  public int sX, sY, mX, mY, eX, eY;

  public Move(int sX, int sY, int eX, int eY) {
    this.sX = sX;
    this.sY = sY;
    this.mX = (sX + eX) / 2;
    this.mY = (sY + eY) / 2;
    this.eX = eX;
    this.eY = eY;
  }
}

public class A2_Q1 {
  static ArrayList<Move> allMoves(int[][] board) {
    int row = board.length, col = board[0].length;

    int[][] directions = {{0, 2}, {0, -2}, {2, 0}, {-2, 0}, {2, 2}, {-2, -2}};

    ArrayList<Move> moves = new ArrayList<>();

    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < col; ++j) {
        if (board[i][j] <= 0) continue;
        for (int[] direction : directions) {
          int r = i + direction[0], c = j + direction[1];
          if (r >= 0
              && r < row
              && c >= 0
              && c < col
              && board[r][c] == 0
              && board[(i + r) / 2][(j + c) / 2] > 0) moves.add(new Move(i, j, r, c));
        }
      }
    }

    return moves;
  }

  static int helper(int[][] board, boolean turn, int sa, int sb) {
    ArrayList<Move> moves = allMoves(board);

    if (moves.isEmpty()) return sa - sb;

    int ans = turn ? 0 : Integer.MAX_VALUE;

    for (Move move : moves) {
      int score = board[move.sX][move.sY] * board[move.mX][move.mY],
          start = board[move.sX][move.sY],
          mid = board[move.mX][move.mY];

      board[move.sX][move.sY] = 0;
      board[move.mX][move.mY] = 0;
      board[move.eX][move.eY] = start;

      if (turn) ans = Math.max(ans, helper(board, !turn, sa + score, sb));
      else ans = Math.min(ans, helper(board, !turn, sa, sb + score));

      board[move.sX][move.sY] = start;
      board[move.mX][move.mY] = mid;
      board[move.eX][move.eY] = 0;
    }

    return ans;
  }

  public static int game_recursion(int[][] board) {
    return helper(board, true, 0, 0);
  }
}
