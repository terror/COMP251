package tree;

/*
 * Definition for a red-black tree node.
 */
public class Node {
  int data;
  Node left, right, parent;
  boolean color;

  public Node(int data) {
    this.data = data;
  }

  public Node(int data, boolean color) {
    this.data = data;
    this.color = color;
  }
}
