package org.github.java.yactci.solutionapi;

/**
 * Chapter I - Question IX
 *
 * <p>Assume you have a method isSubstring which checks if one word is a substring of another. Given
 * two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to
 * isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 */
public interface C1Q9_StringRotationAlgorithm {

  /**
   * checks if s2 is a rotation of s1
   *
   * @param s1
   * @param s2
   * @return
   */
  boolean isSubstring(String s1, String s2);
}
