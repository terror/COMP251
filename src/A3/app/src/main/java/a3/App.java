package a3;

public class App {
  public static void main(String[] args) {
    System.out.println(
        A3Q1.find_exit(
            2,
            new String[][] {
              {"1", "1", "1", "1"},
              {"1", "S", "0", "1"},
              {"1", "0", "1", "1"},
              {"0", "U", "1", "1"}
            }));
    System.out.println(
        A3Q1.find_exit(
            100,
            new String[][] {
              {"1", "1", "1", "1"},
              {"1", "S", "0", "1"},
              {"1", "0", "1", "1"},
              {"0", "L", "1", "1"}
            }));
    System.out.println(
        A3Q1.find_exit(
            1,
            new String[][] {
              {"1", "S", "0", "1"},
              {"1", "0", "0", "1"},
              {"1", "0", "1", "1"},
              {"0", "U", "1", "1"}
            }));
    System.out.println(
        A3Q1.find_exit(
            1,
            new String[][] {
              {"1", "1", "1", "1"},
              {"1", "S", "0", "1"},
              {"1", "0", "1", "1"},
              {"0", "U", "1", "1"}
            }));
    System.out.println(
        A3Q1.find_exit(
            2,
            new String[][] {
              {"1", "1", "1", "1"},
              {"1", "0", "S", "0"},
              {"1", "0", "1", "1"},
              {"0", "U", "1", "1"}
            }));
    System.out.println(
        A3Q1.find_exit(
            4,
            new String[][] {
              {"1", "1", "1", "1", "1"},
              {"0", "1", "S", "1", "0"},
              {"1", "0", "0", "1", "1"},
              {"1", "0", "1", "1", "1"},
            }));
    System.out.println(
        A3Q1.find_exit(
            5,
            new String[][] {
              {"1", "1", "1", "1"},
              {"0", "1", "S", "1"},
              {"1", "L", "0", "1"},
              {"1", "R", "0", "1"},
              {"1", "U", "D", "1"},
            }));
    System.out.println(
        A3Q1.find_exit(
            4,
            new String[][] {
              {"1", "1", "D", "1"},
              {"1", "S", "L", "1"},
              {"0", "R", "1", "1"},
            }));
    System.out.println(
        A3Q1.find_exit(
            0,
            new String[][] {
              {"1"},
              {"S"},
            }));
  }
}
