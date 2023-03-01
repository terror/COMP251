import java.util.*;

public class HW_Sched {
  ArrayList<Assignment> Assignments = new ArrayList<Assignment>();
  int m, lastDeadline = 0;

  public HW_Sched(int[] weights, int[] deadlines, int size) {
    for (int i = 0; i < size; i++) {
      Assignment homework = new Assignment(i, weights[i], deadlines[i]);
      this.Assignments.add(homework);
      if (homework.deadline > lastDeadline) lastDeadline = homework.deadline;
    }
    m = size;
  }

  /**
   * @return Array where output[i] corresponds to the assignment that will be done at time i.
   */
  public int[] SelectAssignments() {
    Collections.sort(Assignments, new Assignment());

    int[] plan = new int[lastDeadline];

    Arrays.fill(plan, -1);

    for (Assignment assignment : Assignments) {
      for (int i = assignment.deadline - 1; i >= 0; --i) {
        if (plan[i] == -1) {
          plan[i] = assignment.number;
          break;
        }
      }
    }

    return plan;
  }
}
