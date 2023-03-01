package a2;

import java.util.Arrays;

public class GreedyTester {
  public static void main(String[] args) {
    int[] weights = new int[] {23, 60, 14, 25, 7};
    int[] deadlines = new int[] {3, 1, 2, 1, 3};
    int m = weights.length;
    HW_Sched schedule = new HW_Sched(weights, deadlines, m);
    int[] res = schedule.SelectAssignments();
    System.out.println(Arrays.toString(res));
  }
}
