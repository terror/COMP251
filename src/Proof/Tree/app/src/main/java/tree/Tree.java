package tree;

/*
 * A red-black tree with an insert operation.
 */
public class Tree {
  Node root;

  static final boolean RED = false, BLACK = true;

  /*
   * Default constructor.
   */
  public Tree() {}

  /*
   * Constructor with root.
   *
   * @param root The root of the tree.
   */
  public Tree(Node root) {
    this.root = root;
  }

  /*
   * Insert a node into the red-black tree.
   *
   * => Simulates a normal BST insertion but finishes
   * with a fixUp subroutine for violated RB-tree properties.
   *
   * @param key The data the new node should have.
   */
  public void insert(int key) {
    Node node = root, par = null;

    while (node != null) {
      par = node;
      if (key < node.data) node = node.left;
      else if (key > node.data) node = node.right;
      else throw new IllegalArgumentException("Tree already contains a node with key " + key + ".");
    }

    Node curr = new Node(key, RED);

    if (par == null) root = curr;
    else if (key < par.data) par.left = curr;
    else par.right = curr;

    curr.parent = par;

    fixUp(curr);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    toStringHelper(root, builder);
    return builder.toString();
  }

  /*
   * Fix red-black tree properties after an insertion.
   *
   * @param node The node to initiate the fix from.
   */
  private void fixUp(Node node) {
    Node par = node.parent;

    // Case 1: Parent is null or black
    // => We don't need to do anything
    if (par == null || par.color == BLACK) return;

    // Case 2: Parent is red and is the root node
    // => Just need to recolor the parent node
    //     R        B
    //      \   ->   \
    //       R        R
    if (par.parent == null) {
      par.color = BLACK;
      return;
    }

    // Grab the uncle of the parent node
    Node uncle = getUncle(par);

    // Case 3: Uncle is red
    // => Recolor the parent, grandparent and uncle nodes
    if (uncle != null && uncle.color == RED) {
      par.color = BLACK;
      grandparent.color = RED;
      uncle.color = BLACK;
      // Recursively fix the grandparent node
      fixUp(grandparent);
    } else if (par == grandparent.left) {
      // Case 4a:
      if (node == par.right) {
        rotateLeft(par);
        par = node;
      }
      // Case 5a:
      rotateRight(grandparent);
      par.color = BLACK;
      grandparent.color = RED;
    } else {
      // Case 4b:
      if (node == par.left) {
        rotateRight(par);
        par = node;
      }
      // Case 5b:
      rotateLeft(grandparent);
      par.color = BLACK;
      grandparent.color = RED;
    }
  }

  /*
   * Get the uncle node of a given input node.
   *
   * @param parent The node to grab the uncle from.
   * @return The uncle node.
   */
  private Node getUncle(Node parent) {
    Node grandparent = parent.parent;
    if (grandparent.left == parent) return grandparent.right;
    if (grandparent.right == parent) return grandparent.left;
    throw new IllegalStateException("Parent is not a child of its grandparent.");
  }

  /*
   * Perform a right tree rotation.
   *
   * @param node The node to rotate from.
   */
  private void rotateRight(Node node) {
    Node par = node.parent, left = node.left;
    node.left = left.right;
    if (left.right != null) left.right.parent = node;
    left.right = node;
    node.parent = left;
    replace(par, node, left);
  }

  /*
   * Perform a left tree rotation.
   *
   * @param node The node to rotate from.
   */
  private void rotateLeft(Node node) {
    Node par = node.parent, right = node.right;
    node.right = right.left;
    if (right.left != null) right.left.parent = node;
    right.left = node;
    node.parent = right;
    replace(par, node, right);
  }

  /*
   * Replace the child of the parent node.
   */
  private void replace(Node par, Node oldChild, Node newChild) {
    if (par == null) root = newChild;
    else if (par.left == oldChild) par.left = newChild;
    else if (par.right == oldChild) par.right = newChild;
    else throw new IllegalStateException("Node is not a child of its parent.");
    if (newChild != null) newChild.parent = par;
  }

  /*
   * A recursive helper method for building the toString
   * string builder.
   *
   * @param node The node to start from.
   * @param builder The string builder to append to.
   */
  private void toStringHelper(Node node, StringBuilder builder) {
    builder.append(node.data);

    if (node.left != null) {
      builder.append(" L{");
      toStringHelper(node.left, builder);
      builder.append("}");
    }

    if (node.right != null) {
      builder.append(" R{");
      toStringHelper(node.right, builder);
      builder.append("}");
    }
  }
}
