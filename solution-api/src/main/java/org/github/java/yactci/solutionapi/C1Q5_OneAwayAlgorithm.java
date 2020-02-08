package org.github.java.yactci.solutionapi;

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
public interface C1Q5_OneAwayAlgorithm {

  /**
   * checks if given strings are one edit away
   *
   * @param first first input
   * @param second second input
   * @return true if inputs are one edit away
   */
  boolean areStringsOneAway(String first, String second);
}
