package org.github.java.yactci.solutionapi;

/**
 * Chapter I - Question III
 *
 * <p>Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the
 * "true" length of the string.
 *
 * <p>EXAMPLE Input: "Mr John Smith ", 13
 *
 * <p>Output: "Mr%20John%20Smith"
 */
public interface C1Q3_UrlifyAlgorithm {

  /**
   * replaces {@code " "} with {@code "%20"}
   *
   * @param str character array of string to be escaped
   * @param length true length of array
   * @return escaped string as character array
   */
  char[] escapeWhitespaces(char[] str, int length);
}
