package tree;

public class App {
  public static void main(String[] args) {
    Tree tree = new Tree();

    for (int i = 0; i < 10; ++i) tree.insert(i);

    System.out.println(tree.toString());
  }
}
