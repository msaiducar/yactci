package org.github.java.yactci.solutionapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Chapter I - Question II
 *
 * <p>Given two strings, write a method to decide if one is a permutation of the other.
 */
public interface C1Q2_CheckPermutationAlgorithmTest<E extends C1Q2_CheckPermutationAlgorithm> {

  /**
   * To take leverage of existing tests for the algorithm, implement this method to return your
   * implementation of {@link C1Q2_CheckPermutationAlgorithm}
   *
   * @return implementation of {@link C1Q2_CheckPermutationAlgorithm}
   */
  E createAlgorithm();

  @Test
  default void nullInputTest() {
    assertThrows(
        NullPointerException.class, () -> createAlgorithm().stringsArePermutation(null, ""));
    assertThrows(
        NullPointerException.class, () -> createAlgorithm().stringsArePermutation("", null));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "42", "qwerty", "long long ago in a galaxy far far away"})
  default void sameInputTest(String str) {
    assertThat(createAlgorithm().stringsArePermutation(str, str)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {"qwerty", "allons-y alonso", "long long ago in a galaxy far far away"})
  default void impossibleBySizeTest(String str) {
    assertThat(createAlgorithm().stringsArePermutation(str, str.concat("42"))).isFalse();
    assertThat(createAlgorithm().stringsArePermutation(str.concat("42"), str)).isFalse();
  }

  @ParameterizedTest
  @ValueSource(strings = {"qwerty", "allons-y alonso", "long long ago in a galaxy far far away"})
  default void shuffledStringTest(String str) {
    E permutationAlgorithm = createAlgorithm();
    assertThat(
            permutationAlgorithm.stringsArePermutation(
                str, C1Q2_CheckPermutationAlgorithm.shuffleString(str)))
        .isTrue();
  }
}
