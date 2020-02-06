package org.github.java.yactci.coreapi.collect.test;

import org.github.java.yactci.coreapi.collect.Counter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public interface CounterTest<E extends Counter<Object>> {

  E createCounter(Object[] item);

  @Test
  default void nonExistingItemTest() {
    E counter =
        createCounter(
            new String[] {
              "a", "a",
            });
    assertThrows(NullPointerException.class, () -> counter.countOf("b"));
  }

  @Test
  default void simpleTest() {
    E counter = createCounter(new String[] {"aaa", "bbb", "aaa"});

    assertThat(counter.countOf("aaa")).isEqualTo(2);
    assertThat(counter.failSafeCountOf("a", 1)).isEqualTo(1);
    assertThat(counter.sum()).isEqualTo(4);
    assertThat(counter.itemCount()).isEqualTo(3);
    assertThat(counter.failSafeIncrement("a").countOf("a")).isEqualTo(2);
    assertThat(counter.failSafeDecrement("aa").countOf("aa")).isEqualTo(-1);
  }

  @Test
  default void itemCountStreamTest() {
    E counter = createCounter(new String[] {"aaa", "bbb", "aaa"});

    assertThat(counter.itemStream()).containsExactlyInAnyOrder("aaa", "bbb");
    assertThat(counter.countStream()).containsExactlyInAnyOrder(1, 2);
  }
}
