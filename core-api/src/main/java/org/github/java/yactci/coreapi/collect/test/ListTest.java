package org.github.java.yactci.coreapi.collect.test;

import org.github.java.yactci.coreapi.collect.List;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public interface ListTest<E extends List> {

  E createList();

  @Test
  default void isListEmptyTest() {
    E list = createList();

    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  default void listSizeTest() {
    E list = createList();

    assertThat(list.size()).isEqualTo(0);
  }

  @Test
  default void addToListTest() {
    E list = createList();

    boolean result = list.add(1f);

    assertThat(result).isTrue();
  }

  @Test
  default void isListAddElementsCorrectlyTest() {
    E list = createList();

    String element = "yactci";
    list.add(element);

    assertThat(list.size()).isEqualTo(1);
    assertThat(list.get(0)).isEqualTo(element);
  }

  @Test
  default void clearListTest() {
    E list = createList();

    int capacity = 10;
    IntStream.range(0, capacity).forEach(list::add);

    assertThat(list.size()).isEqualTo(capacity);

    list.clear();

    assertThat(list.isEmpty()).isTrue();
    assertThat(list.size()).isEqualTo(0);
  }

  @Test
  default void containsTest() {
    E list = createList();

    int capacity = 10;
    IntStream.range(0, capacity).forEach(list::add);

    assertThat(list.contains(capacity + 1)).isFalse();
    assertThat(list.contains(capacity / 2)).isTrue();
  }
}
