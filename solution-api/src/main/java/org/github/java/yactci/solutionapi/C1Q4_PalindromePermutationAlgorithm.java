package org.github.java.yactci.solutionapi;

/**
 * Chapter I - Question IV
 *
 * <p>Given a string, write a function to check if it is a permutation of a palindrome. A palindrome
 * is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of
 * letters. The palindrome does not need to be limited to just dictionary words.
 *
 * <p>Input: Tact Coa
 *
 * <p>Output: True (permutations: "taco cat", "atco eta", etc.)
 */
public interface C1Q4_PalindromePermutationAlgorithm {

  /**
   * checks if given string is permutation of a palindrome. Regarding the examples given in the
   * book, whitespaces should be ignored, however algorithm should be case sensitive.
   *
   * @param input str to be checked
   * @return true if input is permutation of palindrome
   */
  boolean isStringPermutationOfPalindrome(String input);
}
