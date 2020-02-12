package org.github.java.yactci.solutions;

import org.github.java.yactci.coreapi.annotation.BigO;
import org.github.java.yactci.coreapi.annotation.SpaceComplexity;
import org.github.java.yactci.coreapi.annotation.TimeComplexity;
import org.github.java.yactci.solutionapi.C1Q5_OneAwayAlgorithm;

import java.util.stream.IntStream;

/** @author Said Ucar */
public class C1Q5_OneAway implements C1Q5_OneAwayAlgorithm {

  @Override
  public boolean areStringsOneAway(String first, String second) {
    if (Math.abs(first.length() - second.length()) > 1) {
      return false;
    }

    if (first.equals(second)) {
      return true;
    }

    /*
     * replace a char -> same length
     */
    if (first.length() == second.length()) {
      return areStringsOneReplacementAwayFaster(first, second);
    }

    /*
     * insert a char == remove a char -> not equal lengths
     */
    if (first.length() > second.length()) {
      return isSecondStringOneInsertionAway(first, second);
    } else {
      return isSecondStringOneInsertionAway(second, first);
    }
  }

  /**
   * checks if the given second string only one character less than first string.
   *
   * <p>ex: pale, ple
   *
   * <p>ex: pales, pale
   *
   * @param first first input
   * @param second second input
   * @return true if one insertion away
   */
  @TimeComplexity(worst = BigO.LINEAR)
  @SpaceComplexity(average = BigO.CONSTANT)
  private boolean isSecondStringOneInsertionAway(String first, String second) {
    boolean inserted = false;
    for (int i = 0, j = 0; i < second.length(); i++, j++) {
      if (first.charAt(j) != second.charAt(i)) {
        // first time or ?
        if (!inserted) {
          // now on, should check if first(i+1) == second(i)
          j++;
          inserted = true;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * checks if the given two equal length strings are one replacement of char away
   *
   * <p>ex: pale, bale
   *
   * @param first first input
   * @param second second input
   * @return true if one replacement away
   */
  @TimeComplexity(best = BigO.LINEAR)
  @SpaceComplexity(average = BigO.CONSTANT)
  private boolean areStringsOneReplacementAway(String first, String second) {
    return IntStream.range(0, first.length())
            .boxed()
            .filter(index -> first.charAt(index) != second.charAt(index))
            .count()
        <= 1;
  }

  /**
   * this method also checks if the given two equal length strings are one replacement of char away.
   * Unlike the other implementation, this method returns as soon as found the second replacement.
   *
   * @param first first input
   * @param second second input
   * @return true if one replacement away
   */
  @TimeComplexity(average = BigO.LINEAR)
  @SpaceComplexity(average = BigO.CONSTANT)
  private boolean areStringsOneReplacementAwayFaster(String first, String second) {
    boolean replaced = false;
    for (int i = 0; i < first.length(); i++) {
      if (first.charAt(i) != second.charAt(i)) {
        if (!replaced) {
          replaced = true;
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
