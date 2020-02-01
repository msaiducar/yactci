package org.github.java.yactci.coreapi.collect.test;

import org.github.java.yactci.coreapi.collect.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public interface ListTest<E extends List> {

  E createList();

  @Test
  default void firstDummyTest() {
    E list = createList();
    assertFalse(list.isEmpty());
  }
}
