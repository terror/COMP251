package a1;

public class App {
  public static void main(String[] args) {
    DisjointSets myset = new DisjointSets(6);

    System.out.println(myset);
    System.out.println("-> Union 2 and 3");

    myset.union(2, 3);

    System.out.println(myset);
    System.out.println("-> Union 2 and 3");

    myset.union(2, 3);

    System.out.println(myset);
    System.out.println("-> Union 2 and 1");

    myset.union(2, 1);

    System.out.println(myset);
    System.out.println("-> Union 4 and 5");

    myset.union(4, 5);

    System.out.println(myset);
    System.out.println("-> Union 3 and 1");

    myset.union(3, 1);

    System.out.println(myset);
    System.out.println("-> Union 2 and 4");

    myset.union(2, 4);

    System.out.println(myset);
  }
}
