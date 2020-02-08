package org.github.java.yactci.solutionapi;

import org.github.java.yactci.coreapi.annotation.BigO;
import org.github.java.yactci.coreapi.annotation.SpaceComplexity;
import org.github.java.yactci.coreapi.annotation.TimeComplexity;

import java.util.Random;

/**
 * Chapter I - Question II
 *
 * <p>Given two strings, write a method to decide if one is a permutation of the other.
 */
public interface C1Q2_CheckPermutationAlgorithm {

  Random r = new Random();

  /**
   * given strings, checks if one is a permutation of the other
   *
   * @param first first string
   * @param second second string
   * @return true if one is a permutation of the other
   */
  boolean stringsArePermutation(String first, String second);

  /**
   * Fisher-Yates Shuffle Algorithm
   *
   * <p>simply shuffles the chars in the given string in a linear time and space complexity.
   *
   * <p>https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm
   *
   * @param str strings to be shuffled
   * @return shuffled string
   */
  @TimeComplexity(best = BigO.LINEAR, average = BigO.LINEAR, worst = BigO.LINEAR)
  @SpaceComplexity(best = BigO.LINEAR, average = BigO.LINEAR, worst = BigO.LINEAR)
  static String shuffleString(String str) {

    char[] arr = str.toCharArray();

    for (int i = arr.length - 1; i > 0; i--) {
      // Pick a random index from 0 to i
      int j = r.nextInt(i + 1);

      // Swap arr[i] with the element at random index
      char temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    return new String(arr);
  }
}
