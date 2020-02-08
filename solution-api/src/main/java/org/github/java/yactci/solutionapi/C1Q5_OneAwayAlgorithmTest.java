package org.github.java.yactci.solutionapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Chapter I - Question V
 *
 * <p>There are three types of edits that can be performed on strings: insert a character, remove a
 * character, or replace a character. Given two strings, write a function to check if they are one
 * edit (or zero edits) away.
 *
 * <p>pale, ple -> true
 *
 * <p>pales, pale -> true
 *
 * <p>pale, bale -> true
 *
 * <p>pale, bake -> false
 */
public interface C1Q5_OneAwayAlgorithmTest<E extends C1Q5_OneAwayAlgorithm> {

  /**
   * To take leverage of existing tests for the algorithm, implement this method to return your
   * implementation of {@link C1Q5_OneAwayAlgorithm}
   *
   * @return implementation of {@link C1Q5_OneAwayAlgorithm}
   */
  E createAlgorithm();

  @Test
  default void impossibleLengthInputsTest() {
    assertThat(createAlgorithm().areStringsOneAway("", "qwerty")).isFalse();
    assertThat(createAlgorithm().areStringsOneAway("qwerty", "")).isFalse();
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        "my precious",
        "may the force be with you",
        "houston, we have a problem",
        "roads? where we're going we don't need roads"
      })
  default void sameInputsTest(String input) {
    assertThat(createAlgorithm().areStringsOneAway(input, input)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        "my precious",
        "may the force be with you",
        "houston, we have a problem",
        "roads? where we're going we don't need roads"
      })
  default void replacementAwayTest(String input) {
    assertThat(createAlgorithm().areStringsOneAway(input, input.replaceFirst("m", "T"))).isTrue();
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        "my precious",
        "may the force be with you",
        "houston, we have a problem",
        "roads? where we're going we don't need roads"
      })
  default void multipleReplacementAwayTest(String input) {
    assertThat(
            createAlgorithm()
                .areStringsOneAway(
                    input,
                    input
                        .replaceFirst(String.valueOf(input.charAt(1)), "#")
                        .replaceFirst(String.valueOf(input.charAt(input.length() - 1)), "@")))
        .isFalse();

    assertThat(
            createAlgorithm()
                .areStringsOneAway(input, C1Q2_CheckPermutationAlgorithm.shuffleString(input)))
        .isFalse();
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        "my precious",
        "may the force be with you",
        "houston, we have a problem",
        "roads? where we're going we don't need roads"
      })
  default void insertAwayTest(String input) {
    String oneInsertAway = input.replaceFirst(String.valueOf(input.charAt(input.length() / 2)), "");

    assertThat(createAlgorithm().areStringsOneAway(input, oneInsertAway)).isTrue();
    assertThat(createAlgorithm().areStringsOneAway(oneInsertAway, input)).isTrue();
  }
}
