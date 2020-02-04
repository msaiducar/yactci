package org.github.java.yactci.solutionapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Chapter I - Question I
 *
 * <p>Implement an algorithm to determine if a string has all unique characters. What if you cannot
 * use additional data structures?
 */
public interface C1Q1_IsUniqueAlgorithmTest<E extends C1Q1_IsUniqueAlgorithm> {

  int MIN_CHAR_VALUE = 0;
  int MAX_CHAR_VALUE = 256;

  /**
   * To take leverage of existing tests for the algorithm, implement this method to return your
   * implementation of {@link C1Q1_IsUniqueAlgorithm}
   *
   * @return implementation of {@link C1Q1_IsUniqueAlgorithm}
   */
  E createAlgorithm();

  @Test
  default void nullInputTest() {
    assertThrows(
        NullPointerException.class,
        () -> {
          createAlgorithm().hasAllUniqueChars(null);
        });
  }

  @Test
  default void emptyInputTest() {
    assertThat(createAlgorithm().hasAllUniqueChars("")).isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {"qwerty", "1230987546", "alons-y"})
  default void simpleUniqueStringsTest(String str) {
    assertThat(createAlgorithm().hasAllUniqueChars(str)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {"qwertyq", "12345678900", "alons-y alonso"})
  default void simpleNonUniqueStringsTest(String str) {
    assertThat(createAlgorithm().hasAllUniqueChars(str)).isFalse();
  }

  @Test
  default void orderedCharsTest() {
    assertThat(createAlgorithm().hasAllUniqueChars(orderedAllUniqueChars())).isTrue();
  }

  @Test
  default void reverseOrderedCharsTest() {
    assertThat(createAlgorithm().hasAllUniqueChars(reverseOrderedAllUniqueChars())).isTrue();
  }

  @Test
  default void randomOrderedCharsTest() {
    assertThat(createAlgorithm().hasAllUniqueChars(randomOrderedAllUniqueChars())).isTrue();
  }

  @Test
  default void orderedCharsFailTest() {
    assertThat(createAlgorithm().hasAllUniqueChars(orderedAllUniqueChars().concat(" "))).isFalse();
  }

  @Test
  default void reverseOrderedCharsFailTest() {
    assertThat(createAlgorithm().hasAllUniqueChars(reverseOrderedAllUniqueChars().concat("42")))
        .isFalse();
  }

  @Test
  default void randomOrderedCharsFailTest() {
    assertThat(createAlgorithm().hasAllUniqueChars(randomOrderedAllUniqueChars().concat("?")))
        .isFalse();
  }

  default String orderedAllUniqueChars() {
    StringBuilder sb = new StringBuilder();
    for (int i = MIN_CHAR_VALUE; i < MAX_CHAR_VALUE; i++) {
      sb.append((char) i);
    }
    return sb.toString();
  }

  default String reverseOrderedAllUniqueChars() {
    StringBuilder sb = new StringBuilder();
    for (int i = MAX_CHAR_VALUE - 1; i >= MIN_CHAR_VALUE; i--) {
      sb.append((char) i);
    }
    return sb.toString();
  }

  default String randomOrderedAllUniqueChars() {
    List<Integer> integers =
        IntStream.range(MIN_CHAR_VALUE, MAX_CHAR_VALUE).boxed().collect(Collectors.toList());

    Collections.shuffle(integers);

    StringBuilder sb = new StringBuilder();

    for (int i : integers) {
      sb.append((char) i);
    }

    return sb.toString();
  }
}
