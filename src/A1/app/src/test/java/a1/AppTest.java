package a1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {
  @Test
  void chainingTestCase1() {
    assertEquals(new Chaining(10, 0, -1).chain(1), 30);
  }

  @Test
  void chainingTestCase2() {
    assertEquals(new Chaining(10, 0, -1).chain(4), 25);
  }

  @Test
  void chainingTestCase3() {
    assertEquals(new Chaining(10, 0, -1).chain(8), 19);
  }

  @Test
  void openAddressingTestCase1() {
    assertEquals(new OpenAddressing(10, 0, -1).probe(1, 0), 30);
  }

  @Test
  void openAddressingTestCase2() {
    assertEquals(new OpenAddressing(10, 0, -1).probe(1, 1), 31);
  }

  @Test
  void openAddressingTestCase3() {
    assertEquals(new OpenAddressing(10, 0, -1).probe(1, 3), 1);
  }

  @Test
  void openAddressingTestCase4() {
    assertEquals(new OpenAddressing(10, 0, -1).probe(2, 0), 28);
  }

  @Test
  void openAddressingTestCase5() {
    OpenAddressing openAddressing = new OpenAddressing(10, 0, -1);

    openAddressing.removeKey(0);

    assertEquals(openAddressing.Table[0], -1);
  }

  @Test
  void openAddressingTestCase6() {
    OpenAddressing openAddressing = new OpenAddressing(10, 0, -1);

    openAddressing.insertKey(32);
    openAddressing.insertKey(52);
    openAddressing.insertKey(72);
    openAddressing.removeKey(52);
    openAddressing.insertKey(92);

    assertEquals(openAddressing.Table[13], 32);
    assertEquals(openAddressing.Table[14], 92);
    assertEquals(openAddressing.Table[15], 72);
  }

  void openAddressingTestCase7() {
    OpenAddressing openAddressing = new OpenAddressing(10, 0, -1);

    openAddressing.insertKey(69);
    openAddressing.insertKey(89);
    openAddressing.insertKey(109);
    openAddressing.insertKey(129);

    assertEquals(openAddressing.removeKey(109), 2);
  }
}
