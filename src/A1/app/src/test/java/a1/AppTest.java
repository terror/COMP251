package a1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {
  @Test
  void chainingTestCase1() {
    assertEquals(30, new Chaining(10, 0, -1).chain(1));
  }

  @Test
  void chainingTestCase2() {
    assertEquals(25, new Chaining(10, 0, -1).chain(4));
  }

  @Test
  void chainingTestCase3() {
    assertEquals(19, new Chaining(10, 0, -1).chain(8));
  }

  @Test
  void openAddressingTestCase1() {
    assertEquals(30, new OpenAddressing(10, 0, -1).probe(1, 0));
  }

  @Test
  void openAddressingTestCase2() {
    assertEquals(31, new OpenAddressing(10, 0, -1).probe(1, 1));
  }

  @Test
  void openAddressingTestCase3() {
    assertEquals(1, new OpenAddressing(10, 0, -1).probe(1, 3));
  }

  @Test
  void openAddressingTestCase4() {
    assertEquals(28, new OpenAddressing(10, 0, -1).probe(2, 0));
  }

  @Test
  void openAddressingTestCase5() {
    OpenAddressing openAddressing = new OpenAddressing(10, 0, -1);

    openAddressing.removeKey(0);

    assertEquals(-1, openAddressing.Table[0]);
  }

  @Test
  void openAddressingTestCase6() {
    OpenAddressing openAddressing = new OpenAddressing(10, 0, -1);

    openAddressing.insertKey(32);
    openAddressing.insertKey(52);
    openAddressing.insertKey(72);
    openAddressing.removeKey(52);
    openAddressing.insertKey(92);

    assertEquals(32, openAddressing.Table[13]);
    assertEquals(92, openAddressing.Table[14]);
    assertEquals(72, openAddressing.Table[15]);
  }

  @Test
  void openAddressingTestCase7() {
    OpenAddressing openAddressing = new OpenAddressing(10, 0, -1);

    openAddressing.insertKey(69);
    openAddressing.insertKey(89);
    openAddressing.insertKey(109);
    openAddressing.insertKey(129);

    assertEquals(2, openAddressing.removeKey(109));
  }

  @Test
  void problemTestCase1() {
    assertEquals(3, Problem.elements(new int[] {1, 2, 3, 2, 1}));
  }

  @Test
  void problemTestCase2() {
    assertEquals(
        5,
        Problem.elements(
            new int[] {
              1, 3, 5, 3, 5, 4, 1, 2, 2, 3, 1, 2, 3, 4, 3, 1, 4, 1, 5, 5, 3, 3, 1, 1, 3, 2, 4, 2, 4,
              4, 1, 5, 4, 4, 3, 3, 5, 1, 2, 4, 5, 5, 2, 5, 2, 3, 2, 4, 1, 3, 3, 5, 2, 1, 4, 4, 1, 5,
              2, 2, 4, 2, 5, 5, 1, 2, 4, 2, 5, 4, 2, 3, 5, 5, 5, 2, 5, 5, 5, 3, 4, 4, 2, 3, 2, 5, 3,
              4, 2, 3, 4, 2, 4, 4, 4, 4, 3, 2, 2, 4
            }));
  }

  @Test
  void problemTestCase3() {
    assertEquals(
        1,
        Problem.elements(
            new int[] {
              1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
              1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
              1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
              1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
              1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
              1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
              1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
            }));
  }
}
