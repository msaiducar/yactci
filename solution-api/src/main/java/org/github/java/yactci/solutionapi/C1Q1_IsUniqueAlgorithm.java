package org.github.java.yactci.solutionapi;

/**
 * Chapter I - Question I
 *
 * <p>Implement an algorithm to determine if a string has all unique characters. What if you cannot
 * use additional data structures?
 *
 * <p>You may assume that the input string is extended ASCII string (256-unique-character)
 */
public interface C1Q1_IsUniqueAlgorithm {

  /**
   * checks if the given {@code str} has all unique characters in it
   *
   * @param str string to be checked
   * @throws NullPointerException if input is null
   * @return true if all unique chars exists, false otherwise
   */
  boolean hasAllUniqueChars(String str);
}
