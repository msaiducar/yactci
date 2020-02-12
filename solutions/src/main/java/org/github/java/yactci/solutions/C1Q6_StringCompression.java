package org.github.java.yactci.solutions;

import org.github.java.yactci.coreapi.annotation.BigO;
import org.github.java.yactci.coreapi.annotation.SpaceComplexity;
import org.github.java.yactci.coreapi.annotation.TimeComplexity;
import org.github.java.yactci.solutionapi.C1Q6_StringCompressionAlgorithm;

/** @author Said Ucar */
public class C1Q6_StringCompression implements C1Q6_StringCompressionAlgorithm {

  @Override
  @TimeComplexity(average = BigO.LINEAR)
  @SpaceComplexity(worst = BigO.LINEAR)
  public String compressString(String input) {
    if (input.isEmpty() || input.length() <= 2) return input;

    char last = input.charAt(0);
    int count = 1;

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == last) {
        count++;
      } else {
        sb.append(last);
        sb.append(count);
        last = c;
        count = 1;
      }
    }
    sb.append(last);
    sb.append(count);

    return (sb.length() >= input.length()) ? input : sb.toString();
  }
}
