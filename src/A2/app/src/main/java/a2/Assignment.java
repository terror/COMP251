package a2;

import java.util.*;

class Assignment implements Comparator<Assignment> {
  int number;
  int weight;
  int deadline;

  protected Assignment() {}

  protected Assignment(int number, int weight, int deadline) {
    this.number = number;
    this.weight = weight;
    this.deadline = deadline;
  }

  @Override
  public int compare(Assignment a1, Assignment a2) {
    return a1.weight == a2.weight
        ? a1.deadline == a2.deadline ? 0 : a1.deadline < a2.deadline ? -1 : 1
        : a1.weight < a2.weight ? 1 : -1;
  }
}
