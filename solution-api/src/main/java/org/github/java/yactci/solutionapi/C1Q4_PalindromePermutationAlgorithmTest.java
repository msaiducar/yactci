package org.github.java.yactci.solutionapi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Chapter I - Question IV
 *
 * <p>Given a string, write a function to check if it is a permutation of a palindrome. A palindrome
 * is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of
 * letters. The palindrome does not need to be limited to just dictionary words.
 *
 * <p>Input: Tact Coa
 *
 * <p>Output: True (permutations: "taco cat", "atco cta", etc.)
 */
public interface C1Q4_PalindromePermutationAlgorithmTest<
    E extends C1Q4_PalindromePermutationAlgorithm> {

  /**
   * To take leverage of existing tests for the algorithm, implement this method to return your
   * implementation of {@link C1Q4_PalindromePermutationAlgorithm}
   *
   * @return implementation of {@link C1Q4_PalindromePermutationAlgorithm}
   */
  E createAlgorithm();

  @ParameterizedTest
  @ValueSource(
      strings = {
        " ",
        "tact coa",
        "taco cat",
        "atco cta",
        "pay ederek iki kerede yap",
        "was it a car or a cat i saw",
        "murder for a jar of red rum",
        "al kazik cak karaya kayarak kac kizakla",
        "zaman yorar akil kahreder hakli karar oynamaz"
      })
  default void palindromeStringTest(String input) {
    assertThat(createAlgorithm().isStringPermutationOfPalindrome(input)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        "my precious",
        "may the force be with you",
        "houston, we have a problem",
        "roads? where we're going we don't need roads"
      })
  default void nonPalindromeStringTest(String input) {
    assertThat(createAlgorithm().isStringPermutationOfPalindrome(input)).isFalse();
  }
}
