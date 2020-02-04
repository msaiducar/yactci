package org.github.java.yactci.solutions;

import org.github.java.yactci.coreapi.annotation.BigO;
import org.github.java.yactci.coreapi.annotation.SpaceComplexity;
import org.github.java.yactci.coreapi.annotation.TimeComplexity;
import org.github.java.yactci.solutionapi.C1Q2_CheckPermutationAlgorithm;

import java.util.HashMap;
import java.util.Objects;

/** Given two strings, write a method to decide if one is a permutation of the other. */
public class C1Q2_CheckPermutation implements C1Q2_CheckPermutationAlgorithm {

  @Override
  @TimeComplexity(average = BigO.LINEAR)
  @SpaceComplexity(average = BigO.CONSTANT)
  public boolean stringsArePermutation(String first, String second) {
    Objects.requireNonNull(first);
    Objects.requireNonNull(second);

    if (first.length() != second.length()) return false;

    if (first.equals(second)) return true;

    HashMap<Integer, Integer> usedChars = new HashMap<>();

    // fill usedChars with first string chars
    first.chars().boxed().forEach(c -> usedChars.put(c, usedChars.getOrDefault(c, 0) + 1));
    // remove second string chars from usedChars
    second.chars().boxed().forEach(c -> usedChars.put(c, usedChars.getOrDefault(c, 0) - 1));

    return usedChars.values().parallelStream().noneMatch(used -> used != 0);
  }
}
