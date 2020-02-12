package org.github.java.yactci.solutions;

import org.github.java.yactci.solutionapi.C1Q7_RotateMatrixAlgorithm;

/** @author Said Ucar */
public class C1Q7_RotateMatrix implements C1Q7_RotateMatrixAlgorithm {

  @Override
  public short[][] rotateMatrix(short[][] input, int length) {
    if (length < 1) return input;

    int end = length - 1;

    for (int i = 0; i <= (end) / 2; i++) {
      for (int j = i; j < end - i; j++) {
        short p1 = input[i][j];
        short p2 = input[j][end - i];
        short p3 = input[end - i][end - j];
        short p4 = input[end - j][i];

        // Swap values of 4 coordinates.
        input[j][end - i] = p1;
        input[end - i][end - j] = p2;
        input[end - j][i] = p3;
        input[i][j] = p4;
      }
    }

    return input;
  }
}
