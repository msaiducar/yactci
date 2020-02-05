package org.github.java.yactci.solutions;

import org.github.java.yactci.coreapi.annotation.BigO;
import org.github.java.yactci.coreapi.annotation.SpaceComplexity;
import org.github.java.yactci.coreapi.annotation.TimeComplexity;
import org.github.java.yactci.solutionapi.C1Q3_UrlifyAlgorithm;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has
 * sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string.
 *
 * @author Said Ucar
 */
public class C1Q3_Urlify implements C1Q3_UrlifyAlgorithm {

  @Override
  @TimeComplexity(average = BigO.LINEAR)
  @SpaceComplexity(average = BigO.CONSTANT)
  public char[] escapeWhitespaces(char[] str, int length) {
    int additionalSpaceStartIndex = 2 * getWhitespaceCount(str, length);
    int targetIndex = length + additionalSpaceStartIndex - 1;

    for (int i = length - 1; i >= 0; i--) {
      if (str[i] != ' ') {
        str[targetIndex--] = str[i];
      } else {
        str[targetIndex--] = '0';
        str[targetIndex--] = '2';
        str[targetIndex--] = '%';
      }
    }

    return str;
  }

  /**
   * returns the count of whitespaces in the given array from beginning to the length [0, length).
   *
   * @param str array to be scanned
   * @param length size of the str
   * @return whitespace count
   */
  private int getWhitespaceCount(char[] str, int length) {
    int count = 0;
    for (int i = 0; i < length; i++) {
      if (str[i] == ' ') count++;
    }
    return count;
  }
}
