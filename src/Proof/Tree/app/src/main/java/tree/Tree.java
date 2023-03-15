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

    // Depending on the key, we traverse left or right
    // => Same as in BST insertion.
    while (node != null) {
      par = node;
      if (key < node.data) node = node.left;
      else if (key > node.data) node = node.right;
      // Don't insert duplicate nodes
      else throw new IllegalArgumentException("Tree already contains a node with key " + key + ".");
    }

    // Color the new node red
    Node curr = new Node(key, RED);

    // Insert the node based on the key
    if (par == null) root = curr;
    else if (key < par.data) par.left = curr;
    else par.right = curr;

    // Set the parent of the newly inserted node
    curr.parent = par;

    // Fix the red-black tree properties
    fixUp(curr);
  }

  /*
   * Compute the height of this red-black tree.
   *
   * @return The height of the tree.
   */
  public int height() {
    return heightHelper(root);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    toStringHelper(root, builder);
    return builder.toString();
  }

  /*
   * Compute the height of the given tree.
   *
   * @param The node to start from.
   * @return The height of the tree.
   */
  private int heightHelper(Node node) {
    if (node == null) return 0;
    return 1 + Math.max(heightHelper(node.left), heightHelper(node.right));
  }

  /*
   * Fix red-black tree properties after an insertion.
   *
   * @param node The node to initiate the fix from.
   */
  private void fixUp(Node node) {
    Node par = node.parent;

    // Case 1: If the parent is null, we've reached the root, which is the end of the recursion.
    // also, if the parent is black, there's nothing to do since the red-black properties are
    // preserved.
    if (par == null || par.color == BLACK) return;

    // From this point on, the parent is red.
    Node grandparent = par.parent;

    //// Case 2: If the grandparent is null, that means the parent is the root.
    // If we enforce black roots (rule 2), the grandparent will never be null.
    // => Just need to recolor the parent node
    //     R        B
    //      \   ->   \
    //       R        R
    if (grandparent == null) {
      // As this method is only called on red nodes, all we have to do is recolor the root black.
      par.color = BLACK;
      return;
    }

    // Grab the uncle of the parent node
    Node uncle = getUncle(par);

    // Case 3: If the uncle is red, recolor the parent, grandparent, and uncle.
    if (uncle != null && uncle.color == RED) {
      par.color = BLACK;
      grandparent.color = RED;
      uncle.color = BLACK;
      // Recursively fix the grandparent node
      fixUp(grandparent);
      // Parent is the left child of the grandparent.
    } else if (par == grandparent.left) {
      // Case 4a: If the uncle is black and the node is the right child of its parent (forming a
      // left-right zigzag pattern).
      if (node == par.right) {
        rotateLeft(par);
        // Update the parent pointer to the new root node of the rotated subtree.
        par = node;
      }
      // Case 5a: If the uncle is black and the node is the left child of its parent (forming a
      // left-left straight pattern).
      rotateRight(grandparent);
      // Recolor the original parent (now the root of the subtree) and grandparent.
      par.color = BLACK;
      grandparent.color = RED;

      // Parent is the right child of the grandparent.
    } else {
      // Case 4b: If the uncle is black and the node is the left child of its parent (forming a
      // right-left zigzag pattern).
      if (node == par.left) {
        rotateRight(par);
        // Update the parent pointer to the new root node of the rotated subtree.
        par = node;
      }
      // Case 5b: If the uncle is black and the node is the right child of its parent (forming a
      // right-right straight pattern).
      rotateLeft(grandparent);
      // Recolor the original parent (now the root of the subtree) and grandparent.
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
   *
   * @param par The parent node.
   * @param oldChild The old child of the parent.
   * @param newChild The new child to replace the old child with.
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
