package org.github.java.yactci.coreimpl.math;

import org.github.java.yactci.coreapi.math.test.BitwiseOperationTest;

class ArrayBitMapTest implements BitwiseOperationTest<ArrayBitMap> {

  @Override
  public ArrayBitMap createBitwiseOperator(int count) {
    return ArrayBitMap.of(count);
  }
}
