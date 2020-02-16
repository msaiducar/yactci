package org.github.java.yactci.solutionapi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Chapter I - Question IX
 *
 * <p>Assume you have a method isSubstring which checks if one word is a substring of another. Given
 * * two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to
 * isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 */
public interface C1Q9_StringRotationAlgorithmTest<E extends C1Q9_StringRotationAlgorithm> {

  /**
   * To take leverage of existing tests for the algorithm, implement this method to return your
   * implementation of {@link C1Q9_StringRotationAlgorithm}
   *
   * @return implementation of {@link C1Q9_StringRotationAlgorithm}
   */
  E createAlgorithm();

  @Test
  default void falseExampleTest() {
    E algorithm = createAlgorithm();

    assertThat(algorithm.isSubstring("waterbottle", "erbotltewat")).isFalse();
  }

  @Test
  default void bookExampleTest() {
    E algorithm = createAlgorithm();

    assertThat(algorithm.isSubstring("waterbottle", "erbottlewat")).isTrue();
  }
}
