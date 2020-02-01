package org.github.java.yactci.coreimpl.collect;

import org.github.java.yactci.coreapi.collect.test.ListTest;
import org.junit.jupiter.api.DisplayName;

@DisplayName("My ArrayList implementation's Test")
public class ArrayListTest implements ListTest<ArrayList> {
  @Override
  public ArrayList createList() {
    return new ArrayList();
  }
}
