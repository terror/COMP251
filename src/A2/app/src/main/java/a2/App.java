package a2;

public class App {
  public static void main(String[] args) {
    System.out.println(A2_Q2.change(new int[] {1, 2, 4, 8}));
    System.out.println(A2_Q2.change(new int[] {1, 5, 8}));
    System.out.println(A2_Q2.change(new int[] {1, 3, 4}));
    System.out.println(A2_Q2.change(new int[] {1, 5, 10, 25, 100, 200}));

    int[] arr = new int[101];

    for (int i = 0; i < arr.length; ++i)
      arr[i] = (i + 100_000);

    System.out.println(A2_Q2.change(arr));
  }
}
