package org.github.java.yactci.solutions;

import org.github.java.yactci.solutionapi.C1Q1_IsUniqueAlgorithm;

import java.util.Objects;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use
 * * additional data structures?
 */
public class C1Q1_IsUnique implements C1Q1_IsUniqueAlgorithm {

  // 256-character extended ascii
  private static final int UNIQUE_CHAR_COUNT = 256;

  @Override
  public boolean hasAllUniqueChars(String str) {
    Objects.requireNonNull(str);

    if (str.length() > UNIQUE_CHAR_COUNT) return false;

    boolean[] flags = new boolean[UNIQUE_CHAR_COUNT];

    for (char c : str.toCharArray()) {
      if (flags[(int) c]) {
        return false;
      }
      flags[(int) c] = true;
    }

    return true;
  }
}
