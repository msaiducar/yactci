package org.github.java.yactci.solutions;

import org.github.java.yactci.coreapi.annotation.BigO;
import org.github.java.yactci.coreapi.annotation.SpaceComplexity;
import org.github.java.yactci.coreapi.annotation.TimeComplexity;
import org.github.java.yactci.coreimpl.collect.HashTableCounter;
import org.github.java.yactci.coreimpl.math.ArrayBitMap;
import org.github.java.yactci.solutionapi.C1Q4_PalindromePermutationAlgorithm;

import static org.github.java.yactci.solutions.C1Q1_IsUnique.UNIQUE_CHAR_COUNT;

/** @author Said Ucar */
public class C1Q4_PalindromePermutation implements C1Q4_PalindromePermutationAlgorithm {

  @Override
  @TimeComplexity(average = BigO.LINEAR)
  @SpaceComplexity(average = BigO.LINEAR)
  public boolean isStringPermutationOfPalindrome(String input) {
    HashTableCounter<Character> counter =
        HashTableCounter.of(
            input
                .chars()
                .mapToObj(c -> (char) c)
                .filter(character -> !character.equals(' '))
                .toArray(Character[]::new));

    long oddCounts = counter.countStream().filter(count -> count % 2 == 1).count();

    return (oddCounts <= 1);
  }

  /**
   * this version of algorithm is better in space constraint.
   *
   * @param input to be checked
   * @return true if input permutation of palindrome
   */
  @TimeComplexity(average = BigO.LINEAR)
  @SpaceComplexity(average = BigO.CONSTANT)
  public boolean isStringPermutationOfPalindrome2(String input) {
    ArrayBitMap bitMap = ArrayBitMap.of(UNIQUE_CHAR_COUNT);

    input.chars().filter(i -> ' ' != i).forEach(bitMap::toggle);

    return bitMap.setCount() <= 1;
  }
}
