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
}
