package org.github.java.yactci.coreimpl.math;

import org.github.java.yactci.coreapi.math.test.BitwiseOperationTest;

class BitwiseOperatorTest implements BitwiseOperationTest<BitwiseOperator> {

  @Override
  public BitwiseOperator createBitwiseOperator(int count) {
    return BitwiseOperator.of(count);
  }
}
