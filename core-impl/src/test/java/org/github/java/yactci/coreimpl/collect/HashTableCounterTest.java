package org.github.java.yactci.coreimpl.collect;

import org.github.java.yactci.coreapi.collect.test.CounterTest;

public class HashTableCounterTest implements CounterTest<HashTableCounter<Object>> {

  @Override
  public HashTableCounter<Object> createCounter(Object[] item) {
    return HashTableCounter.of(item);
  }
}
