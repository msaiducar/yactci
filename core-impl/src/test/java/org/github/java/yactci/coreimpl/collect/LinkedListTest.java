package org.github.java.yactci.coreimpl.collect;

import org.github.java.yactci.coreapi.collect.test.ListTest;

public class LinkedListTest implements ListTest<LinkedList> {
  @Override
  public LinkedList createList() {
    return new LinkedList();
  }
}
