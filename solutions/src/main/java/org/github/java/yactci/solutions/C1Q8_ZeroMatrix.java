package org.github.java.yactci.solutions;

import org.github.java.yactci.coreapi.annotation.BigO;
import org.github.java.yactci.coreapi.annotation.SpaceComplexity;
import org.github.java.yactci.coreapi.annotation.TimeComplexity;
import org.github.java.yactci.coreapi.math.BitwiseOperation;
import org.github.java.yactci.coreimpl.math.ArrayBitMap;
import org.github.java.yactci.solutionapi.C1Q8_ZeroMatrixAlgorithm;

/** @author Said Ucar */
public class C1Q8_ZeroMatrix implements C1Q8_ZeroMatrixAlgorithm {

  @Override
  @TimeComplexity(average = BigO.LINEAR)
  @SpaceComplexity(average = BigO.CONSTANT)
  public int[][] zeroRowsAndColumns(int[][] input, int m, int n) {
    BitwiseOperation rows = ArrayBitMap.of(m);
    BitwiseOperation columns = ArrayBitMap.of(n);

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (input[i][j] == 0) {
          rows.set(i);
          columns.set(j);
        }
      }
    }

    rows.setIndexes().forEach(row -> clearRow(input, row));
    columns.setIndexes().forEach(column -> clearColumn(input, column));

    return input;
  }

  private void clearRow(int[][] input, int row) {
    for (int j = 0; j < input[0].length; j++) {
      input[row][j] = 0;
    }
  }

  private void clearColumn(int[][] input, int column) {
    for (int i = 0; i < input.length; i++) {
      input[i][column] = 0;
    }
  }
}
