package org.github.java.yactci.solutions;

import org.github.java.yactci.solutionapi.C1Q9_StringRotationAlgorithm;

/** @author Said Ucar */
public class C1Q9_StringRotation implements C1Q9_StringRotationAlgorithm {

  @Override
  public boolean isSubstring(String s1, String s2) {
    return (s2.concat(s2).contains(s1));
  }
}
