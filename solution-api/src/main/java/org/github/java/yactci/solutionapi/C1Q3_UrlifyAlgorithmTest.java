package org.github.java.yactci.solutionapi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Chapter I - Question III
 *
 * <p>Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the
 * "true" length of the string.
 */
public interface C1Q3_UrlifyAlgorithmTest<E extends C1Q3_UrlifyAlgorithm> {

  /**
   * To take leverage of existing tests for the algorithm, implement this method to return your
   * implementation of {@link C1Q3_UrlifyAlgorithm}
   *
   * @return implementation of {@link C1Q3_UrlifyAlgorithm}
   */
  E createAlgorithm();

  @Test
  default void emptyInputTest() {
    assertThat(createAlgorithm().escapeWhitespaces(new char[] {}, 0)).isEqualTo(new byte[] {});
  }

  @Test
  default void singleWhitespace() {
    char[] arr = {' ', ' ', ' '};
    assertThat(createAlgorithm().escapeWhitespaces(arr, 1)).isEqualTo("%20".toCharArray());
  }

  @Test
  default void bookExampleTest() {
    assertThat(createAlgorithm().escapeWhitespaces("Mr John Smith    ".toCharArray(), 13))
        .isEqualTo("Mr%20John%20Smith".toCharArray());
  }

  @Test
  default void worstStringTest() {
    assertThat(createAlgorithm().escapeWhitespaces(" %20 %20       ".toCharArray(), 9))
        .isEqualTo("%20%20%20%20%20".toCharArray());
  }

  @Test
  default void starWarsTest() {
    String str = "long long ago in a galaxy far far away";
    assertThat(
            createAlgorithm()
                .escapeWhitespaces(
                    "long long ago in a galaxy far far away                ".toCharArray(),
                    str.length()))
        .isEqualTo("long%20long%20ago%20in%20a%20galaxy%20far%20far%20away".toCharArray());
  }
}
